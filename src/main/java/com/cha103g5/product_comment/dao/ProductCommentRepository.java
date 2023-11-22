package com.cha103g5.product_comment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCommentRepository extends JpaRepository<ProductCommentVO, Long> {
    List<ProductCommentVO> findByProduct_ProductNo(Integer productNo);
}

