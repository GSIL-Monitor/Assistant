package com.rongzi.assistant.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.assistant.model.Customer;
import com.rongzi.assistant.model.RequestJsonParam;
import com.rongzi.assistant.service.CustomerService;
import com.rongzi.core.base.controller.BaseController;
import com.rongzi.core.page.PageInfoBT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {


    @Autowired
    CustomerService customerService;


    /**
     * 获取客户列表
     *
     * @return
     */
    @PostMapping("/list")
    public Map<String, Object> findCustomerList(@RequestBody RequestJsonParam requestJsonParam) {

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("msg", "操作成功");
        resultMap.put("code", 0);
        Page page = new Page(requestJsonParam.getPageIndex(), requestJsonParam.getPageSize());

        List<Customer> customers = customerService.findAllCustomers(page, requestJsonParam.getEmpCode(), requestJsonParam.getCustomerExeStatus());

        page.setRecords(customers);

        PageInfoBT<Customer> pageinfo = new PageInfoBT<Customer>(page);
        resultMap.put("data", JSON.toJSON(pageinfo));
        return resultMap;


    }


    /**
     * 编辑客户备注
     *
     * @param customerCode
     * @param comment
     * @return
     */
    @PostMapping("/editComment")
    public Map<String, Object> editComment(@RequestBody Customer customer) {

        customerService.editCommentByCode(customer.getCustomerCode(), customer.getComment());

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("msg", "操作成功");
        resultMap.put("code", 0);
        resultMap.put("data", null);
        return resultMap;
    }


    @PostMapping("/markWechatFriendship")
    public Map<String, Object> markWechatFriendship(@RequestBody RequestJsonParam requestJsonParam) {



        customerService.markWechatFriendship(requestJsonParam.getCustomerMobile(),requestJsonParam.getFriendStatus(),requestJsonParam.getAddFriendTime());

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("msg", "操作成功");
        resultMap.put("code", 0);
        resultMap.put("data", null);
        return resultMap;
    }




}
