package com.rongzi.common.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class TopicConfig {


    @Bean(name = "sqlqueue")
    public Queue sqlqueue(){
        return new Queue("sql.data",true,false,false,null);
    }





    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("sqlExchange");
    }


    @Bean
    Binding bindingExchangeForMessage (Queue sqlqueue, TopicExchange exchange){

        return BindingBuilder.bind(sqlqueue).to(exchange).with("sql.data");
    }

}
