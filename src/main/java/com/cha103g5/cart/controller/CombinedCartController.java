package com.cha103g5.cart.controller;

import com.cha103g5.cart.dao.Cart;
import com.cha103g5.cart.service.CartService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;

@Controller
@RequestMapping("/cart")
public class CombinedCartController {
    private final CartService cartService;

    @Autowired
    public CombinedCartController(CartService cartService) {
        this.cartService = cartService;
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
    public ResponseEntity<?> addToCart(@RequestParam("memberNo") Integer memberNo,
                                       @RequestParam("productNo") Integer productNo,
                                       @RequestParam("quantity") Integer quantity,
                                       @RequestBody Cart cart) {
        // 使用 cart 執行相關處理
        // 首先獲取特定商品的 CartItem
        Cart.CartItem cartItem = cart.getItems().get(productNo);
        if (cartItem != null) {
            // 獲取商品價格
            BigDecimal price = cartItem.getPrice();

            // 調用 cartService 的方法，傳遞價格（price）
            cartService.addProductToCart(memberNo, productNo, quantity, price);
            return ResponseEntity.ok("商品已成功加入購物車");
        } else {
            return ResponseEntity.badRequest().body("找不到指定商品");
        }
    }





    @DeleteMapping("/{memberNo}/delete")
    public ResponseEntity<Void> deleteCart(@PathVariable Integer memberNo) {
        cartService.deleteCart(memberNo);
        return ResponseEntity.ok().build();
    }

}
