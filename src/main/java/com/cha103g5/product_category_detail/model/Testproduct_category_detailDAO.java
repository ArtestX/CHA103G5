package com.cha103g5.product_category_detail.model;

import java.util.List;

public class Testproduct_category_detailDAO {
    public static void main(String[] args) {
        Product_category_detailDAO productCategoryDetailDAO = new Product_category_detailDAOImpl();

        // 新增產品類別細節
//        Product_category_detail productCategoryDetail1 = new Product_category_detail();
//        productCategoryDetail1.setProductCatName("Test Category 1");
//        int id1 = productCategoryDetailDAO.insert(productCategoryDetail1);
//        System.out.println("Inserted product category detail with ID: " + id1);
//
//        // 修改產品類別細節
//        Product_category_detail productCategoryDetail2 = productCategoryDetailDAO.getById(id1);
//        if (productCategoryDetail2 != null) {
//            productCategoryDetail2.setProductCatName("Updated Category Name");
//            productCategoryDetailDAO.update(productCategoryDetail2);
//            System.out.println("Updated product category detail: " + productCategoryDetail2);
//        }
//
//        // 刪除產品類別細節
//        int idToDelete = 1; // Replace 1 with the ID of the product category detail you want to delete
//        int deleteResult = productCategoryDetailDAO.delete(idToDelete);
//        if (deleteResult == 1) {
//            System.out.println("Deleted product category detail with ID: " + idToDelete);
//        } else {
//            System.out.println("Product category detail not found or deletion failed.");
//        }

        // 查詢單筆產品類別細節
        int productCategoryDetailIdToQuery = 2; // Replace 2 with the ID of the product category detail you want to retrieve
        Product_category_detail retrievedProductCategoryDetail = productCategoryDetailDAO.getById(productCategoryDetailIdToQuery);
        if (retrievedProductCategoryDetail != null) {
            System.out.println("Retrieved product category detail: " + retrievedProductCategoryDetail);
        } else {
            System.out.println("Product category detail not found.");
        }

        // 查詢多筆產品類別細節
        List<Product_category_detail> productCategoryDetails = productCategoryDetailDAO.getAll();
        for (Product_category_detail productCategoryDetail : productCategoryDetails) {
            System.out.println(productCategoryDetail);
        }
    }
}
