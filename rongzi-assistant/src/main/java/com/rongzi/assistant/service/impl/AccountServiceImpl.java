package com.rongzi.assistant.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rongzi.assistant.common.exception.RongziExceptionEnum;
import com.rongzi.assistant.dao.AccountMapper;
import com.rongzi.assistant.model.Account;
import com.rongzi.assistant.service.AccountService;
import com.rongzi.core.exception.GunsException;
import com.rongzi.core.util.DesUtil;
import com.rongzi.core.util.MD5Util;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author rongzi123
 * @since 2018-08-27
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Override
    public Account login(String username, String password) throws GunsException {
        EntityWrapper<Account> wrapper = new EntityWrapper<>();
        wrapper.eq("SUBSTRING(EMP_CODE, 3, 10)", username);
        Account account = selectOne(wrapper);
        if (account == null) {
            throw new GunsException(RongziExceptionEnum.WRONG_USERNAME_PASSWORD);
        }

        String clearText = null;
        try {
            clearText = DesUtil.decrypt(account.getLgnPswd(), "ddddffff");
        } catch (Exception e) {
            throw new GunsException(RongziExceptionEnum.WRONG_USERNAME_PASSWORD);
        }

        String truePassword = MD5Util.encrypt(clearText);
        if (!password.equals(truePassword)) {
            throw new GunsException(RongziExceptionEnum.WRONG_USERNAME_PASSWORD);
        }

        return account;
    }
}
