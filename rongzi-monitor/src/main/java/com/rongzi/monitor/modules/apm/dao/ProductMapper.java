package com.rongzi.monitor.modules.apm.dao;

import com.rongzi.monitor.modules.apm.model.Product;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductMapper extends BaseMapper<Product> {

    Boolean addProduct(Product product);

    Boolean deleteProduct(Long id);

    Boolean updateProduct(Product product);

    List<Map<String, Object>> findProductsAll();

    Product findProductById(Long id);

    boolean batchDeleteByIds(@Param("ids") Long[] ids);

    boolean batchImportExcelData(@Param("products")List<Product> products);

    List<Product> findListProducts();
}
