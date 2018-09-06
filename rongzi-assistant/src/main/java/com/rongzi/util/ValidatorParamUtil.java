package com.rongzi.util;

import com.alibaba.fastjson.JSON;
import com.rongzi.config.tips.AssistantTip;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Map;


public class ValidatorParamUtil {


    public static void validatorParams(BindingResult bindingResult, AssistantTip assistantTip, Map<String, Object> bindingResultMap) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        for (FieldError fieldError : fieldErrors) {

            String field = fieldError.getField();

            String defaultMessage = fieldError.getDefaultMessage();

            bindingResultMap.put(field, defaultMessage);
        }
        assistantTip=AssistantTip.error(-1,JSON.toJSON(bindingResultMap));

    }
}
