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
public class SysExceptionWarpper extends BaseControllerWarpper {

    public SysExceptionWarpper(Object list) {
        super(list);
    }


    /**
     *
     * Description: 对时间进行修改包装
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/6/4 0004 10:30
     */
    @Override
    public void warpTheMap(Map<String, Object> map) {

        Date occurDate = (Date)map.get("OccurDate");
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        map.put("OccurDate",dateFormat.format(occurDate));

    }

}
