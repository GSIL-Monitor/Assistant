package com.rongzi.assistant.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.assistant.common.tips.AssistantTip;
import com.rongzi.assistant.common.util.ValidatorParamUtil;
import com.rongzi.assistant.model.Customer;
import com.rongzi.assistant.model.CustomerListParam;
import com.rongzi.assistant.service.CustomerService;
import com.rongzi.assistant.service.WechatService;
import com.rongzi.core.page.PageInfoBT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.*;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {


    @Autowired
    CustomerService customerService;

    @Autowired
    WechatService wechatService;

    /**
     * 获取客户列表
     *
     * @return
     */
    @PostMapping("/list")
    public AssistantTip findCustomerList(@RequestBody @Valid CustomerListParam customerListParam) {

        Integer[] customerExeStatus = {1, 2, 3, 4, 5, -1};
        List<Integer> status = Arrays.asList(customerExeStatus);
        boolean exeStatusFlag = status.contains(customerListParam.getCustomerExeStatus());
        if (!exeStatusFlag) {
            return AssistantTip.error(500, "客户进程编号无效");
        }

        Page page = null;
        if (customerListParam.getRefreshWX() == 1) {
            /**
             * 调用奥创微信更新
             */
            // TODO 接口现在没有开发。
            page = new Page(customerListParam.getPageIndex(), customerListParam.getPageSize());
            List<Customer> customers = customerService.findAllCustomers(page, customerListParam.getEmpCode(), customerListParam.getCustomerExeStatus());
            Collections.sort(customers);
            page.setRecords(customers);
        } else {
            page = new Page(customerListParam.getPageIndex(), customerListParam.getPageSize());
            List<Customer> customers = customerService.findAllCustomers(page, customerListParam.getEmpCode(), customerListParam.getCustomerExeStatus());
            Collections.sort(customers);
            page.setRecords(customers);
        }
        PageInfoBT<Customer> pageinfo = new PageInfoBT<Customer>(page);
        return AssistantTip.ok(JSON.toJSON(pageinfo));
    }


    /**
     * 编辑客户备注
     *
     * @return
     */
    @PostMapping("/editComment")
    public AssistantTip editComment(@RequestBody @Valid Customer customer, BindingResult bindingResult) {

        AssistantTip assistantTip = new AssistantTip();
        Map<String, Object> bindingResultMap = new HashMap<String, Object>();
        if (bindingResult.hasErrors()) {
            assistantTip = ValidatorParamUtil.getAssistantTip(bindingResult, assistantTip, bindingResultMap);
        } else {
            customerService.editCommentByCode(customer.getCustomerCode(), customer.getComment());
            assistantTip = AssistantTip.ok();
        }
        return assistantTip;
    }

}
