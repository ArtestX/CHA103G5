package com.cha103g5.product_category.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cha103g5.product_category.dao.ProductCategoryRepository;
import com.cha103g5.product_category.dao.Product_categoryVO;

@Service
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    // 新增產品分類
    public Product_categoryVO addProductCategory(Product_categoryVO productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    // 更新產品分類
    public Product_categoryVO updateProductCategory(Product_categoryVO productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    // 刪除產品分類
    public void deleteProductCategory(Integer productCatNo) {
        productCategoryRepository.deleteById(productCatNo);
    }

    // 取得所有產品分類
    public List<Product_categoryVO> getAllProductCategories() {
        return productCategoryRepository.findAll();
    }

    // 依照分類編號取得產品分類
    public Product_categoryVO getProductCategoryByNo(Integer productCatNo) {
        return productCategoryRepository.findById(productCatNo).orElse(null);
    }
}
