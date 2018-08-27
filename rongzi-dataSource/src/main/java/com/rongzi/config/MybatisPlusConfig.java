package com.rongzi.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.rongzi.core.datasource.DruidProperties;
import com.rongzi.core.mutidatasource.DynamicDataSource;
import com.rongzi.core.mutidatasource.annotion.DataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * MybatisPlus配置
 *
 * @author stylefeng
 * @Date 2017/5/20 21:58
 */
@Configuration
@EnableTransactionManagement(order = 2)//由于引入多数据源，所以让spring事务的aop要在多数据源切换aop的后面
@MapperScan(basePackages = {"com.rongzi.datasource.dao"})
public class MybatisPlusConfig {

    @Autowired
    DruidProperties druidProperties;


    @Autowired
    CityDataSourceConfig CityDataSourceConfig;


    /**
     * guns的数据源
     */
    private DruidDataSource dataSourceGuns() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }


    /**
     * 单数据源连接池配置
     */
//    @Bean
//    @ConditionalOnProperty(prefix = "guns", name = "muti-datasource-open", havingValue = "false")
//    public DruidDataSource singleDatasource() {
//        return dataSourceGuns();
//    }

    /**
     * 多数据源连接池配置
     */
    @Bean
//    @ConditionalOnProperty(prefix = "guns", name = "muti-datasource-open", havingValue = "true")
    public DynamicDataSource mutiDataSource() {

        DynamicDataSource dynamicDataSource = new DynamicDataSource();

        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        DruidDataSource dataSourceGuns = dataSourceGuns();



        try {
            dataSourceGuns.init();

            Map<String, DataSourceModel> dataSourceModelMap = CityDataSourceConfig.getMap();

            for (Map.Entry<String, DataSourceModel> entry : dataSourceModelMap.entrySet()) {

                DruidDataSource druidDataSource = new DruidDataSource();
                String dataSourceName = entry.getKey();

                DataSourceModel sourceModel = entry.getValue();
                druidDataSource.setUrl(sourceModel.getUrl());
                druidDataSource.setUsername(sourceModel.getUsername());
                druidDataSource.setDriverClassName(sourceModel.getDriver());
                druidDataSource.setPassword(sourceModel.getPassword());
                druidDataSource.init();


                hashMap.put(dataSourceName,druidDataSource);
            }

        } catch (SQLException sql) {
            sql.printStackTrace();
        }

        hashMap.put(DatasourceEnum.DATA_SOURCE_GUNS, dataSourceGuns);
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
