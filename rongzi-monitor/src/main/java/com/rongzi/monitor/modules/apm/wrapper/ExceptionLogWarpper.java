package com.rongzi.monitor.modules.apm.wrapper;

import com.rongzi.core.base.warpper.BaseControllerWarpper;
import com.rongzi.monitor.modules.apm.enums.ExceptionLogStatusEnum;

import java.util.Map;

/**
 * 日志列表的包装类
 *
 * @author fengshuonan
 * @date 2017年4月5日22:56:24
 */
public class ExceptionLogWarpper extends BaseControllerWarpper {

    public ExceptionLogWarpper(Object list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        Short status = (Short) map.get("Status");
        if (status != null) {
            int statusCode = (Short) status;
            map.put("Status", ExceptionLogStatusEnum.getMessageByCode(statusCode));
        }
    }


}
