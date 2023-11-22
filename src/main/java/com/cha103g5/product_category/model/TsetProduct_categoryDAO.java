package com.cha103g5.product_category.model;

import java.util.List;

public class TsetProduct_categoryDAO {
	public static void main(String[] args) {
		Product_categoryDAO product_categoryDAO = new Product_categoryDAOImpl();

		// 新增
//		Product_category product_category1 = new Product_category();
//		product_category1.setProductCatNo(1);
//		product_category1.setProductCatName("Test Product 1");
//		product_categoryDAO.insert(product_category1);
//
//		// 修改
//		Product_category product_category2 = product_categoryDAO.getById(1); // Replace 1 with the ID of the product you want to update
//	        if (product_category2 != null) {
//	            product_category2.setProductCatName("Updated Product Name");       
//	            product_categoryDAO.update(product_category2);
//	        }
//
//		// 刪除
//	        int product_categoryIdToDelete = 2; // Replace 2 with the ID of the product you want to delete
//	        product_categoryDAO.delete(product_categoryIdToDelete);

		// 查詢單筆
	        int product_categoryIdToQuery = 3; // Replace 3 with the ID of the product you want to retrieve
	        Product_categoryVO retrievedProduct_category = product_categoryDAO.getById(product_categoryIdToQuery);
	        if (retrievedProduct_category != null) {
	            System.out.println(retrievedProduct_category);
	        } else {
	            System.out.println("Product_category not found.");
	        }

		// 查詢多筆
		List<Product_categoryVO> product_categorys = product_categoryDAO.getAll();
		for (Product_categoryVO product_category : product_categorys) {
			System.out.println(product_category);
		}
	}
}
