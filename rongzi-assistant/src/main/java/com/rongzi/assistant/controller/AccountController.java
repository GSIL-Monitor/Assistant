package com.rongzi.assistant.controller;

import com.rongzi.assistant.common.context.UserContextHolder;
import com.rongzi.assistant.common.web.response.R;
import com.rongzi.assistant.manager.TokenManager;
import com.rongzi.assistant.model.Account;
import com.rongzi.assistant.model.UserInfo;
import com.rongzi.assistant.service.AccountService;
import com.rongzi.assistant.service.UserService;
import com.rongzi.core.exception.GunsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public R login(String username, String password) {
        Account account = null;
        try {
            account = accountService.login(username, password);
        } catch (GunsException ex) {
            return R.error(ex.getCode(), ex.getMessage());
        }

        UserInfo userInfo = userService.getUserInfo(account);
        String token = TokenManager.generateToken(userInfo);

        Map<String, Object> data = new HashMap<>();
        data.put("token", token);
        data.put("userInfo", userInfo);
        return R.ok(data);
    }

    @RequestMapping("/test")
    public R test(String username, String password) {
        UserInfo currentUser = UserContextHolder.getCurrentUserInfo();
        System.out.println(currentUser.getEmpName());
        return R.ok();
    }

}
