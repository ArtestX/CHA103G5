package com.cha103g5.product_comment.service;

import com.cha103g5.product_comment.dao.ProductCommentRepository;
import com.cha103g5.product_comment.dao.ProductCommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductCommentService {

    private final ProductCommentRepository commentRepository;

    @Autowired
    public ProductCommentService(ProductCommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // 獲取特定產品的所有評論
    public List<ProductCommentVO> getCommentByProductNo(Integer productNo) {
        return commentRepository.findByProduct_ProductNo(productNo);
    }

    // 添加一個新評論
    public  ProductCommentVO addComment(ProductCommentVO comment){
        return commentRepository.save(comment);
    }
    // 根據評論ID獲取評論
    public ProductCommentVO getCommentById(Long id){
        return commentRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("評論未找到，ID: " + id)
        );
    }

    // 更新評論
    @Transactional
    public ProductCommentVO updateComment(ProductCommentVO comment) {
        return commentRepository.save(comment);
    }

    // 刪除評論
    @Transactional
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

}
