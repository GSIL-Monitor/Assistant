package com.rongzi.assistant.service.impl;

import com.rongzi.assistant.model.Account;
import com.rongzi.assistant.model.City;
import com.rongzi.assistant.model.UserInfo;
import com.rongzi.assistant.service.RegionService;
import com.rongzi.assistant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RegionService regionService;

    @Override
    public UserInfo getUserInfo(Account account) {
        List<City> allCities = regionService.findAllCities();
        Map<String, String> cityMap = allCities.stream().collect(Collectors.toMap(City::getCityCode, City::getCityName));

        UserInfo userInfo = new UserInfo();
        userInfo.setAccountName(account.getLgnAccount());
        userInfo.setEmpCode(account.getEmpCode());
        userInfo.setEmpName(account.getEmpDesc());
        userInfo.setCityCode(account.getCityCode());
        userInfo.setCityName(cityMap.get(account.getCityCode()));
        userInfo.setEmpWechatId(account.getEmpWechatId());
        userInfo.setEmpWorkMobile(account.getEmpWorkMobile());



        return userInfo;
    }

}
