package com.rongzi.monitor.modules.nginx.service.impl;

import com.rongzi.monitor.core.common.constant.DatasourceEnum;
import com.rongzi.monitor.modules.nginx.dao.NginxMapper;
import com.rongzi.monitor.modules.nginx.service.NginxService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rongzi.core.mutidatasource.annotion.DataSource;
import com.rongzi.monitor.modules.nginx.model.Nginxlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class NginxServiceImpl extends ServiceImpl<NginxMapper, Nginxlog> implements NginxService {

    @Autowired
    private NginxMapper nginxMapper;

    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_NGINX)
    public List<Map<String, Object>> queryNginxAll(Integer overtimelength,Integer isignore,Integer isiis) {
        return nginxMapper.findNginxsAll(overtimelength,isignore,isiis);
    }

    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_NGINX)
    public List<Map<String, Object>> queryPageByServer(Page<Nginxlog> page, String orderByField, boolean asc,Integer overtimelength,Integer isignore) {

        List<Map<String, Object>> result = nginxMapper.findNginxsAllServerPage(page,orderByField,asc,overtimelength,isignore);

        return result;
    }

    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_NGINX)
    public List<Map<String, Object>> queryNginxTotal(String begintime) {
        return nginxMapper.queryNginxTotal(begintime);
    }

    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_NGINX)
    public List<Map<String, Object>> findDetatilByActionandController(String controller, String action) {
        return nginxMapper.getDetatilByActionandController(controller,action);
    }


}
