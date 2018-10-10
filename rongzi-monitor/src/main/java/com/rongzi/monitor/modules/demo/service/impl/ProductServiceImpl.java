package com.rongzi.monitor.modules.demo.service.impl;

import com.rongzi.monitor.core.common.constant.DatasourceEnum;
import com.rongzi.monitor.modules.demo.model.Product;
import com.rongzi.monitor.modules.demo.service.ProductService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rongzi.core.mutidatasource.annotion.DataSource;
import com.rongzi.monitor.modules.demo.dao.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_BIZ)
    public List<Map<String, Object>> queryProductsAll() {
        List<Map<String, Object>> result = productMapper.findProductsAll();
        return result;
    }


    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_BIZ)
    public Boolean addProduct(Product product) {
        return productMapper.addProduct(product);
    }

    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_BIZ)
    public Boolean deleteProductByID(Long id) {
        // int a=100/0;
        return productMapper.deleteProduct(id);
    }

    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_BIZ)
    public Boolean updateProduct(Product product) {
        return productMapper.updateProduct(product);
    }


    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_BIZ)
    public Product getProductById(Long id) {
        return productMapper.findProductById(id);
    }

    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_BIZ)
    public boolean batchDeleteByIds(Long[] ids) {
        return productMapper.batchDeleteByIds(ids);
    }

    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_BIZ)
    public boolean batchImportDataFromExcel(List<Product> products) {
        return productMapper.batchImportExcelData(products);
    }

    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_BIZ)
    public List<Product> findAllProductsList() {
        return productMapper.findListProducts();
    }


}
