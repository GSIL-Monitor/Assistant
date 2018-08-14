package com.rongzi.monitor.modules.apm.service;

import com.baomidou.mybatisplus.service.IService;
import com.rongzi.monitor.modules.apm.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductService extends IService<Product> {


    /**
     * 添加产品
     * @param product
     * @return
     */
    Boolean addProduct(Product product);

    /**
     * 根据ID来删除产品
     * @param id
     * @return
     */
    Boolean deleteProductByID(Long id);

    /**
     * 修改产品
     * @param product
     * @return
     */
    Boolean updateProduct(Product product);

    /**
     * 查询产品列表
     * @return
     */
    List<Map<String, Object>> queryProductsAll();

    /**
     * 根据ID查询产品
     * @param id
     * @return
     */
    Product  getProductById(Long id);


    boolean batchDeleteByIds(Long[] ids);

    /**
     *  批量解析excel数据插入到数据库
     * @param products
     * @return
     */

    boolean batchImportDataFromExcel(List<Product> products);


    //查询所有的产品组装为list
    List<Product> findAllProductsList();
}
