package com.rongzi.assistant.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.assistant.common.datasource.AssistantDataSource;
import com.rongzi.assistant.common.datasource.DatasourceEnum;
import com.rongzi.assistant.common.web.context.UserContextHolder;
import com.rongzi.assistant.dao.CustomerMapper;
import com.rongzi.assistant.model.*;
import com.rongzi.assistant.service.RegionService;
import com.rongzi.assistant.service.CustomerInternalService;
import com.rongzi.assistant.service.CustomerService;
import com.rongzi.core.mutidatasource.DataSourceContextHolder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private Logger logger= LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    RegionService regionService;

    @Autowired
    CustomerInternalService customerInternalService;

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public List<Customer> findAllCustomers(Page page, String empCode, int customerExeStatus) {
        List<Customer> resultList = new ArrayList<Customer>();
        List<City> allCities = regionService.findAllCities();
        Map<Integer, String> cityMap = allCities.stream().collect(Collectors.toMap(City::getCityID, City::getCityName));
        List<Customer> customers = customerInternalService.findAllCustomers(page, empCode, customerExeStatus);
        UserInfo currentUser = UserContextHolder.getCurrentUserInfo();
        for (Customer customer : customers) {
            if (!StringUtils.isEmpty(customer.getWorkPlace())) {
                customer.setWorkPlace(cityMap.get(Integer.parseInt(customer.getWorkPlace())));
            } else {
                customer.setWorkPlace(currentUser.getCityName());

            }
            resultList.add(customer);
        }
        return resultList;
    }

    @Override
    @AssistantDataSource(name = DatasourceEnum.DATA_SOURCE_CITY)
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
            Customer customer = customerInternalService.findCustomerCodeAndNameByMobile(callRecord.getMobile());
            if (customer == null) {
                callRecords.remove(callRecord);
                continue;
            }
        }

        if (callRecords.size() <= 0) {
            return true;
//            throw  new GunsException(AssistantExceptionEnum.CUSTOMER_NOT_FOUNT);
        }

        UserInfo currentUser = UserContextHolder.getCurrentUserInfo();
        DataSourceContextHolder.setDataSourceType(currentUser.getCityCode());
        boolean flag = customerMapper.syncContactStatusByCallRecords(callRecords);
        DataSourceContextHolder.clearDataSourceType();
        return flag;
    }

}
