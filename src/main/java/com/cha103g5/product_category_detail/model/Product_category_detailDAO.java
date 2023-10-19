package com.cha103g5.product_category_detail.model;

import java.util.List;
import java.util.Map;

public interface Product_category_detailDAO {
	int insert(Product_category_detail entity);

	int update(Product_category_detail entity);
	
	int delete(Integer id);
	 
	Product_category_detail getById(Integer id);
	
	List<Product_category_detail> getAll();
	
	List<Product_category_detail> getByCompositeQuery(Map<String, String> map);
	
	List<Product_category_detail> getAll(int currentPage);
	
	long getTotal();
}
