package com.rongzi.assistant.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.assistant.model.Customer;
import com.rongzi.assistant.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/api/customer")
public class CustomerController {



    @Autowired
    CustomerService customerService;

    @RequestMapping("/list")
    public String findCustomerList(@RequestParam("customerExeStatus") int customerExeStatus
                                   ,@RequestParam("pageSize") String pageSize
                                   ,@RequestParam("pageIndex") String pageIndex
                                    ,@RequestParam("empCode") int empCode){

        Page page=new Page(Integer.parseInt(pageIndex),Integer.parseInt(pageSize));


        List<Customer> customers=customerService.findAllCustomers(page,empCode,customerExeStatus);





           return null;

    }

}
