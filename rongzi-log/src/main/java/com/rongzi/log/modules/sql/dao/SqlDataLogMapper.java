package com.rongzi.log.modules.sql.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.rongzi.log.modules.sql.model.SqlDataLog;

public interface SqlDataLogMapper extends BaseMapper<SqlDataLog> {


    boolean addSql(SqlDataLog sqlDataLog);
}
