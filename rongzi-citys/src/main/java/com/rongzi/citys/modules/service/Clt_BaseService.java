package com.rongzi.citys.modules.service;


import com.rongzi.citys.modules.model.Clt_base;

import java.util.List;

public interface Clt_BaseService {


    List<Clt_base> findClt_baseByCityTag(String CityTag);


}
