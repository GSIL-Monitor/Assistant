package com.rongzi.monitor.modules.apm.service;

import com.rongzi.monitor.modules.apm.model.TypeException;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

public interface TypeExceptionService extends IService<TypeException> {


    /**
     *
     * Description: 根据系统名称和产生日期来查询异常
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/5/16 0016 13:43
     */
    List<Map<String, Object>> queryTypeExceptionsBySysNameAndOccurDate(String SysName,String OccurDate);


    /**
     *
     * Description: 服务端分页：根据系统名称和产生日期来查询异常
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/5/16 0016 13:43
     */
    List<Map<String,Object>> queryPageByServer(Page<TypeException> page, String SysName, String OccurDate, String orderByField, boolean asc);
}
