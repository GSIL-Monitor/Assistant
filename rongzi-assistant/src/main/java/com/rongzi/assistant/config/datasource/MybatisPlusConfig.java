package com.rongzi.assistant.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.rongzi.assistant.common.datasource.DatasourceEnum;
import com.rongzi.assistant.config.datasource.properties.DataSourceModel;
import com.rongzi.assistant.config.datasource.properties.MultiDataSourceProperties;
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
public class MybatisPlusConfig {

    private Logger logger = LoggerFactory.getLogger(MybatisPlusConfig.class);

    @Autowired
    DruidProperties druidProperties;

    @Autowired
    MultiDataSourceProperties multiDataSourceProperties;

    /**
     * 默认数据源(MNG数据源)
     */
    private DruidDataSource mngDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }

    /**
     * 多数据源连接池配置(分城市数据源)
     */
    @Bean
    public DynamicDataSource multiDataSource() {
        HashMap<Object, Object> dataSourceMap = new HashMap<Object, Object>();

        DruidDataSource mngDataSource = mngDataSource();

        try {
            mngDataSource.init();
            dataSourceMap.put(DatasourceEnum.DATA_SOURCE_MNG, mngDataSource);

            Map<String, DataSourceModel> dataSources = multiDataSourceProperties.getDatasources();
            for (Map.Entry<String, DataSourceModel> entry : dataSources.entrySet()) {
                String dataSourceName = entry.getKey();
                DataSourceModel dataSourceModel = entry.getValue();

                DruidDataSource druidDataSource = new DruidDataSource();
                druidProperties.config(druidDataSource);
                druidDataSource.setDriverClassName(dataSourceModel.getDriverClassName());
                druidDataSource.setUrl(dataSourceModel.getUrl());
                druidDataSource.setUsername(dataSourceModel.getUsername());
                druidDataSource.setPassword(dataSourceModel.getPassword());
                druidDataSource.init();

                logger.info("【" + dataSourceName + "】 数据源正在初始化中");

                dataSourceMap.put(dataSourceName, druidDataSource);
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        }

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        dynamicDataSource.setDefaultTargetDataSource(mngDataSource);
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
