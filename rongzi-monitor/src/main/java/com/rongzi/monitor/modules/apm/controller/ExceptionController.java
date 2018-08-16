package com.rongzi.monitor.modules.apm.controller;

import com.rongzi.core.exception.GunsException;
import com.rongzi.core.exception.GunsExceptionEnum;
import com.rongzi.monitor.core.common.constant.factory.PageFactory;
import com.rongzi.monitor.modules.apm.service.ExceptionLogService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.core.base.controller.BaseController;
import com.rongzi.core.base.tips.Tip;
import com.rongzi.core.util.FileUtil;
import com.rongzi.monitor.modules.apm.model.ExceptionLog;
import com.rongzi.monitor.modules.apm.wrapper.ExceptionLogWarpper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/exception")
public class ExceptionController extends BaseController {

    private static String PREFIX = "/apm/exception/";

    @Autowired
    private ExceptionLogService exceptionLogService;

    /**
     * 跳转到异常列表页
     */
    @GetMapping("/log")
    public String index() {
        return PREFIX + "log.html";
    }


    @PostMapping("/logs")
    @ResponseBody
    public Object list(@RequestParam(required = true) String beginTime,
                       @RequestParam(required = true) String endTime,
                       @RequestParam(required = true) Integer systemCode,
                       @RequestParam(required = true) Integer isReadonly,
                       @RequestParam(required = true) String Owner,
                       @RequestParam(required = true) Integer Status) {
        //1:如果开始时间是今天，结束时间是今天，就查新数据库
        //2：如果开始时间不是今天，结束时间包含今天，就报错
        //3：如果开始时间不是今天，结束时间不包含今天，就正常显示

        String flag = "";
        String today="";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        today = simpleDateFormat.format(new Date());
        if (today.equals(beginTime) && today.equals(endTime)) {
            //查询新的数据库
            flag = "dataSourceBiz";
        } else {
            flag = "dataSourceHistory";
        }
        Page<ExceptionLog> page = new PageFactory<ExceptionLog>().defaultPage();
        List<Map<String, Object>> resultdata = exceptionLogService.getExceptionLogsAllByDatabase(beginTime, endTime, systemCode,
                isReadonly, page, Owner, Status, page.getOrderByField(), page.isAsc(), flag);

        page.setRecords((List<ExceptionLog>) new ExceptionLogWarpper(resultdata).warp());
        return super.packForBT(page);
    }


    @RequestMapping("/exception_multiEdit/{ids}")
    public String toMultiEdit(@PathVariable("ids") String ids, Model model) {
        model.addAttribute("params", ids);
        return PREFIX + "log_edit.html";
    }

    @RequestMapping(value = "/multiEdit")
    @ResponseBody
    public Tip updateMultiLogs(@RequestParam("params") String params, @RequestParam("Owner") String Owner, @RequestParam("Status") Integer Status) {

        String[] data = params.split(",");
        for (String datum : data) {
            String[] paramsData = datum.split("&");
            exceptionLogService.multiUpdateLogByIdAndOccurTime(Integer.parseInt(paramsData[0]), paramsData[1], Owner, Status);
        }
        return SUCCESS_TIP;
    }

    @PostMapping("/downLoadExcelByCondition")
    @ResponseBody
    public Tip saveDataForExcelDownload(@RequestParam(required = true, value = "excelParamData") String excelParamData, HttpServletRequest request, HttpServletResponse response, HttpSession session) {


        request.getSession().setAttribute("excelParamData", excelParamData);

        return SUCCESS_TIP;
    }

    /**
     * 功能描述: 根据选择内容下载生成Excel
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/8/6 0006 10:32
     */
    @RequestMapping(value = "/downloadExcelContent")
    public void exportExcel(HttpServletRequest request, HttpServletResponse response) {

        String excelParamData = (String) request.getSession().getAttribute("excelParamData");

        JSONObject jsonObject = JSONObject.parseObject(excelParamData);

        String beginTime = (String) jsonObject.get("beginTime");
        String endTime = (String) jsonObject.get("endTime");
        Integer systemCode = Integer.parseInt((String) jsonObject.get("systemCode"));

        Integer isReadonly = Integer.parseInt((String) jsonObject.get("isReadonly"));
        String Owner = (String) jsonObject.get("Owner");
        Integer Status = Integer.parseInt((String) jsonObject.get("Status"));

        String excelName = endTime + "ExceptionLog.xls";
        List<ExceptionLog> exceptionLogs = exceptionLogService.findAllExceptionLogsForDownLoad(beginTime, endTime, systemCode,
                isReadonly, Owner, Status);

//        List<ExceptionLog> uniqueExceptionLogs = exceptionLogs.stream().collect(collectingAndThen(
//                toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getMessage()))), ArrayList::new));


        FileUtil.exportDataToExcel(exceptionLogs, ExceptionLog.class, excelName, response);
    }


}
