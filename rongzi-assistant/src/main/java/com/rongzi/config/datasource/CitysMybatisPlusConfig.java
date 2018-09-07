package com.rongzi.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.rongzi.config.aop.CityDatasourceEnum;
import com.rongzi.core.datasource.DruidProperties;
import com.rongzi.core.mutidatasource.DynamicDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement(order = 2)
@MapperScan(basePackages = {"com.rongzi.assistant.dao"})
public class CitysMybatisPlusConfig {


    private Logger logger= LoggerFactory.getLogger(CitysMybatisPlusConfig.class);

    @Autowired
    DruidProperties druidProperties;


    @Autowired
    CitysDataSourceConfig citysDataSourceConfig;


    /**
     * guns的数据源
     */
    private DruidDataSource dataSourceGuns() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }


    /**
     * 多数据源连接池配置
     */
    @Bean
    public DynamicDataSource mutiDataSource() {

        DynamicDataSource dynamicDataSource = new DynamicDataSource();

        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        DruidDataSource dataSourceGuns = dataSourceGuns();



        try {
            dataSourceGuns.init();

            Map<String, CityDataSourceModel> dataSourceModelMap = citysDataSourceConfig.getMap();

            for (Map.Entry<String, CityDataSourceModel> entry : dataSourceModelMap.entrySet()) {

                DruidDataSource druidDataSource = new DruidDataSource();
                String dataSourceName = entry.getKey();

                CityDataSourceModel sourceModel = entry.getValue();
                druidDataSource.setUrl(sourceModel.getUrl());
                druidDataSource.setUsername(sourceModel.getUsername());
                druidDataSource.setDriverClassName(sourceModel.getDriver());
                druidDataSource.setPassword(sourceModel.getPassword());
                druidDataSource.init();

                logger.info("【"+dataSourceName+"】 数据源正在初始化中");

                hashMap.put(dataSourceName,druidDataSource);
            }

        } catch (SQLException sql) {
            sql.printStackTrace();
        }

        hashMap.put(CityDatasourceEnum.DATA_SOURCE_GUNS, dataSourceGuns);
        dynamicDataSource.setTargetDataSources(hashMap);
        dynamicDataSource.setDefaultTargetDataSource(dataSourceGuns);
        return dynamicDataSource;
    }

    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


    /**
     * 乐观锁mybatis插件
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
}
