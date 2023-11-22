package com.cha103g5.product_picture.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPictureRepository extends JpaRepository<ProductPictureVO, Integer> {
    List<ProductPictureVO> findByProduct_ProductNo(Integer productNo);
}
