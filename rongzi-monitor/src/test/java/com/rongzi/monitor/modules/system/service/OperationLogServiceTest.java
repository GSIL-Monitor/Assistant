package com.rongzi.monitor.modules.system.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.monitor.modules.base.BaseJunit;
import com.rongzi.monitor.modules.system.model.OperationLog;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class OperationLogServiceTest extends BaseJunit {

    @Autowired
    private IOperationLogService operationLogService;

    @Test
    public void getOperationLogsTest() {
        Page<OperationLog> page = new Page<OperationLog>(0, 10);
        page.setOpenSort(false);
        List<Map<String, Object>> result = operationLogService.getOperationLogs(page, "2018-05-11", "2018-05-11", "", "", "", false);
        System.out.println(result.size());
        Assert.assertNotNull(result);
    }
}
