package com.cha103g5.product.model;

import java.util.List;

public interface ProductDAOInterface {
    public void insert(ProductVO product);
    public void update(ProductVO product);
    public void delete(Integer product);
    public ProductVO findByPrimaryKey(Integer product);
    public List<ProductVO> getAll();
}
