package com.rongzi.assistant.common.web.context;

import com.rongzi.assistant.common.constant.Constants;
import com.rongzi.assistant.model.UserInfo;
import com.rongzi.core.support.HttpKit;

import javax.servlet.http.HttpServletRequest;

public class UserContextHolder {

    public static UserInfo getCurrentUserInfo() {
        HttpServletRequest httpRequest = HttpKit.getRequest();
        return (UserInfo) httpRequest.getAttribute(Constants.CURRENT_USER_INFO_KEY);
    }

    public static void setCurrentUserInfo(UserInfo userInfo) {
        HttpServletRequest httpRequest = HttpKit.getRequest();
        httpRequest.setAttribute(Constants.CURRENT_USER_INFO_KEY, userInfo);
    }

}
