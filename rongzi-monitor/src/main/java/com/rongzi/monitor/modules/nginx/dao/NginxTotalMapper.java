package com.rongzi.monitor.modules.nginx.dao;

import com.rongzi.monitor.modules.nginx.model.nginxtotal;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

/**
 * Created by sun_y on 2018/7/11.
 */
public interface NginxTotalMapper extends BaseMapper<nginxtotal> {
    List<Map<String, Object>> queryNginxTotal(@Param("begintime") String begintime);
    Boolean addactiontotal(nginxtotal total);

    nginxtotal findnginxtotalBydate(String date);

    List<Map<String, Object>> querynginxtotalforpage(@Param("timetype") Integer timetype);


}
