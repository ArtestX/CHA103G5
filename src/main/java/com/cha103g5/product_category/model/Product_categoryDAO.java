package com.cha103g5.product_category.model;

import java.util.*;

import com.cha103g5.product_category.model.Product_category;

public interface Product_categoryDAO {
	int insert(Product_category entity);

	int update(Product_category entity);
	
	int delete(Integer id);
	 
	Product_category getById(Integer id);
	
	List<Product_category> getAll();
	
	List<Product_category> getByCompositeQuery(Map<String, String> map);
	
	List<Product_category> getAll(int currentPage);
	
	long getTotal();
}
