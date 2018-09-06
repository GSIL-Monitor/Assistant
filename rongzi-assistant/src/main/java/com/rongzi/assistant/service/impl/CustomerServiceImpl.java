package com.rongzi.assistant.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.assistant.common.context.UserContextHolder;
import com.rongzi.assistant.dao.CustomerMapper;
import com.rongzi.assistant.model.CallRecord;
import com.rongzi.assistant.model.City;
import com.rongzi.assistant.model.Customer;
import com.rongzi.assistant.model.UserInfo;
import com.rongzi.assistant.service.ApiService;
import com.rongzi.assistant.service.CityService;
import com.rongzi.assistant.service.CustomerService;
import com.rongzi.config.aop.CityDataSource;
import com.rongzi.config.aop.CityDatasourceEnum;
import com.rongzi.core.mutidatasource.DataSourceContextHolder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerMapper customerMapper;


    @Autowired
    CityService cityService;


    @Autowired
    ApiService apiService;


    @Override
    public List<Customer> findAllCustomers(Page page, String empCode, int customerExeStatus) {

        List<Customer> resultList = new ArrayList<Customer>();

        List<City> allCitys = cityService.findAllCitys();
        Map<Integer, String> cityMap = allCitys.stream().collect(Collectors.toMap(City::getCityID, City::getCityName));

        List<Customer> list = apiService.findAllCustomers(page, empCode, customerExeStatus);

        UserInfo currentUser = UserContextHolder.getCurrentUserInfo();
        for (Customer customer : list) {
            if (!StringUtils.isEmpty(customer.getWorkPlace())) {
                customer.setWorkPlace(cityMap.get(Integer.parseInt(customer.getWorkPlace())));
            } else {
                if (StringUtils.isEmpty(currentUser.getCityName())) {
                    customer.setWorkPlace(currentUser.getCityCode());
                } else {
                    customer.setWorkPlace(currentUser.getCityName());
                }
            }
            resultList.add(customer);
        }

        return resultList;
    }


    @Override
    @CityDataSource(name = CityDatasourceEnum.DATA_SOURCE_CITY)
    public void editCommentByCode(String customerCode, String comment) {

        customerMapper.editCommentByCodeAndComment(customerCode, comment);

    }


    /**
     * 通过通话记录来更新客户的拨打状态
     *
     * @param callRecords
     * @return
     */
    @Override
    public boolean syncContactStatusByCallRecords(List<CallRecord> callRecords) {

        for (int i = 0; i < callRecords.size(); i++) {
            CallRecord callRecord = callRecords.get(i);
            Customer customer = apiService.findCustomerCodeAndCustomerNameByCustomerMobile(callRecord.getMobile());
            if (customer == null) {
                callRecords.remove(callRecord);
            }

        }
        UserInfo currentUser = UserContextHolder.getCurrentUserInfo();
        DataSourceContextHolder.setDataSourceType(currentUser.getCityCode());

        boolean flag = customerMapper.syncContactStatusByCallRecords(callRecords);
        DataSourceContextHolder.clearDataSourceType();
        return flag;
    }


}
