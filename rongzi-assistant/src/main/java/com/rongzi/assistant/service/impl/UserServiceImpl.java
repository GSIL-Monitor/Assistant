package com.rongzi.assistant.service.impl;

import com.rongzi.assistant.model.Account;
import com.rongzi.assistant.model.UserInfo;
import com.rongzi.assistant.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserInfo getUserInfo(Account account) {
        UserInfo userInfo = new UserInfo();
        userInfo.setAccountName(account.getLgnAccount());
        userInfo.setEmpCode(account.getEmpCode());
        userInfo.setEmpName(account.getEmpDesc());
        userInfo.setCityCode(account.getCityCode());
        userInfo.setEmpWechatId("wxid_slhv0lqkbac222");
        userInfo.setEmpWorkMobile("");
// TODO
//        userInfo.setCityName("上海");
//        userInfo.setDprCode("dev");
//        userInfo.setDprName("dev");
//        userInfo.setRoleCode("dev");
//        userInfo.setRoleName("dev");
        return userInfo;
    }

}
