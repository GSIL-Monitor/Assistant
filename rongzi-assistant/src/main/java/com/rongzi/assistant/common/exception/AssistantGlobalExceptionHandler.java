package com.rongzi.assistant.common.exception;

import com.rongzi.assistant.common.tips.AssistantTip;
import com.rongzi.core.exception.GunsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Order(-1)
public class AssistantGlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 拦截业务异常
     */
    @ExceptionHandler(GunsException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public AssistantTip notFount(GunsException e) {
        log.error("业务异常:", e);
        return AssistantTip.error(e.getCode(), e.getMessage());
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public AssistantTip notFount(RuntimeException e) {
        log.error("运行时异常:", e);
        return AssistantTip.error(AssistantExceptionEnum.SERVER_ERROR.getCode(), AssistantExceptionEnum.SERVER_ERROR.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public AssistantTip handleBindException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        log.info("参数校验异常:{} {}", fieldError.getField(), fieldError.getDefaultMessage());
        return AssistantTip.error(500, String.format("%s %s", fieldError.getField(), fieldError.getDefaultMessage()));
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public AssistantTip handleBindException(BindException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        log.info("绑定校验异常:{} {}", fieldError.getField(), fieldError.getDefaultMessage());
        return AssistantTip.error(500, String.format("%s %s", fieldError.getField(), fieldError.getDefaultMessage()));
    }
}
