package com.rongzi.monitor.modules.apm.wrapper;

import com.rongzi.monitor.core.common.constant.factory.ConstantFactory;
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
public class TypeExceptionWarpper extends BaseControllerWarpper {

    public TypeExceptionWarpper(Object list) {
        super(list);
    }


    /**
     *
     * Description: 对系统编号进行修改包装转换为systemDetail
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/6/4 0004 10:30
     */
    @Override
    public void warpTheMap(Map<String, Object> map) {


        int systemCode = (int) map.get("SystemCode");
        StringBuffer systemDetail=new StringBuffer();
        systemDetail.append("编号："+systemCode+"-"+" 名称："+ ConstantFactory.me().findSysNameBysysCode(systemCode));
        map.put("systemDetail",systemDetail);
        Date occurDate = (Date)map.get("OccurDate");
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        map.put("OccurDate",dateFormat.format(occurDate));

    }

}
