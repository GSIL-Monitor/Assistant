package com.rongzi.assistant.service;

import com.rongzi.assistant.model.UserInfo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserInfo getUserInfo(String empCode) {
        UserInfo userInfo = new UserInfo();
        userInfo.setEmpCode(empCode);
        userInfo.setEmpName("liujunwei");
        userInfo.setCityCode("SHANGHAI");
        userInfo.setCityName("上海");
        userInfo.setDprCode("dev");
        userInfo.setDprName("dev");
        userInfo.setRoleCode("dev");
        userInfo.setRoleName("dev");
        return userInfo;
    }

}
