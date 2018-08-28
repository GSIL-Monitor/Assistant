package com.rongzi.assistant.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.assistant.dao.CustomerMapper;
import com.rongzi.assistant.model.City;
import com.rongzi.assistant.model.Customer;
import com.rongzi.assistant.service.CityService;
import com.rongzi.assistant.service.CustomerService;
import com.rongzi.core.mutidatasource.DataSourceContextHolder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerMapper customerMapper;


    @Autowired
    CityService cityService;


    @Override
    public List<Customer> findAllCustomers(Page page, String empCode, int customerExeStatus) {

        List<Customer> resultList=new ArrayList<Customer>();

        /**
         * 查询所有的城市信息
         */
        List<City> allCitys = cityService.findAllCitys();
        Map<Integer, String> cityMap = allCitys.stream().collect(Collectors.toMap(City::getCityID, City::getCityName));



        DataSourceContextHolder.setDataSourceType("suzhou");
        List<Customer>  list=  customerMapper.queryAllCutomers(page,empCode,customerExeStatus);
        for (Customer customer : list) {
            if(!StringUtils.isEmpty(customer.getWorkPlace())){
                customer.setWorkPlace(cityMap.get(Integer.parseInt(customer.getWorkPlace())));
            }
            resultList.add(customer);
        }
        return resultList;
    }





    @Override
    public void editCommentByCode(String customerCode, String comment) {

        customerMapper.editCommentByCodeAndComment(customerCode,comment);
    }
}
