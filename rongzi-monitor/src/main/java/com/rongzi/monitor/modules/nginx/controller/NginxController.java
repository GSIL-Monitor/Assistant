package com.rongzi.monitor.modules.nginx.controller;


import com.rongzi.monitor.modules.apm.wrapper.NginxTotalWrapper;
import com.rongzi.monitor.modules.apm.wrapper.NginxWarpper;
import com.rongzi.monitor.modules.nginx.model.nginxtotal;
import com.rongzi.monitor.modules.nginx.service.NginxService;
import com.rongzi.monitor.modules.nginx.service.NginxTotalService;
import com.rongzi.core.base.controller.BaseController;
import com.rongzi.core.support.BeanKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/nginx")
public class NginxController extends BaseController {


    private static String PREFIX = "/nginx/";

    @Autowired
    private NginxService nginxService;

    @Autowired
    private NginxTotalService nginxTotalService;


    @RequestMapping(value = "/actionovertime")
    public String roleAdd() {
        return PREFIX + "nginx.html";
    }


    @RequestMapping(value = "/list")
    @ResponseBody
    public Object findAllNginxClientPage(@RequestParam(required = true) Integer overtimelength, @RequestParam(required = true) Integer isignore, @RequestParam(required = true) Integer isiis) {
        List<Map<String, Object>> list = nginxService.queryNginxAll(overtimelength, isignore, isiis);
        list = (List<Map<String, Object>>) new NginxWarpper(list).warp();
        return list;
    }


    @RequestMapping(value = "/actiontotal")
    public String actiontotalIndex() {
        return PREFIX + "actiontotal.html";
    }

    @RequestMapping(value = "/totallist")
    @ResponseBody
    public Object totallist(@RequestParam(required = true) String begintime) throws ParseException {

        Date date1 = null;
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date1 = format1.parse(begintime);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        String temp_str = "";
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        temp_str = sdf.format(dt);
        Date date2 = null;
        try {
            date2 = format1.parse(temp_str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String tablename = null;
        if (date1.before(date2)) {
            System.out.println("输入日期小于当前日期");
            tablename = "nginxlog_" + begintime.replace("-", "");
        } else {
            System.out.println("输入日期大于或等于当前日期");
            tablename = "nginxlog";
        }

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        nginxtotal nt = nginxTotalService.findnginxtotalBydate(begintime);
        if (nt != null) {
            Map<String, Object> result = BeanKit.beanToMap(nt);
            list.add(result);

        } else {
            //System.out.println(tablename);
            list = nginxService.queryNginxTotal(tablename);

            nginxtotal total =new nginxtotal();
            Map<String, Object>  map =  list.get(0);

            Integer nginxtotalcount = (Integer) map.get("nginxtotalcount");
            Integer nginxover1seccount = (Integer) map.get("nginxover1seccount");
            Integer nginxover3seccount = (Integer) map.get("nginxover3seccount");
            Integer nginxover10seccount = (Integer) map.get("nginxover10seccount");
            Integer iisover1seccount = (Integer) map.get("iisover1seccount");
            Integer iisover3seccount = (Integer) map.get("iisover3seccount");
            Integer iisover10seccount = (Integer) map.get("iisover10seccount");

            total.setNginxtotalcount(nginxtotalcount);
            total.setNginxover1seccount(nginxover1seccount);
            total.setNginxover3seccount(nginxover3seccount);
            total.setNginxover10seccount(nginxover10seccount);
            total.setIisover1seccount(iisover1seccount);
            total.setIisover3seccount(iisover3seccount);
            total.setIisover10seccount(iisover10seccount);
            total.setCreatedate(format1.parse(begintime));
            if (date1.before(date2))
            {
                nginxTotalService.addactiontotal(total);
            }

        }
        list = (List<Map<String, Object>>) new NginxTotalWrapper(list).warp();

        return list;


    }

    @RequestMapping(value = "/nginx_detail/{paramsData}")
    public String toNginxDetail(@PathVariable("paramsData") String paramsData, Model model) {

        model.addAttribute("paramsData", paramsData);


        return PREFIX + "nginx_detail.html";


    }

    @RequestMapping(value = "/nginx_detaillist")
    @ResponseBody
    public Object searchNginxDetail(@RequestParam(required = true) String paramsData) {

        System.out.println("--------" + paramsData);

        String[] data = paramsData.split(",");


        List<Map<String, Object>> list = nginxService.findDetatilByActionandController(data[0].toString(), data[1].toString());


        return list;


    }


    //服务端分页
//    @RequestMapping(value = "/list")
//    @ResponseBody
//    public Object findAllNginxServerPage(@RequestParam(required = true) Integer overtimelength,
//                                         @RequestParam(required = true) Integer isignore) {
//        Page<Nginxlog> page = new PageFactory<Nginxlog>().defaultPage();
//        List<Map<String, Object>> result = nginxService.queryPageByServer(page,page.getOrderByField(), page.isAsc(),overtimelength,isignore);
//        page.setRecords((List<Nginxlog>) new NginxWarpper(result).warp());
//        return super.packForBT(page);
//    }


//    /**
//     * Description:删除产品
//     *
//     * @param:
//     * @return:
//     * @auther: Administrator
//     * @date: 2018/5/15 0015 11:39
//     */
//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    @ResponseBody
//    @Permission(Const.TESTROLE)
//    @ApiOperation(value = "删除产品", notes = "根据Id来删除产品")
//    @ApiImplicitParam(name = "id", value = "产品的详细id", required = true, dataType = "Long", paramType = "path")
//    @CacheEvict(value = Cache.CONSTANT, key = "'" + CacheKey.PRODUCT_NAME + "'")
//    public Tip deleteByProduct(@RequestParam("id") Long id) {
//
//        productService.deleteProductByID(id);
//        return SUCCESS_TIP;
//
//    }
//
//
//    /**
//     * Description: 跳转到修改页面
//     *
//     * @param:
//     * @return:
//     * @auther: Administrator
//     * @date: 2018/5/15 0015 15:14
//     */
//    @RequestMapping("/product_edit/{productId}")
//    @Permission
//    public String toProductEdit(@PathVariable("productId") Long Id, Model model) {
//
//        NginxDetail product = productService.getProductById(Id);
//        model.addAttribute(product);
//        return PREFIX + "product_edit.html";
//    }
//
//    /**
//     * 修改产品
//     */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @Permission
////    @CacheEvict(value = Cache.CONSTANT , key ="'"+CacheKey.PRODUCT_NAME+"'")
//    public Tip updateProduct(@Valid NginxDetail product, BindingResult result) {
//        if (result.hasErrors()) {
//            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
//        }
//        productService.updateProduct(product);
//        return SUCCESS_TIP;
//    }
//
//    /**
//     * 增加产品
//     */
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    @ResponseBody
//    @Permission
//    @CacheEvict(value = Cache.CONSTANT, key = "'" + CacheKey.PRODUCT_NAME + "'")
//    public Tip addProduct(@Valid NginxDetail product, BindingResult result) {
//
//        if (result.hasErrors()) {
//            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
//        }
//        productService.addProduct(product);
//        return SUCCESS_TIP;
//
//    }

}
