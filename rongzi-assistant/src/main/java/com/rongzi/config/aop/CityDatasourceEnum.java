package com.rongzi.config.aop;

/**
 * 
 * 多数据源的枚举
 *
 * @author fengshuonan
 * @date 2017年3月5日 上午10:15:02
 */
public interface CityDatasourceEnum {

    /**
     * 默认的MNG库
	 */
	String DATA_SOURCE_GUNS = "dataSourceGuns";


	/**
	 * 单独的产品数据库
	 */
	String DATA_SOURCE_PRODUCT="PRODUCT";


    /**
     * 城市的数据库
	 */
	String DATA_SOURCE_CITY="CITY";



}
