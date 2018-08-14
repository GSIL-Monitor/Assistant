package com.rongzi.monitor.modules.apm.service;

import com.rongzi.monitor.modules.apm.model.SysException;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

public interface SysExceptionService extends IService<SysException> {


    /**
     * 功能描述: 获取所有的系统异常
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/5/15 0015 10:03
     */
    List<Map<String, Object>> getSysExceptionsAllByOccurDate(String OccurDate);

}
