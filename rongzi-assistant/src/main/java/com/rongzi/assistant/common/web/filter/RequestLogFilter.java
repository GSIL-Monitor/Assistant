package com.rongzi.assistant.common.web.filter;


import com.rongzi.assistant.common.constant.FilterConstants;
import com.rongzi.assistant.common.util.IPUtil;
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
@WebFilter(filterName = "RequestLogFilter", urlPatterns = "/*")
public class RequestLogFilter implements Filter {

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

        if (isExclusion(((HttpServletRequest) servletRequest).getRequestURI())) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        RequestLogData requestLogData = new RequestLogData();
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String contentType = httpServletRequest.getContentType();
        String method = httpServletRequest.getMethod();
        String requestURI = httpServletRequest.getRequestURI();
        String authorization = httpServletRequest.getHeader("Authorization");
        String userAgent = httpServletRequest.getHeader("User-Agent");
        requestLogData.setUserAgent(userAgent);
        requestLogData.setUri(requestURI);
        requestLogData.setClientIp(IPUtil.getIpAddr(httpServletRequest));
        requestLogData.setAuthorization(authorization);
        requestLogData.setHttpMethod(method);
        requestLogData.setContentType(contentType);

        String body = null;
        if (FilterConstants.REQUEST_METHOD_POST.equals(method)) {
            if (FilterConstants.CONTENTTYPE_FORM.equals(contentType)) {
                Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
                if (parameterMap != null & parameterMap.size() > 0) {
                    String params = "";
                    for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                        params += entry.getKey() + "=" + entry.getValue()[0] + "&";
                    }
                    body = params.substring(0, params.length() - 1);
                }
            } else if (FilterConstants.CONTENTTYPE_UPLOAD.equals(contentType)) {
                body = null;
            } else {
                servletRequest = new MyRequestWrapper(httpServletRequest);
                body = MyRequestUtil.getBody(servletRequest);
            }
        }
        requestLogData.setHttpBody(body);

        Long startTime = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        requestLogData.setCostTime(System.currentTimeMillis() - startTime);
        logger.info(requestLogData.toString());
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
