package com.rongzi.monitor.modules.nginx.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.monitor.modules.nginx.model.Nginxlog;

import java.util.List;
import java.util.Map;

/**
 * Created by sun_y on 2018/7/3.
 */
public interface NginxService {

    List<Map<String, Object>> queryNginxAll(Integer overtimelength,Integer isignore,Integer isiis);

    List<Map<String,Object>> queryPageByServer(Page<Nginxlog> page, String orderByField, boolean asc,Integer overtimelength,Integer isignore);

    List<Map<String, Object>> queryNginxTotal(String begintime);

    List<Map<String, Object>> findDetatilByActionandController(String controller,String action);


}
