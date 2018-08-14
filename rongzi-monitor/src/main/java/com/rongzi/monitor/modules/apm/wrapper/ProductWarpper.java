package com.rongzi.monitor.modules.apm.wrapper;

import com.rongzi.core.base.warpper.BaseControllerWarpper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 异常类型的包装类
 *
 * @author
 * @date
 */
public class ProductWarpper extends BaseControllerWarpper {

    public ProductWarpper(Object list) {
        super(list);
    }


    /**
     *
     * Description: 对ProductionDate进行时间修改包装
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/6/4 0004 10:30
     */
    @Override
    public void warpTheMap(Map<String, Object> map) {

        Date productionDate = (Date) map.get("productionDate");
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String productionDateformat = dateFormat.format(productionDate);
        map.put("productionDate",productionDateformat);

    }

}
