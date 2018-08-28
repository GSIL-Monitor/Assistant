package com.rongzi.assistant.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.rongzi.assistant.model.Account;
import com.rongzi.assistant.dao.AccountMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rongzi.assistant.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rongzi123
 * @since 2018-08-27
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Override
    public Account login(String username, String password) {
        EntityWrapper<Account> wrapper = new EntityWrapper<>();
        wrapper.eq("LGN_ACCOUNT", username);
        Account account = selectOne(wrapper);

        return  account;
    }
}
