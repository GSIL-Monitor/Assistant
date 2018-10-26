package com.rongzi.assistant.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.assistant.common.exception.AssistantExceptionEnum;
import com.rongzi.assistant.common.tips.AssistantTip;
import com.rongzi.assistant.common.util.ValidatorParamUtil;
import com.rongzi.assistant.model.Customer;
import com.rongzi.assistant.model.CustomerListParam;
import com.rongzi.assistant.model.CustomerSearchParam;
import com.rongzi.assistant.service.CustomerService;
import com.rongzi.assistant.service.WechatService;
import com.rongzi.core.exception.GunsException;
import com.rongzi.core.page.PageInfoBT;
import com.rongzi.core.support.DateTimeKit;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


    private Logger logger = LoggerFactory.getLogger(CustomerController.class);

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

        boolean exeStatusFlag = ValidatorParamUtil.checkCustomerExeStatus(customerListParam.getCustomerExeStatus());
        if (!exeStatusFlag) {
            return AssistantTip.error(500, "客户进程编号无效");
        }

        List<Customer> customers = null;
        Page page = new Page(customerListParam.getPageIndex(), customerListParam.getPageSize());
        if (customerListParam.getRefreshWX() == 1) {
            /**
             * 调用奥创微信更新
             */
            // TODO 接口现在没有开发。
            customers = customerService.findAllCustomers(page, customerListParam.getEmpCode(), customerListParam.getCustomerExeStatus());
        } else {
            customers = customerService.findAllCustomers(page, customerListParam.getEmpCode(), customerListParam.getCustomerExeStatus());
        }
        Collections.sort(customers);
        page.setRecords(customers);
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

    /**
     * 查询满足搜索条件的数据
     *
     * @return com.rongzi.assistant.common.tips.AssistantTip
     * @Author xulei
     * @Date 15:17 2018/10/12
     * @Param []
     **/
    @PostMapping("/search")
    public AssistantTip searchCustomerList(@RequestBody @Valid CustomerSearchParam customerSearchParam, BindingResult bindingResult) {

        logger.info("前端传递过来的搜索参数为：" + customerSearchParam.toString());

        AssistantTip assistantTip = new AssistantTip();
        Map<String, Object> bindingResultMap = new HashMap<String, Object>();
        if (bindingResult.hasErrors()) {
            assistantTip = ValidatorParamUtil.getAssistantTip(bindingResult, assistantTip, bindingResultMap);
        } else {
            List<Integer> contactStatus = customerSearchParam.getContactStatus();
            Integer customerExeStatus = customerSearchParam.getCustomerExeStatus();
            String searchName = customerSearchParam.getSearchName();
            Date payStartTime = customerSearchParam.getPayStartTime();
            Date payEndTime = customerSearchParam.getPayEndTime();
            String empCode = customerSearchParam.getEmpCode();

            Boolean flag = contactStatus == null || contactStatus.size() == 0;

            if (flag && customerExeStatus == null
                    && StringUtils.isEmpty(searchName)
                    && payStartTime == null
                    && payEndTime == null
                    && StringUtils.isEmpty(empCode)) {
                throw new GunsException(AssistantExceptionEnum.SEARCH_DATA_NULL);

            }
            if (customerSearchParam.getCustomerExeStatus() != null) {
                boolean exeStatusFlag = ValidatorParamUtil.checkCustomerExeStatus(customerSearchParam.getCustomerExeStatus());
                if (!exeStatusFlag) {
                    return AssistantTip.error(500, "客户进程编号无效");
                }
            }

            Page page = new Page(customerSearchParam.getPageIndex(), customerSearchParam.getPageSize());
            if (payEndTime != null) {
                payEndTime = DateTimeKit.offsiteDate(payEndTime, Calendar.DATE, 1);
            }

            List<Customer> customers = customerService.searchAllCustomersByCondition(page, empCode, contactStatus, customerExeStatus, searchName, payStartTime, payEndTime);
            Collections.sort(customers);
            page.setRecords(customers);
            PageInfoBT<Customer> pageinfo = new PageInfoBT<Customer>(page);
            assistantTip = AssistantTip.ok(JSON.toJSON(pageinfo));
        }
        return assistantTip;
    }

}
