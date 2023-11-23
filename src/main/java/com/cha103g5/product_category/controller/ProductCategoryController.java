package com.cha103g5.product_category.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cha103g5.product_category.dao.Product_categoryVO;
import com.cha103g5.product_category.service.ProductCategoryService;

@RestController
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    @Autowired
    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @PostMapping("/product_categories")
    public Product_categoryVO addProductCategory(@RequestBody Product_categoryVO productCategory) {
        return productCategoryService.addProductCategory(productCategory);
    }

    @PutMapping("/product_categories/{productCatNo}")
    public Product_categoryVO updateProductCategory(@RequestBody Product_categoryVO productCategory) {
        return productCategoryService.updateProductCategory(productCategory);
    }

    @DeleteMapping("/product_categories/{productCatNo}")
    public void deleteProductCategory(@PathVariable Integer productCatNo) {
        productCategoryService.deleteProductCategory(productCatNo);
    }

    @GetMapping("/product_categories")
    public List<Product_categoryVO> getAllProductCategories() {
        return productCategoryService.getAllProductCategories();
    }

    @GetMapping("/product_categories/{productCatNo}")
    public Product_categoryVO getProductCategoryByNo(@PathVariable Integer productCatNo) {
        return productCategoryService.getProductCategoryByNo(productCatNo);
    }
}
