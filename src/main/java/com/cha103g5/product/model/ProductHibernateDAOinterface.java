package com.cha103g5.product.model;

import java.util.List;

public interface ProductHibernateDAOinterface {
	int insert(ProductVO productVO);

	int update(ProductVO productVO);

	int delete(Integer productNo);

	ProductVO findByPrimaryKey(Integer productNo);

	List<ProductVO> getAll();
}
