package com.rongzi.assistant.common.datasource;

import com.rongzi.assistant.common.web.context.UserContextHolder;
import com.rongzi.assistant.model.UserInfo;
import com.rongzi.core.mutidatasource.DataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class CityDataSourceAop implements Ordered {

    private Logger logger = LoggerFactory.getLogger(CityDataSourceAop.class);

    @Pointcut(value = "@annotation(com.rongzi.assistant.common.datasource.CityDataSource)")
    public void cut() {
    }

    @Around("cut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Signature signature = proceedingJoinPoint.getSignature();
        if (!(signature instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }

        MethodSignature methodSignature = (MethodSignature) signature;
        Object target = proceedingJoinPoint.getTarget();
        Method currentMethod = target.getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
        CityDataSource cityDataSource = currentMethod.getAnnotation(CityDataSource.class);
        if (cityDataSource != null) {
            UserInfo currentUserInfo = UserContextHolder.getCurrentUserInfo();
            String name = cityDataSource.name();
            if (name.equals(CityDatasourceEnum.DATA_SOURCE_PRODUCT)) {
                DataSourceContextHolder.setDataSourceType(CityDatasourceEnum.DATA_SOURCE_PRODUCT);
                logger.debug("系统当前所在数据源为：" + CityDatasourceEnum.DATA_SOURCE_PRODUCT);
            } else {
                DataSourceContextHolder.setDataSourceType(currentUserInfo.getCityCode());
                logger.debug("设置当前城市数据源为：" + currentUserInfo.getCityCode());
            }
        } else {
            DataSourceContextHolder.setDataSourceType(CityDatasourceEnum.DATA_SOURCE_GUNS);
            logger.debug("系统当前所在数据源为：" + "DFSSMNG");
        }

        try {
            return proceedingJoinPoint.proceed();
        } finally {
            DataSourceContextHolder.clearDataSourceType();
        }

    }

    @Override
    public int getOrder() {
        return 1;
    }
}
