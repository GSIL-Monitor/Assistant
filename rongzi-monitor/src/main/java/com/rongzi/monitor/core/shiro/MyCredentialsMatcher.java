package com.rongzi.monitor.core.shiro;

import com.rongzi.core.cache.CacheKit;
import com.rongzi.core.util.SpringContextHolder;
import com.rongzi.monitor.core.common.constant.state.ManagerStatus;
import com.rongzi.monitor.modules.system.dao.UserMapper;
import com.rongzi.monitor.modules.system.model.User;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;


@Component
@DependsOn("springContextHolder")
public class MyCredentialsMatcher extends HashedCredentialsMatcher {


    private Logger logger= LoggerFactory.getLogger(MyCredentialsMatcher.class);

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

        logger.info("开始进入自定义密码比较器中");

        UsernamePasswordToken utoken = (UsernamePasswordToken) token;
        String username = utoken.getUsername();
        String credentials = (String) info.getCredentials();

        UserMapper userMapper = SpringContextHolder.getBean(UserMapper.class);
        User user = userMapper.getByAccount(username);

        AtomicInteger count = CacheKit.get("CONSTANT", username);

        boolean matches = super.doCredentialsMatch(token, info);
        if (matches) {
            CacheKit.remove("CONSTANT", username);
        }else{
            if(count == null){
                count=new AtomicInteger(1);
                CacheKit.put("CONSTANT", username, count);
            }else{
                if (count.incrementAndGet()> 3) {
                    logger.info("----------已经超过3次输入错误的密码了,下一次将锁定---------");
                    user.setStatus( ManagerStatus.FREEZED.getCode());
                    userMapper.updateById(user);
                    throw new ExcessiveAttemptsException();
                }
            }
        }
        return matches;
    }
}
