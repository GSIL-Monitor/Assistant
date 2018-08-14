package com.rongzi.common.modules.account.dao;

import com.rongzi.common.modules.account.model.User;

import java.util.List;

public interface UserManager {
    User getUser(String username);

    void addUser(User user);

    void delUser(User user);

    List<User> findUsers();

}
