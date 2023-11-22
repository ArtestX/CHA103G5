package com.cha103g5.product_category.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cha103g5.product_category.dao.Product_categoryVO;
import com.cha103g5.product_category.service.ProductCategoryService;

@Controller
public class MyProductCategoryController {

    private final ProductCategoryService productCategoryService;

    @Autowired
    public MyProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping("/category")
    public String ProductCategoriesPage(Model model) {
        List<Product_categoryVO> productCategories = productCategoryService.getAllProductCategories();
        model.addAttribute("productCategories", productCategories);
        return "category";
    }


}
