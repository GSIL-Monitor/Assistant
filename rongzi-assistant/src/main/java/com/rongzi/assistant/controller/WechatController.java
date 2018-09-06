package com.rongzi.assistant.controller;

import com.rongzi.assistant.model.WechatParam;
import com.rongzi.assistant.service.WechatService;
import com.rongzi.util.ValidatorParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/wechat")
public class WechatController {


    @Value("${wechat.AccountSecret}")
    private String AccountSecret;


    @Value("${wechat.constantStr}")
    private String weChatConstantStr;

    @Autowired
    WechatService wechatService;

    @RequestMapping("/addFriend")
    public Map<String, Object> sendRequestForAddFreiend(@RequestBody @Valid WechatParam wechatParam, BindingResult bindingResult) {

        Map<String, Object> resultMap = new HashMap<String, Object>();

        Map<String, Object> bindingResultMap = new HashMap<String, Object>();

        if (bindingResult.hasErrors()) {
            ValidatorParamUtil.validatorParams(bindingResult, resultMap, bindingResultMap);
        } else {
            wechatParam.setAccountSecret(AccountSecret);
            wechatParam.setWeChatConstantStr(weChatConstantStr);
            int weChatCode = wechatService.addFriend(wechatParam);

            resultMap.put("msg", "操作成功");
            resultMap.put("code", 0);
            resultMap.put("data", weChatCode);
        }
        return resultMap;

    }
}
