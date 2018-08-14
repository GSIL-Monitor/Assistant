package com.rongzi.monitor.config.job;

import com.rongzi.monitor.core.common.constant.DatasourceEnum;
import com.rongzi.monitor.core.util.EmailUtil;
import com.rongzi.monitor.modules.apm.dao.ExceptionLogMapper;
import com.rongzi.core.mutidatasource.annotion.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Auther: Administrator
 * @Date: 2018/7/2 0002 11:25
 * @Description:
 */
@Profile("prod")
@Component
public class ExceptionLogJob {

    @Autowired
    private ExceptionLogMapper exceptionLogMapper;

    private int exceptionCount;

    @Autowired
    private EmailUtil emailUtil;

    @Scheduled(cron = "0 0/10 * * * *")
    @DataSource(name = DatasourceEnum.DATA_SOURCE_BIZ)
    public void accountExceptionsSum() {
        int exceptionSum = exceptionLogMapper.getExceptionSum();
        System.out.println(exceptionSum + "------------------");
        if (exceptionSum > exceptionCount) {
            String mailContent = "系统新发生 【" + (exceptionSum - exceptionCount) + "】 个异常，目前总共有 【" + exceptionSum + "】 个异常，赶紧去检查修复。";

            emailUtil.sendEmail(mailContent, "异常告警");
        }

        exceptionCount = exceptionSum;
    }
}
