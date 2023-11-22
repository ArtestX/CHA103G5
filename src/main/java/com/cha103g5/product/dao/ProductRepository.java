package com.cha103g5.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<ProductVO,Integer> {
    // 根據關鍵字搜尋產品
    List<ProductVO> findByProductNameContaining(String keyword);
    List<ProductVO> findByProductNameContainingAndProductCatNo(String keyword, Integer productCatNo);
    List<ProductVO> findByProductCatNo(Integer productCatNo);
    // 新增方法以獲取所有上架的商品
    List<ProductVO> findByProductStat(Integer productStat);

    // 新增方法以根據商品編號查找商品
    Optional<ProductVO> findByProductNo(Integer productNo);

}
