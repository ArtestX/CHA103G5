package com.cha103g5.product_category.model;

import java.util.*;

import com.cha103g5.product_category.model.Product_categoryVO;

public interface Product_categoryDAO {
	int insert(Product_categoryVO entity);

	int update(Product_categoryVO entity);
	
	int delete(Integer id);
	 
	Product_categoryVO getById(Integer id);
	
	List<Product_categoryVO> getAll();
	
	List<Product_categoryVO> getByCompositeQuery(Map<String, String> map);
	
	List<Product_categoryVO> getAll(int currentPage);
	
	long getTotal();
}
