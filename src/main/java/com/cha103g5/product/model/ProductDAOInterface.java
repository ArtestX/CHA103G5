package com.cha103g5.product.model;

import java.util.List;

public interface ProductDAOInterface {
    public void insert(ProductVO productVO);
    public void update(ProductVO productVO);
    public void delete(Integer productNo);
    public ProductVO findByPrimaryKey(Integer productNo);
    public List<ProductVO> getAll();
}
