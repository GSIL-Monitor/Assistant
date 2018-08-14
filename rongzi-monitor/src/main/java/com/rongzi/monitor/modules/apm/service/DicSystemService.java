package com.rongzi.monitor.modules.apm.service;

import com.rongzi.monitor.modules.apm.model.DicSystem;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

public interface DicSystemService extends IService<DicSystem> {


    /**
     * 功能描述:获取所有的系统名称
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/5/15 0015 10:03
     */
    List<String> getAllSystemNames();


    /**
     * 功能描述:根据系统名称来获取系统编号
     *
     * @param: 
     * @return: 
     * @auther: Administrator
     * @date: 2018/5/15 0015 10:02
     */
    Integer getSysCodeBySysName(String systemName);

    /**
     * 功能描述:根据系统编号来获取系统名称
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/5/15 0015 10:02
     */
    String getSysNameBySysCode(int SysCode);


}
