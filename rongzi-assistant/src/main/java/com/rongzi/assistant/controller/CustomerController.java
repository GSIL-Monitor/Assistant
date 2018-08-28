package com.rongzi.assistant.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.assistant.model.Customer;
import com.rongzi.assistant.service.CustomerService;
import com.rongzi.core.base.controller.BaseController;
import com.rongzi.core.page.PageInfoBT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {


    @Autowired
    CustomerService customerService;

    /**
     *  获取客户列表
     * @param customerExeStatus
     * @param pageSize
     * @param pageIndex
     * @param empCode
     * @return
     */
    @PostMapping("/list")
    public Map<String, Object> findCustomerList(@RequestParam("customerExeStatus") int customerExeStatus
            , @RequestParam("pageSize") int pageSize
            , @RequestParam("pageIndex") int pageIndex
            , @RequestParam("empCode") String empCode) {




        Page page = new Page(pageIndex, pageSize);

        List<Customer> customers = customerService.findAllCustomers(page, empCode, customerExeStatus);

        page.setRecords(customers);

        PageInfoBT<Customer> pageinfo = new PageInfoBT<Customer>(page);

        Map<String, Object> resultMap = new HashMap<String, Object>();

        resultMap.put("msg", "操作成功");
        resultMap.put("code", 0);
        resultMap.put("data", JSON.toJSONString(pageinfo));

        return resultMap;

    }

    /**
     * 编辑客户备注
     * @param customerCode
     * @param comment
     * @return
     */
    @PostMapping("/editComment")
    public Map<String, Object> editComment(@RequestParam("customerCode") String customerCode, @RequestParam("comment") String comment) {


        customerService.editCommentByCode(customerCode, comment);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("msg", "操作成功");
        resultMap.put("code", 0);
        resultMap.put("data", null);
        return resultMap;
    }

}
