package com.rongzi.assistant.common.datasource;

/**
 * 多数据源的枚举
 *
 * @author fengshuonan
 * @date 2017年3月5日 上午10:15:02
 */
public interface AssistantDatasourceEnum {

    /**
     * 默认的MNG库
     */
    String DATA_SOURCE_MNG = "DFSSMNG";

    /**
     * 产品数据库
     */
    String DATA_SOURCE_PRODUCT = "PRODUCT";

    /**
     * 城市数据库
     */
    String DATA_SOURCE_CITY = "dataSourceCity";

}
