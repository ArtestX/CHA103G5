package com.cha103g5.product_picture.model;

import java.util.List;
import java.util.Map;



public interface Product_pictureDAO {
	
	int insert(Product_picture entity);

	int update(Product_picture entity);
	
	int delete(Integer id);
	 
	Product_picture getById(Integer id);
	
	List<Product_picture> getAll();
	
	List<Product_picture> getByCompositeQuery(Map<String, String> map);
	
	List<Product_picture> getAll(int currentPage);
	
	long getTotal();
}