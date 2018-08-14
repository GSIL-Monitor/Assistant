package com.rongzi.monitor.modules.apm.dao;

import com.rongzi.monitor.modules.apm.model.DicSystem;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

public interface DicSystemMapper extends BaseMapper<DicSystem> {

    /**
     * Description: 根据系统名称查询对应的系统编号
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/5/15 0015 15:18
     */
    Integer findSystemCodeBySystemName(String systemName);

    /**
     * Description: 查询所有的系统名称
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/5/15 0015 15:18
     */
    List<String> findAllSystemName();

    /**
     * Description: 根据系统编号查询对应的系统名称
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/5/15 0015 15:18
     */
    String findSystemNameBySystemCode(Integer SysCode);

}
