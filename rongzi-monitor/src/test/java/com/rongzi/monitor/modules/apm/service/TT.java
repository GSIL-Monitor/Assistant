package com.rongzi.monitor.modules.apm.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sun_y on 2018/7/5.
 */
public class TT {

    public static void main(String[] args) {

        int i=102;
        int a=27;


        double s1=(double)i;
        double s2=(double)a;

        double ss=(double)(a/i);
        System.out.println(s1/s2);

        String begintime="2018-07-09";
        //String tablename="nginxlog_"+begintime.replace("-","");
        //System.out.println(tablename);

        Date date1=null;
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date1 = format1.parse(begintime);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        String temp_str="";
        Date dt = new Date();
        //最后的aa表示“上午”或“下午”    HH表示24小时制    如果换成hh表示12小时制
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        temp_str=sdf.format(dt);
        Date date2=null;
        try {
        date2=format1.parse(temp_str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(date1.before(date2))
        {
           System.out.println("输入日期小于当前日期");
        }
        else
        {
            System.out.println("输入日期大于或等于当前日期");
        }
        //String tablename="nginxlog_"+begintime.replace("-","");


    }
}
