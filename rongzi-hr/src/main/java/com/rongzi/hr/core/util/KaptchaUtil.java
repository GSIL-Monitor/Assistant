package com.rongzi.hr.core.util;

import com.rongzi.core.util.SpringContextHolder;
import com.rongzi.hr.config.properties.GunsProperties;

/**
 * 验证码工具类
 */
public class KaptchaUtil {

    /**
     * 获取验证码开关
     */
    public static Boolean getKaptchaOnOff() {
        return SpringContextHolder.getBean(GunsProperties.class).getKaptchaOpen();
    }
}