package com.rongzi.log.mq.received;


import com.alibaba.fastjson.JSON;
import com.rongzi.log.modules.sql.model.SqlDataLog;
import com.rongzi.log.modules.sql.service.SqlDataLogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataReceive {


    @Autowired
    SqlDataLogService sqlDataLogService;

    @RabbitListener(queues="sql.data")
    public void process(String message) {

        try {

            SqlDataLog SqlDataLog = JSON.parseObject(message,SqlDataLog.class);

            sqlDataLogService.insertSqlData(SqlDataLog);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}


