package com.cha103g5.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cha103g5.product.dao.ProductVO;
import com.cha103g5.product.service.ProductService;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{productNo}")
    public ProductVO getProduct(@PathVariable Integer productNo) {
        return productService.getOneProduct(productNo);
    }

    @GetMapping("/products")
    public List<ProductVO> getAllProducts() {
        return productService.getAll();
    }

    @PostMapping("/products")
    public ProductVO addProduct(@RequestBody ProductVO product) {
        return productService.addProduct(product);
    }

    @PutMapping("/products/{productNo}")
    public ProductVO updateProduct(@PathVariable Integer productNo, @RequestBody ProductVO product) {
        // Ensure the productNo in the path matches the productNo in the request body
        if (!productNo.equals(product.getProductNo())) {
            throw new IllegalArgumentException("Path variable productNo must match the productNo in the request body");
        }
        return productService.updateProduct(product);
    }

    @DeleteMapping("/products/{productNo}")
    public void deleteProduct(@PathVariable Integer productNo) {
        productService.deleteProduct(productNo);
    }


}
