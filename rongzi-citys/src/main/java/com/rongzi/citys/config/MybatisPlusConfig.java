package com.rongzi.citys.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.rongzi.citys.config.dataSource.BeiJingDataSourceProperties;
import com.rongzi.citys.config.dataSource.ChengDuDataSourceProperties;
import com.rongzi.citys.config.dataSource.DatasourceEnum;
import com.rongzi.core.datasource.DruidProperties;
import com.rongzi.core.mutidatasource.DynamicDataSource;
import com.rongzi.core.mutidatasource.config.MutiDataSourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * MybatisPlus配置
 *
 * @author stylefeng
 * @Date 2017/5/20 21:58
 */
@Configuration
@EnableTransactionManagement(order = 2)//由于引入多数据源，所以让spring事务的aop要在多数据源切换aop的后面
public class MybatisPlusConfig {

    @Autowired
    DruidProperties druidProperties;


    @Autowired
    MutiDataSourceProperties mutiDataSourceProperties;

    @Autowired
    BeiJingDataSourceProperties beiJingDataSourceProperties;

    @Autowired
    ChengDuDataSourceProperties chengDuDataSourceProperties;



    /**
     * 默认数据源
     */
    private DruidDataSource dataSourceGuns() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }



    /**
     * MNG
     */
    private DruidDataSource bizDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        mutiDataSourceProperties.config(dataSource);
        return dataSource;
    }

    /**
     * beijing
     */
    private DruidDataSource beiJingDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        beiJingDataSourceProperties.config(dataSource);
        return dataSource;
    }



    private DruidDataSource chengDuDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        chengDuDataSourceProperties.config(dataSource);
        return dataSource;
    }




    /**
     * 单数据源连接池配置
     */
    @Bean
    @ConditionalOnProperty(prefix = "guns", name = "muti-datasource-open", havingValue = "false")
    public DruidDataSource singleDatasource() {
        return dataSourceGuns();
    }

    /**
     * 多数据源连接池配置
     */
    @Bean
    @ConditionalOnProperty(prefix = "guns", name = "muti-datasource-open", havingValue = "true")
    public DynamicDataSource mutiDataSource() {


        DruidDataSource dataSourceGuns = dataSourceGuns();
        DruidDataSource bizDataSource = bizDataSource();

        DruidDataSource beiJingDataSource = beiJingDataSource();
        DruidDataSource chengDuDataSource = chengDuDataSource();

        try {
            dataSourceGuns.init();
            bizDataSource.init();



            beiJingDataSource().init();
            chengDuDataSource().init();

        } catch (SQLException sql) {
            sql.printStackTrace();
        }

//        DynamicDataSource dynamicDataSource = new DynamicDataSource();

        DynamicDataSource dynamicDataSource = DynamicDataSource.getInstance();

        HashMap<Object, Object> hashMap = new HashMap();
        hashMap.put(DatasourceEnum.DATA_SOURCE_GUNS, dataSourceGuns);
        hashMap.put(DatasourceEnum.DATA_SOURCE_BIZ, bizDataSource);
        hashMap.put(DatasourceEnum.DATA_SOURCE_BEIJING, beiJingDataSource);
        hashMap.put(DatasourceEnum.DATA_SOURCE_CHENGDU, chengDuDataSource);


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
