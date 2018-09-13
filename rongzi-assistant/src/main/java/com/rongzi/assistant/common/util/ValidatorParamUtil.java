package com.rongzi.assistant.common.util;

import com.rongzi.assistant.common.tips.AssistantTip;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Map;

public class ValidatorParamUtil {

    private static Logger logger = LoggerFactory.getLogger(ValidatorParamUtil.class);

    public static AssistantTip getAssistantTip(BindingResult bindingResult, AssistantTip assistantTip, Map<String, Object> bindingResultMap) {
        FieldError fieldError = bindingResult.getFieldError();
        logger.info("参数校验异常:{} {}", fieldError.getField(), fieldError.getDefaultMessage());
        assistantTip = AssistantTip.error(500, String.format("%s %s", fieldError.getField(), fieldError.getDefaultMessage()));
        return assistantTip;
    }

}
