package com.cha103g5.product_comment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCommentRepository extends JpaRepository<ProductCommentVO, Long> {
    List<ProductCommentVO> findByProduct_ProductNo(Integer productNo);
}

