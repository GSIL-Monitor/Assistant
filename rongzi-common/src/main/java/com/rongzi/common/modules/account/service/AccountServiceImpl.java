package com.rongzi.common.modules.account.service;

import com.rongzi.common.modules.account.dao.UserManager;
import com.rongzi.common.modules.account.model.User;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private UserManager userManager;

    public AccountServiceImpl(UserManager userManager) {
        this.userManager = userManager;
    }

    public void addUser(User user) {
        userManager.addUser(user);
    }

    public void delUser(User user) {
        userManager.delUser(user);
    }

    public List<User> findUsers() {
        return userManager.findUsers();
    }
}
