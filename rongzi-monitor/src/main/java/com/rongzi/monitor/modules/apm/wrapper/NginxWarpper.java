package com.rongzi.monitor.modules.apm.wrapper;

import com.rongzi.core.base.warpper.BaseControllerWarpper;

import java.util.Map;

/**
 * 异常类型的包装类
 *
 * @author
 * @date
 */
public class NginxWarpper extends BaseControllerWarpper {



    public NginxWarpper(Object list) {
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


        int count0= (int) map.get("count");
        int allcount0= (int) map.get("allcount");
        double overtimerate= ((double)count0)/((double)allcount0);
        int rate=(int)(overtimerate*10000);

        map.put("overtimerate",rate);





    }

}
