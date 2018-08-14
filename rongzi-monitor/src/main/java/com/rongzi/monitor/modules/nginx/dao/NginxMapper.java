package com.rongzi.monitor.modules.nginx.dao;



import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.monitor.modules.nginx.model.Nginxlog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface NginxMapper extends BaseMapper<Nginxlog> {


    List<Map<String, Object>> findNginxsAll(@Param("overtimelength") Integer overtimelength,@Param("isignore") Integer isignore,@Param("isiis") Integer isiis);

    List<Map<String,Object>> findNginxsAllServerPage(@Param("page")Page<Nginxlog> page, @Param("orderByField") String orderByField, @Param("isAsc") boolean isAsc, @Param("overtimelength") Integer overtimelength,@Param("isignore") Integer isignore);

    List<Map<String, Object>> queryNginxTotal(@Param("begintime") String begintime);


    List<Map<String, Object>> getDetatilByActionandController(@Param("controller") String controller,@Param("action") String action);




}
