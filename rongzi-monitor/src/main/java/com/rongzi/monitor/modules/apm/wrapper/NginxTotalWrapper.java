package com.rongzi.monitor.modules.apm.wrapper;

import com.rongzi.core.base.warpper.BaseControllerWarpper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


public class NginxTotalWrapper extends BaseControllerWarpper{
    public NginxTotalWrapper(Object list) {
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

        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date createdate = (Date)map.get("createdate");
        if(createdate!=null){
            map.put("createdate",dateFormat.format(createdate));
        }

        int nginxtotalcount= (int) map.get("nginxtotalcount");
        int nginxover1seccount= (int) map.get("nginxover1seccount");
        int nginxover3seccount= (int) map.get("nginxover3seccount");
        int nginxover10seccount= (int) map.get("nginxover10seccount");
        int iisover1seccount= (int) map.get("iisover1seccount");
        int iisover3seccount= (int) map.get("iisover3seccount");
        int iisover10seccount= (int) map.get("iisover10seccount");
        double nginxover1seccountRate= ((double)nginxover1seccount)/((double)nginxtotalcount);
        int nginxover1seccountRate_10000=(int)(nginxover1seccountRate*10000);

        double nginxover3seccountRate= ((double)nginxover3seccount)/((double)nginxtotalcount);
        int nginxover3seccountRate_10000=(int)(nginxover3seccountRate*100000);

        double nginxover10seccountRate= ((double)nginxover10seccount)/((double)nginxtotalcount);
        int nginxover10seccountRate_10000=(int)(nginxover10seccountRate*1000000);

        double iisover1seccountRate= ((double)iisover1seccount)/((double)nginxtotalcount);
        int iisover1seccountRate_10000=(int)(iisover1seccountRate*10000);

        double iisover3seccountRate= ((double)iisover3seccount)/((double)nginxtotalcount);
        int iisover3seccountRate_10000=(int)(iisover3seccountRate*100000);

        double iisover10seccountRate= ((double)iisover10seccount)/((double)nginxtotalcount);
        int iisover10seccountRate_10000=(int)(iisover10seccountRate*1000000);

        map.put("nginxover1seccountRate_10000",nginxover1seccountRate_10000);
        map.put("nginxover3seccountRate_10000",nginxover3seccountRate_10000);
        map.put("nginxover10seccountRate_10000",nginxover10seccountRate_10000);
        map.put("iisover1seccountRate_10000",iisover1seccountRate_10000);
        map.put("iisover3seccountRate_10000",iisover3seccountRate_10000);
        map.put("iisover10seccountRate_10000",iisover10seccountRate_10000);





    }
}
