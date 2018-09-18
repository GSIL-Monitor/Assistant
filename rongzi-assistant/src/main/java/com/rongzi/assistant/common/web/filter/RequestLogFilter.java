package com.rongzi.assistant.common.web.filter;


import com.rongzi.assistant.common.util.IPutil;
import com.rongzi.assistant.common.util.MyRequestUtil;
import com.rongzi.assistant.common.web.RequestLogData;
import com.rongzi.assistant.common.web.wrapper.MyRequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@Order(200)
@Component
@WebFilter(filterName = "RequestLogFilter",urlPatterns = "/*")
public class RequestLogFilter implements Filter {


    Long startTime =null;
    String params="";
    String body =null;

    private Logger logger = LoggerFactory.getLogger(RequestLogFilter.class);

    private String[] excludesPattern = new String[]{
            "/druid/**",
            "/favicon.ico",
            "/swagger*",
    };

    protected PathMatcher pathMatcher = new AntPathMatcher();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {




    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        if (isExclusion(((HttpServletRequest)servletRequest).getRequestURI())) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        RequestLogData requestLogData=new RequestLogData();
        HttpServletRequest httpServletRequest=(HttpServletRequest)servletRequest;

        String contentType = httpServletRequest.getContentType();
        String method = httpServletRequest.getMethod();
        String requestURI = httpServletRequest.getRequestURI();
        String authorization = httpServletRequest.getHeader("Authorization");
        String userAgent = httpServletRequest.getHeader("User-Agent");
        requestLogData.setUserAgent(userAgent);
        requestLogData.setUri(requestURI);
        requestLogData.setClientIp(IPutil.getIpAddr(httpServletRequest));
        requestLogData.setAuthorization(authorization);
        requestLogData.setHttpMethod(method);
        requestLogData.setContentType(contentType);

        ServletRequest requestWrapper =null;
        if("POST".equals(method)){
          requestWrapper = new MyRequestWrapper(httpServletRequest);
            if(contentType.equals("application/x-www-form-urlencoded")){
                Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
                for(Map.Entry<String, String[]> entry: parameterMap.entrySet()){
                    params+=entry.getKey()+"="+entry.getValue()[0]+"&&";
                }
                String finalParams = params.substring(0, params.length() - 2);
                body= finalParams;
            }else if(contentType.equals("multipart/form-data")){
                body=null;
            }else{
                body= MyRequestUtil.getBody(requestWrapper);
            }
            startTime =System.currentTimeMillis();
            filterChain.doFilter(requestWrapper,servletResponse);
            requestLogData.setHttpBody(body);
            requestLogData.setCostTime(System.currentTimeMillis()-startTime);
            logger.info(requestLogData.toString());
        }else{
            startTime =System.currentTimeMillis();
            filterChain.doFilter(servletRequest,servletResponse);
            requestLogData.setCostTime(System.currentTimeMillis()-startTime);
            requestLogData.setHttpBody(body);
            logger.info(requestLogData.toString());
        }
    }

    @Override
    public void destroy() {

    }

    private boolean isExclusion(String requestURI) {
        if (excludesPattern == null || requestURI == null) {
            return false;
        }

        for (String pattern : excludesPattern) {
            if (pathMatcher.match(pattern, requestURI)) {
                return true;
            }
        }

        return false;
    }
}
