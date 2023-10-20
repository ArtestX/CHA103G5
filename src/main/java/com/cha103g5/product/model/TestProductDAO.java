package com.cha103g5.product.model;

import java.util.List;

public class TestProductDAO {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAOImpl();

//        // 新增
//        Product product1 = new Product();
//        product1.setProductCatNo(1);
//        product1.setProductCatDetNo(1);
//        product1.setProductName("Test Product 1");
//        product1.setProductPrice(19.99);
//        product1.setProductInfo("This is a test product 1");
//        product1.setProductStat(1);
//        product1.setProductEval(4);
//        product1.setProductEvalTotal(20);
//        product1.setProductSaleNum(100);
//        productDAO.insert(product1);
//
        // 修改
        Product product2 = productDAO.getById(1); // Replace 1 with the ID of the product you want to update
        if (product2 != null) {
            product2.setProductName("Updated Product Name");
            product2.setProductPrice(29.99);
            product2.setProductInfo("Updated product information");
            productDAO.update(product2);
        }

        // 刪除
//        int productIdToDelete = 2; // Replace 2 with the ID of the product you want to delete
//        productDAO.delete(productIdToDelete);

        // 查詢單筆
        int productIdToQuery = 3; // Replace 3 with the ID of the product you want to retrieve
        Product retrievedProduct = productDAO.getById(productIdToQuery);
        if (retrievedProduct != null) {
            System.out.println(retrievedProduct);
        } else {
            System.out.println("Product not found.");
        }

        // 查詢多筆
        List<Product> products = productDAO.getAll();
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
