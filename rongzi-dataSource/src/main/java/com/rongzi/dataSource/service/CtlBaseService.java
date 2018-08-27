package com.rongzi.dataSource.service;

import com.rongzi.dataSource.model.CltBase;

import java.util.List;

public interface CtlBaseService {



    List<CltBase>  findCltBaseAll(String datasourceName);
}
