package com.rongzi.assistant.common.context;

import com.rongzi.assistant.common.constant.Constants;
import com.rongzi.assistant.model.UserInfo;
import com.rongzi.core.support.HttpKit;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class UserContextHolder {

    public static UserInfo getCurrentUserInfo() {
        HttpServletRequest httpRequest = HttpKit.getRequest();
        return (UserInfo)httpRequest.getAttribute(Constants.CURRENT_USER_INFO_KEY );
    }

}
