package com.rongzi.monitor.modules.apm.dao;

import com.rongzi.monitor.modules.apm.model.SysException;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysExceptionMapper extends BaseMapper<SysException> {

    /**
     *
     * Description: 根据记录日期来查询系统异常
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/5/16 0016 14:10
     */
    List<Map<String, Object>>findSysExceptionAllByOccurDate(@Param("time")String time);
}
