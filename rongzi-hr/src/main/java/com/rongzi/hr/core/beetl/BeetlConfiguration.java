package com.rongzi.hr.core.beetl;

import com.rongzi.core.util.ToolUtil;
import com.rongzi.hr.core.shiro.ShiroExt;
import com.rongzi.hr.core.util.KaptchaUtil;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;

/**
 * beetl拓展配置,绑定一些工具类,方便在模板中直接调用
 *
 * @author stylefeng
 * @Date 2018/2/22 21:03
 */
public class BeetlConfiguration extends BeetlGroupUtilConfiguration {

    @Override
    public void initOther() {
        groupTemplate.registerFunctionPackage("tool", new ToolUtil());
        groupTemplate.registerFunctionPackage("shiro", new ShiroExt());
        groupTemplate.registerFunctionPackage("kaptcha", new KaptchaUtil());
    }
}
