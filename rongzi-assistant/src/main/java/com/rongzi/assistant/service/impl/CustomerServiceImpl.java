package com.rongzi.assistant.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.assistant.common.datasource.AssistantDataSource;
import com.rongzi.assistant.common.datasource.AssistantDatasourceEnum;
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
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    RegionService regionService;

    @Autowired
    CustomerInternalService customerInternalService;

    @Autowired
    CustomerMapper customerMapper;

    /**
     * @return java.util.List<com.rongzi.assistant.model.Customer>
     * @Author xulei
     * @Description 查询客户列表
     * @Date 17:46 2018/10/12
     * @Param [page, empCode, customerExeStatus]
     **/
    @Override
    public List<Customer> findAllCustomers(Page page, String empCode, int customerExeStatus) {
        List<Customer> resultList = new ArrayList<Customer>();
        List<Customer> customers = customerInternalService.findAllCustomers(page, empCode, customerExeStatus);
        findRequiredCustomers(customers, resultList);
        return resultList;
    }

    /**
     * @return void
     * @Author xulei
     * @Description 通过客户编号来更改备注信息
     * @Date 17:46 2018/10/12
     * @Param [customerCode, comment]
     **/
    @Override
    @AssistantDataSource(name = AssistantDatasourceEnum.DATA_SOURCE_CITY)
    public void editCommentByCode(String customerCode, String comment) {
        customerMapper.editCommentByCodeAndComment(customerCode, comment);
    }

    /**
     * 通过通话记录来更新客户的拨打状态
     *
     * @return boolean
     * @Author xulei
     * @Date 17:47 2018/10/12
     * @Param [callRecords]
     **/
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

    /**
     * 查询满足搜索条件的客户信息
     *
     * @return java.util.List<com.rongzi.assistant.model.Customer>
     * @Author xulei
     * @Date 16:40 2018/10/12
     * @Param [page, empCode, contactStatus, contractType, customerExeStatus, searchName, payStartTime, payEndTime]
     **/
    @Override
    public List<Customer> searchAllCustomersByCondition(Page page, String empCode, List<Integer> contactStatus, Integer contractType, Integer customerExeStatus, String searchName, Date payStartTime, Date payEndTime) {

        List<Customer> customers = customerInternalService.searchCustomersByCondition(page, empCode, contactStatus, contractType, customerExeStatus, searchName, payStartTime, payEndTime);
        List<Customer> resultList = new ArrayList<Customer>();
        findRequiredCustomers(customers, resultList);
        return resultList;

    }

    /**
     * 公用查询代码抽取
     *
     * @Author xulei
     * @Date 17:56 2018/10/12
     * @Param [customers, resultList]
     * @return void
     **/
    public void findRequiredCustomers(List<Customer> customers, List<Customer> resultList) {
        List<City> allCities = regionService.findAllCities();
        Map<Integer, String> cityMap = allCities.stream().collect(Collectors.toMap(City::getCityID, City::getCityName));
        UserInfo currentUser = UserContextHolder.getCurrentUserInfo();
        for (Customer customer : customers) {
            if (!StringUtils.isEmpty(customer.getWorkPlace())) {
                customer.setWorkPlace(cityMap.get(Integer.parseInt(customer.getWorkPlace())));
            } else {
                customer.setWorkPlace(currentUser.getCityName());
            }
            Integer customerContractType = customer.getContractType();
            if (customerContractType!=null) {
                if (customerContractType == 1) {
                    customer.setContractType(1);
                } else if (customerContractType >= 2 || customerContractType <= 3) {
                    customer.setContractType(2);
                } else {
                    customer.setContractType(3);
                }
            }
            resultList.add(customer);
        }
    }

}
