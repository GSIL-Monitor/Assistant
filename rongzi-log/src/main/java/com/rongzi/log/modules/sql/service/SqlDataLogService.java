package com.rongzi.log.modules.sql.service;

import com.baomidou.mybatisplus.service.IService;
import com.rongzi.log.modules.sql.model.SqlDataLog;

/**
 * @Auther: Administrator
 * @Date: 2018/8/7 0007
 * @Description:
 */
public interface SqlDataLogService extends IService<SqlDataLog> {


    boolean insertSqlData(SqlDataLog sqlDataLog);
}
