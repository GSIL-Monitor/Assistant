package com.rongzi.monitor.modules.apm.job;

import com.rongzi.core.mutidatasource.annotion.DataSource;
import com.rongzi.monitor.core.common.constant.DatasourceEnum;
import com.rongzi.monitor.core.util.EmailUtil;
import com.rongzi.monitor.modules.apm.dao.ExceptionLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Profile("prod")
@Component
public class ExceptionLogJob {

    private int exceptionCount;

    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    private ExceptionLogMapper exceptionLogMapper;

    @Scheduled(cron = "0 0/10 * * * *")
    @DataSource(name = DatasourceEnum.DATA_SOURCE_BIZ)
    public void accountExceptionsSum() {
        int latestExceptionCount = exceptionLogMapper.getExceptionSum();

        if (latestExceptionCount > exceptionCount) {
            String mailContent = "系统新发生 【" + (latestExceptionCount - exceptionCount) + "】 个异常，目前总共 【" + latestExceptionCount + "】 个异常，赶紧去检查修复。";
            emailUtil.sendEmail(mailContent, "异常告警");
        }

        exceptionCount = latestExceptionCount;
    }
}
