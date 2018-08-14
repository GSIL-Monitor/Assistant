package com.rongzi.monitor.modules.apm.controller;


import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.rongzi.core.base.controller.BaseController;
import com.rongzi.core.base.tips.Tip;
import com.rongzi.monitor.core.common.annotion.Permission;
import com.rongzi.core.common.exception.BizExceptionEnum;
import com.rongzi.core.exception.GunsException;
import com.rongzi.core.util.FileUtil;
import com.rongzi.monitor.modules.apm.model.Product;
import com.rongzi.monitor.modules.apm.service.ProductService;
import com.rongzi.monitor.modules.apm.wrapper.ProductWarpper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.*;


@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {


    private static String PREFIX = "/apm/product/";


    @Autowired
    private ProductService productService;

    @RequestMapping("")
    public String index() {
        return PREFIX + "product.html";
    }

    @RequestMapping(value = "/product_add")
    public String roleAdd() {
        return PREFIX + "product_add.html";
    }

    @RequestMapping(value = "/product_search")
    public String search() {
        return PREFIX + "product_search.html";
    }

    @RequestMapping(value = "/product_show")
    public String show() {
        return PREFIX + "product_show.html";
    }


    /**
     * Description:获取所有的产品
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/5/15 0015 11:39
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    //@Cacheable(value = Cache.CONSTANT, key = "'" + CacheKey.PRODUCT_NAME + "'")
    public Object findAllProducts() {

        List<Map<String, Object>> list = productService.queryProductsAll();
        list = (List<Map<String, Object>>) new ProductWarpper(list).warp();
        return list;

    }


    /**
     * Description:删除产品
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/5/15 0015 11:39
     */
//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @RequestMapping(value = "/delete")
    @ResponseBody
//    @Permission(Const.TESTROLE)
//    @CacheEvict(value = Cache.CONSTANT, key = "'" + CacheKey.PRODUCT_NAME + "'")
    public Tip deleteByProduct(@RequestParam("ids[]") Long[] ids) {

        System.out.println(Arrays.toString(ids) + "*************");
        productService.batchDeleteByIds(ids);
//        productService.deleteProductByID(id);
        return SUCCESS_TIP;

    }


    /**
     * Description: 跳转到修改页面
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2018/5/15 0015 15:14
     */
    @RequestMapping("/product_edit/{productId}")
    @Permission
    public String toProductEdit(@PathVariable("productId") Long Id, Model model) {

        Product product = productService.getProductById(Id);
        model.addAttribute(product);
        return PREFIX + "product_edit.html";
    }

    /**
     * 修改产品
     */
    @RequestMapping("/edit")
    @ResponseBody
    @Permission
//    @CacheEvict(value = Cache.CONSTANT , key ="'"+CacheKey.PRODUCT_NAME+"'")
    public Tip updateProduct(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
        }
        productService.updateProduct(product);
        return SUCCESS_TIP;
    }

    /**
     * 增加产品
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @Permission
    //@CacheEvict(value = Cache.CONSTANT, key = "'" + CacheKey.PRODUCT_NAME + "'")
    public Tip addProduct(@Valid Product product, BindingResult result) {

        if (result.hasErrors()) {
            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
        }
        productService.addProduct(product);
        return SUCCESS_TIP;

    }

    @RequestMapping("/uploadExcel_easypoi")
    @ResponseBody
    public Map<String, Object> importEasyPoiExcel(MultipartFile file) {

        Map<String, Object> layui = new HashMap<String, Object>();
        try {
            ImportParams params = new ImportParams();
            //表头
            params.setHeadRows(1);
            //标题  没有标题
            params.setTitleRows(0);
            List<Product> products = (List<Product>) FileUtil.importDataFromExcel(file, Product.class, params);
            boolean b = productService.batchImportDataFromExcel(products);
        } catch (Exception e) {
            e.printStackTrace();
        }
        layui.put("msg", "操作成功");
        return layui;

    }


    @RequestMapping(value = "/downloadExcelContent")
    public void exportExcel(HttpServletResponse response) {

        String excelName = "产品管理表格下载.xls";
        List<Product> products = productService.findAllProductsList();
        FileUtil.exportDataToExcel(products, Product.class, excelName, response);
    }

    @RequestMapping(value = "/downloadExcelModel")
    public void exportExcelModel(HttpServletResponse response) {

        String fileName = "产品管理模版.xls";
        List<Product> products = new ArrayList<Product>();
        FileUtil.exportDataToExcel(products, Product.class, fileName, response);
    }


}


