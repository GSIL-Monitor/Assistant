package com.rongzi.monitor.modules.apm.controller;

import com.rongzi.monitor.core.common.constant.factory.PageFactory;
import com.rongzi.monitor.modules.apm.wrapper.TypeExceptionWarpper;
import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.core.base.controller.BaseController;
import com.rongzi.monitor.modules.apm.model.TypeException;
import com.rongzi.monitor.modules.apm.service.TypeExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/apm")
public class TypeExceptionController extends BaseController {

    private static String PREFIX = "/apm/exception/";

    @Autowired
    private TypeExceptionService typeExceptionService;

    @RequestMapping("/exception/type")
    public String index() {
        return PREFIX + "typeException.html";
    }

    /**
     * Description: 客户端分页 根据系统名称和记录日期来获取系统所有数据.
     *
     * @param: [sysName, OccurDate]
     * @return: java.lang.Object
     * @auther: Administrator
     * @date: 2018/5/16 0016 14:03
     */
    @RequestMapping("/typeException/list")
    @ResponseBody
    public Object findAllExceptions(String sysName,
                                    String OccurDate) {
        List<Map<String, Object>> list = typeExceptionService.queryTypeExceptionsBySysNameAndOccurDate(sysName, OccurDate);
        return list;
    }

    /**
     * Description: 服务端分页 根据系统名称和记录日期来获取系统所有数据.
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/6/4 0004 10:27
     */
    @RequestMapping("/typeException/listServer")
    @ResponseBody
    public Object findAllExceptionsPage(@RequestParam("sysName") String sysName, @RequestParam("OccurDate") String OccurDate) {
        Page<TypeException> page = new PageFactory<TypeException>().defaultPage();
        List<Map<String, Object>> result = typeExceptionService.queryPageByServer(page, sysName, OccurDate, page.getOrderByField(), page.isAsc());
        page.setRecords((List<TypeException>) new TypeExceptionWarpper(result).warp());
        return super.packForBT(page);
    }


}
