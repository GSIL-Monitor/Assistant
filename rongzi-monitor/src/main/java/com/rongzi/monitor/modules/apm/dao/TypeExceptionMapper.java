package com.rongzi.monitor.modules.apm.dao;

import com.rongzi.monitor.modules.apm.model.TypeException;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TypeExceptionMapper extends BaseMapper<TypeException> {

    /**
     *
     * Description:根据系统编号和异常产生时间来查询异常
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/5/16 0016 13:21
     */
    List<Map<String, Object>> findTypeExceptionByCodeAndOccurDate(@Param("code") int code, @Param("OccurDate") String OccurDate);


    /**
     *
     * Description:开启服务端分页
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/6/4 0004 9:54
     */
    List<Map<String, Object>> findTypeExceptionByCodeAndOccurDatePage(@Param("page")Page<TypeException>page, @Param("code") int code, @Param("OccurDate") String OccurDate,@Param("orderByField") String orderByField, @Param("isAsc") boolean isAsc);
}
