package com.rongzi.dataSource.dao;

import com.rongzi.dataSource.model.CltBase;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CltBaseMapper {


    List<CltBase> queryCltBaseAll();

}
