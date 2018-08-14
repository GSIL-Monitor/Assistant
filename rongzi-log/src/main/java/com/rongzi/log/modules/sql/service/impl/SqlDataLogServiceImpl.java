package com.rongzi.log.modules.sql.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rongzi.log.modules.sql.dao.SqlDataLogMapper;
import com.rongzi.log.modules.sql.model.SqlDataLog;
import com.rongzi.log.modules.sql.service.SqlDataLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SqlDataLogServiceImpl extends ServiceImpl<SqlDataLogMapper, SqlDataLog> implements SqlDataLogService {


    @Autowired
    private SqlDataLogMapper sqlDataLogMapper;

    @Override
    //@DataSource(name = DatasourceEnum.DATA_SOURCE_SQLLOG)
    public boolean insertSqlData(SqlDataLog sqlDataLog) {


        sqlDataLog.setCreatetime(new Date());

        return sqlDataLogMapper.addSql(sqlDataLog);
    }
}
