package com.rongzi.monitor.modules.nginx.service.impl;

import com.rongzi.monitor.core.common.constant.DatasourceEnum;
import com.rongzi.monitor.modules.nginx.model.nginxtotal;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rongzi.core.mutidatasource.annotion.DataSource;
import com.rongzi.monitor.modules.nginx.dao.NginxTotalMapper;
import com.rongzi.monitor.modules.nginx.service.NginxTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by sun_y on 2018/7/11.
 */
@Service
@Transactional
public class NginxTotalServiceImpl extends ServiceImpl<NginxTotalMapper, nginxtotal> implements NginxTotalService {
    @Autowired
    private NginxTotalMapper nginxTotalMapper;

    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_NGINX)
    public List<Map<String, Object>> queryNginxTotal(String begintime) {
        return nginxTotalMapper.queryNginxTotal(begintime);
    }
    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_NGINX)
    public Boolean addactiontotal(nginxtotal total)
    {
        return nginxTotalMapper.addactiontotal(total);
    }
    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_NGINX)
    public nginxtotal findnginxtotalBydate(String date)
    {
        return nginxTotalMapper.findnginxtotalBydate(date);
    }
    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_NGINX)
    public  List<Map<String, Object>> querynginxtotalforpage(Integer timetype)
    {
        return nginxTotalMapper.querynginxtotalforpage(timetype);
    }

}
