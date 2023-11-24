package com.cha103g5.cart.controller;

import com.cha103g5.cart.dao.Cart;
import com.cha103g5.cart.dto.AddToCartRequest;
import com.cha103g5.cart.service.CartService;
import com.cha103g5.product.dao.ProductRepository;
import com.cha103g5.product.dao.ProductVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/cart")
public class CombinedCartController {
    private final CartService cartService;
    private final ProductRepository productRepository;

    @Autowired
    public CombinedCartController(CartService cartService, ProductRepository productRepository) {
        this.cartService = cartService;
        this.productRepository = productRepository;
    }

    @PostMapping("/create/{memberNo}")
    public ResponseEntity<?> createCart(@PathVariable Integer memberNo, @RequestBody Cart cart) {
        cart.setMemberNo(memberNo);
        cartService.saveCart(memberNo, cart);
        return ResponseEntity.ok("購物車已創建");
    }

    @GetMapping("/{memberNo}")
    public ResponseEntity<Cart> getCart(@PathVariable Integer memberNo) {
        Cart cart = cartService.getCart(memberNo);
        if (cart != null) {
            return ResponseEntity.ok(cart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addToCart(@RequestBody AddToCartRequest addToCartRequest) {
        try {
            Integer memberNo = addToCartRequest.getMemberNo();
            Integer productNo = addToCartRequest.getProductNo();
            Integer quantity = addToCartRequest.getQuantity();

            cartService.addProductToCart(memberNo, productNo, quantity);
            return ResponseEntity.ok("商品已成功加入購物車");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }




    @DeleteMapping("/{memberNo}/delete")
    public ResponseEntity<Void> deleteCart(@PathVariable Integer memberNo) {
        cartService.deleteCart(memberNo);
        return ResponseEntity.ok().build();
    }
}
