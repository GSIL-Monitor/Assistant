package com.rongzi.common.modules.account.service;

import com.rongzi.common.modules.account.model.User;

import java.util.List;

public interface AccountService {
    void addUser(User user);

    void delUser(User user);

    List<User> findUsers();
}
