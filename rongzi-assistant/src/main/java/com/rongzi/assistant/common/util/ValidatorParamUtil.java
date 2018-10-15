package com.rongzi.assistant.common.util;

import com.rongzi.assistant.common.tips.AssistantTip;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ValidatorParamUtil {


    private static Integer[] arr = {-1,0, 1, 2, 3, 4, 5};


    private static Logger logger = LoggerFactory.getLogger(ValidatorParamUtil.class);

    public static AssistantTip getAssistantTip(BindingResult bindingResult, AssistantTip assistantTip, Map<String, Object> bindingResultMap) {
        FieldError fieldError = bindingResult.getFieldError();
        logger.info("参数校验异常:{} {}", fieldError.getField(), fieldError.getDefaultMessage());
        assistantTip = AssistantTip.error(500, String.format("%s %s", fieldError.getField(), fieldError.getDefaultMessage()));
        return assistantTip;
    }

    /**
     * 校验客户进程编号参数
     *
     * @Author xulei
     * @Date 9:56 2018/10/15
     * @Param [status]
     * @return boolean
     **/
    public static boolean checkCustomerExeStatus(Integer status) {


        List<Integer> integers = Arrays.asList(arr);


        return integers.contains(status);


    }


}
