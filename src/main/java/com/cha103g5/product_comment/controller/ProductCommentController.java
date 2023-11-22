package com.cha103g5.product_comment.controller;

import com.cha103g5.product_comment.dao.ProductCommentVO;
import com.cha103g5.product_comment.service.ProductCommentService;
import com.cha103g5.product.service.ProductService;
import com.cha103g5.product.dao.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductCommentController {

    private final ProductCommentService commentService;
    private final ProductService productService;

    @Autowired
    public ProductCommentController(ProductCommentService commentService, ProductService productService) {
        this.commentService = commentService;
        this.productService = productService;
    }

    @GetMapping("/{productNo}/comments")
    public String getProductDetails(@PathVariable Integer productNo, Model model) {
        ProductVO product = productService.getOneProduct(productNo);
        if (product == null) {
            System.out.println("Product not found for productNo: " + productNo);
            return "redirect:/"; // 或者是您的404頁面
        }

        List<ProductCommentVO> comments = commentService.getCommentByProductNo(productNo);
        System.out.println("Fetching details for productNo: " + productNo);
        if (comments.isEmpty()) {
            System.out.println("No comments found for productNo: " + productNo);
        } else {
            System.out.println("Found " + comments.size() + " comments for productNo: " + productNo);
        }

        model.addAttribute("product", product);
        model.addAttribute("productComments", comments);
        return "comment";
    }

    // 新增評論的Ajax處理
    @PostMapping("/{productNo}/comments/add")
    public ResponseEntity<?> addCommentAjax(@PathVariable Integer productNo, @RequestBody ProductCommentVO comment) {
        try {
            ProductVO product = productService.getOneProduct(productNo);
            if (product == null) {
                return ResponseEntity.badRequest().body("產品未找到，ID: " + productNo);
            }
            comment.setProduct(product);
            ProductCommentVO savedComment = commentService.addComment(comment);
            return ResponseEntity.ok(savedComment);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("評論提交失敗：" + e.getMessage());
        }
    }

    // 編輯評論的Ajax處理
    @PutMapping("/comments/edit/{commentId}")
    public ResponseEntity<?> editCommentAjax(@PathVariable Long commentId, @RequestBody ProductCommentVO comment) {
        try {
            ProductCommentVO existingComment = commentService.getCommentById(commentId);
            if (existingComment == null) {
                return ResponseEntity.notFound().build();
            }
            existingComment.setComment(comment.getComment());
            ProductCommentVO updatedComment = commentService.updateComment(existingComment);
            return ResponseEntity.ok(updatedComment);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("評論更新失敗：" + e.getMessage());
        }
    }


    // 刪除評論的Ajax處理
    @DeleteMapping("/comments/delete/{commentId}")
    public ResponseEntity<?> deleteCommentAjax(@PathVariable Long commentId) {
        try {
            commentService.deleteComment(commentId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("刪除評論失敗：" + e.getMessage());
        }
    }


}
