package com.cha103g5.product.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductVO,Integer> {
    // 根據關鍵字搜尋產品
    List<ProductVO> findByProductNameContaining(String keyword);
    List<ProductVO> findByProductNameContainingAndProductCatNo(String keyword, Integer productCatNo);
    List<ProductVO> findByProductCatNo(Integer productCatNo);
    // 新增方法以獲取所有上架的商品
    List<ProductVO> findByProductStat(Integer productStat);
}
