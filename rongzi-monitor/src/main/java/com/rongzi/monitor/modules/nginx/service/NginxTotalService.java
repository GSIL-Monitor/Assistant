package com.rongzi.monitor.modules.nginx.service;

import com.rongzi.monitor.modules.nginx.model.nginxtotal;

import java.util.List;
import java.util.Map;

/**
 * Created by sun_y on 2018/7/11.
 */
public interface NginxTotalService {
    List<Map<String, Object>> queryNginxTotal(String begintime);
    Boolean addactiontotal(nginxtotal total);

    nginxtotal findnginxtotalBydate(String date);

    List<Map<String, Object>> querynginxtotalforpage(Integer timetype);

}
