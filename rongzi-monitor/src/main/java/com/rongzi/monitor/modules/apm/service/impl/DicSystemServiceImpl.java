package com.rongzi.monitor.modules.apm.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rongzi.monitor.core.common.constant.DatasourceEnum;
import com.rongzi.core.mutidatasource.annotion.DataSource;
import com.rongzi.monitor.modules.apm.dao.DicSystemMapper;
import com.rongzi.monitor.modules.apm.model.DicSystem;
import com.rongzi.monitor.modules.apm.service.DicSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DicSystemServiceImpl extends ServiceImpl<DicSystemMapper, DicSystem> implements DicSystemService {

    @Autowired
    private DicSystemMapper dicSystemMapper;

    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_BIZ)
    public List<String> getAllSystemNames() {

        return dicSystemMapper.findAllSystemName();
    }

    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_BIZ)
    public Integer getSysCodeBySysName(String systemName) {
        return dicSystemMapper.findSystemCodeBySystemName(systemName);
    }

    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_BIZ)
    public String getSysNameBySysCode(int SysCode) {
        return dicSystemMapper.findSystemNameBySystemCode(SysCode);
    }

}
