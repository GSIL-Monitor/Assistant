package com.rongzi.assistant.common.util;

import com.rongzi.assistant.common.constant.IPConstants;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPUtil {


    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || IPConstants.IPADDRESS.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || IPConstants.IPADDRESS.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || IPConstants.IPADDRESS.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (IPConstants.LOCALHOST.equals(ipAddress) || IPConstants.HOST_IP.equals(ipAddress)) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        //"***.***.***.***".length() = 15
        if (ipAddress != null && ipAddress.length() > IPConstants.IPADDRESS_LENGTH) {
            if (ipAddress.indexOf(IPConstants.SPLIT) > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }

    public static String getRequestType(HttpServletRequest request) {
        return request.getHeader("X-Requested-With");
    }
}
