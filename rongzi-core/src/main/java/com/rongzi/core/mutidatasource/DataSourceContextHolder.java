package com.rongzi.core.mutidatasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * datasource的上下文
 *
 * @author fengshuonan
 * @date 2017年3月5日 上午9:10:58
 */
public class DataSourceContextHolder {

    private static Logger logger= LoggerFactory.getLogger(DataSourceContextHolder.class);

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    /**
     * 设置数据源类型
     *
     * @param dataSourceType 数据库类型
     */
    public static void setDataSourceType(String dataSourceType) {

        logger.info("切换到 {"+dataSourceType+ " }数据源");

        contextHolder.set(dataSourceType);
    }

    /**
     * 获取数据源类型
     */
    public static String getDataSourceType() {

        return contextHolder.get();
    }

    /**
     * 清除数据源类型
     */
    public static void clearDataSourceType() {
        contextHolder.remove();
    }
}
