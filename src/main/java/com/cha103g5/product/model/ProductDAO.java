package com.cha103g5.product.model;

import java.util.List;
import java.util.Map;

public interface ProductDAO {
	int insert(Product entity);

	int update(Product entity);
	
	int delete(Integer id);
	 
	Product getById(Integer id);
	
	List<Product> getAll();
	
	List<Product> getByCompositeQuery(Map<String, String> map);
	
	List<Product> getAll(int currentPage);
	
	long getTotal();
}
