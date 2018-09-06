package com.rongzi.assistant.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.assistant.model.Customer;
import com.rongzi.assistant.model.CustomerListParam;
import com.rongzi.assistant.service.CustomerService;
import com.rongzi.assistant.service.WechatService;
import com.rongzi.core.page.PageInfoBT;
import com.rongzi.util.ValidatorParamUtil;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

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
    public Map<String, Object> findCustomerList(@RequestBody @Valid CustomerListParam customerListParam, BindingResult bindingResult) {

        Map<String, Object> resultMap = new HashMap<String, Object>();
        Map<String, Object> bindingResultMap = new HashMap<String, Object>();
        Integer[] customerExeStatus = {1, 2, 3, 4, 5, -1};

        List<Integer> status = Arrays.asList(customerExeStatus);

        boolean exeStatusFlag = status.contains(customerListParam.getCustomerExeStatus());
        if (bindingResult.hasErrors() || (!exeStatusFlag)) {

            if (!exeStatusFlag) {
                bindingResultMap.put("customerExeStatus", "客户进程编号异常");
            }
            if (bindingResult.hasErrors()) {
                List<FieldError> fieldErrors = bindingResult.getFieldErrors();
                for (FieldError fieldError : fieldErrors) {
                    String field = fieldError.getField();
                    String defaultMessage = fieldError.getDefaultMessage();
                    bindingResultMap.put(field, defaultMessage);
                }
            }
            resultMap.put("msg", "参数失败");
            resultMap.put("code", -1);
            resultMap.put("data", JSON.toJSON(bindingResultMap));
        } else {
            resultMap.put("msg", "操作成功");
            resultMap.put("code", 0);

            Page page=null;
            if (customerListParam.getRefreshWX() == 1) {


                /**
                 * 调用奥创微信更新
                 */
                // TODO 接口现在没有开发。
                page = new Page(customerListParam.getPageIndex(), customerListParam.getPageSize());
                List<Customer> customers = customerService.findAllCustomers(page, customerListParam.getEmpCode(), customerListParam.getCustomerExeStatus());
                page.setRecords(customers);
            } else {
                page = new Page(customerListParam.getPageIndex(), customerListParam.getPageSize());
                List<Customer> customers = customerService.findAllCustomers(page, customerListParam.getEmpCode(), customerListParam.getCustomerExeStatus());
                page.setRecords(customers);
            }
            PageInfoBT<Customer> pageinfo = new PageInfoBT<Customer>(page);
            resultMap.put("data", JSON.toJSON(pageinfo));
        }
        return resultMap;


    }


    /**
     * 编辑客户备注
     *
     * @return
     */
    @PostMapping("/editComment")
    public Map<String, Object> editComment(@RequestBody @Valid Customer customer, BindingResult bindingResult) {

        Map<String, Object> resultMap = new HashMap<String, Object>();
        Map<String, Object> bindingResultMap = new HashMap<String, Object>();
        if (bindingResult.hasErrors()) {
            ValidatorParamUtil.validatorParams(bindingResult, resultMap, bindingResultMap);
        } else {
            customerService.editCommentByCode(customer.getCustomerCode(), customer.getComment());
            resultMap.put("msg", "操作成功");
            resultMap.put("code", 0);
            resultMap.put("data", null);
        }
        return resultMap;
    }


}
