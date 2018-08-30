package com.rongzi.assistant.controller;

import com.alibaba.fastjson.JSON;
import com.rongzi.assistant.model.RequestJsonParam;
import com.rongzi.assistant.model.SmsMessage;
import com.rongzi.assistant.service.SmsMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sms")
public class SmsMessageController {


    @Autowired
    SmsMessageService smsMessageService;


//    @PostMapping("/getMessages")
//    public Map<String, Object> findAllMsgFromSaleSystem(@RequestParam("empCode") String empCode
//            , @RequestParam("customerCode") String customerCode
//            , @RequestParam("customerMobile") String customerMobile
//            , @RequestParam("pageSize") int pageSize
//            , @RequestParam("pageIndex") int pageIndex
//            ,@RequestParam("empName") String empName  ) {
//
////        Page page = new Page(pageIndex, pageSize);
//        List<SmsMessage> msgs = smsMessageService.findMsgsFromSaleSystem(empCode, customerCode, customerMobile);
////        page.setRecords(msgs);
//
////        PageInfoBT<SmsMessage> pageinfo = new PageInfoBT<SmsMessage>(page);
//
//        Map<String, Object> resultMap = new HashMap<String, Object>();
//
//        resultMap.put("msg", "操作成功");
//        resultMap.put("code", 0);
//        resultMap.put("data", JSON.toJSONString(msgs));
//
//        return resultMap;
//
//    }

    /**
     * 获取销售系统短信信息到手机中
     * @param requestJsonParam
     * @return
     */
    @PostMapping("/getMessages")
    public Map<String, Object> findAllMsgFromSaleSystem(@RequestBody RequestJsonParam requestJsonParam) {

        List<SmsMessage> msgs = smsMessageService.findMsgsFromSaleSystem(requestJsonParam.getEmpCode(), requestJsonParam.getCustomerCode(), requestJsonParam.getCustomerMobile());
        Map<String, Object> resultMap = new HashMap<String, Object>();

        resultMap.put("msg", "操作成功");
        resultMap.put("code", 0);
        resultMap.put("data", JSON.toJSON(msgs));

        return resultMap;

    }



    /**
     * 同步短信到销售系统
     */
    @PostMapping("/addMessages")
    public Map<String, Object>  addMsgsToSaleSystem(@RequestBody List<SmsMessage> msgs){

        smsMessageService.addMsgsToSaleSystem(msgs);

        Map<String, Object> resultMap = new HashMap<String, Object>();

        resultMap.put("msg", "操作成功");
        resultMap.put("code", 0);
        resultMap.put("data", null);

        return resultMap;
    }


}
