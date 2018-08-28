package com.rongzi.assistant.service;

import com.baomidou.mybatisplus.service.IService;
import com.rongzi.assistant.model.Account;

public interface AccountService extends IService<Account> {
    Account login(String username, String password);
}
