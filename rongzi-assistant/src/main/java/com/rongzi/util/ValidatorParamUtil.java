package com.rongzi.util;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Map;


public class ValidatorParamUtil {


    public static void validatorParams(BindingResult bindingResult, Map<String, Object> resultMap, Map<String, Object> bindingResultMap) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        for (FieldError fieldError : fieldErrors) {

            String field = fieldError.getField();

            String defaultMessage = fieldError.getDefaultMessage();

            bindingResultMap.put(field, defaultMessage);
        }
        resultMap.put("msg", "参数失败");
        resultMap.put("code", -1);
        resultMap.put("data", JSON.toJSON(bindingResultMap));
    }
}
