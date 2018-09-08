package com.rongzi.assistant.common.exception;

import com.rongzi.assistant.common.tips.AssistantTip;
import com.rongzi.core.exception.GunsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
@Order(-1)
public class AssisantGlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 拦截业务异常
     */
    @ExceptionHandler(GunsException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public AssistantTip notFount(GunsException e) {
        log.error("业务异常:", e);
        return new AssistantTip("操作失败",e.getCode(),e.getMessage());
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public AssistantTip notFount(RuntimeException e) {
        log.error("运行时异常:", e);
        return new AssistantTip("操作失败",AssistantExceptionEnum.SERVER_ERROR.getCode(), AssistantExceptionEnum.SERVER_ERROR.getMessage());
    }
}
