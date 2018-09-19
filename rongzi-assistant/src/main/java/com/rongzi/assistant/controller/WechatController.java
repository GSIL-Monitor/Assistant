package com.rongzi.assistant.controller;

import com.rongzi.assistant.common.tips.AssistantTip;
import com.rongzi.assistant.common.util.ValidatorParamUtil;
import com.rongzi.assistant.model.WechatParam;
import com.rongzi.assistant.service.WechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
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
    private String accountsecret;


    @Value("${wechat.constantStr}")
    private String weChatConstantStr;

    @Autowired
    WechatService wechatService;

    @PostMapping("/addFriend")
    public AssistantTip sendRequestForAddFreiend(@RequestBody @Validated(value = WechatParam.AddFriend.class) WechatParam wechatParam, BindingResult bindingResult) {

        AssistantTip assistantTip = new AssistantTip();

        Map<String, Object> bindingResultMap = new HashMap<String, Object>();

        if (bindingResult.hasErrors()) {
            assistantTip = ValidatorParamUtil.getAssistantTip(bindingResult, assistantTip, bindingResultMap);
        } else {
            wechatParam.setAccountSecret(accountsecret);
            wechatParam.setWeChatConstantStr(weChatConstantStr);
            int weChatCode = wechatService.addFriend(wechatParam);
            assistantTip = AssistantTip.ok(weChatCode);
        }
        return assistantTip;
    }

    @PostMapping("/updateFriendStatus")
    public AssistantTip updateWeChatStatus(@RequestBody @Validated(value = WechatParam.UpdateStatus.class) WechatParam wechatParam, BindingResult bindingResult){

        AssistantTip assistantTip = new AssistantTip();

        Map<String, Object> bindingResultMap = new HashMap<String, Object>();
        if (bindingResult.hasErrors()) {
            assistantTip = ValidatorParamUtil.getAssistantTip(bindingResult, assistantTip, bindingResultMap);
        } else {
            wechatService.updateFriendStatus(wechatParam);
            assistantTip = AssistantTip.ok(wechatParam.getFriendStatus());
        }
        return assistantTip;


    }



}
