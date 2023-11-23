package com.cha103g5.cart.controller;

import com.cha103g5.cart.dao.CartVO;
import com.cha103g5.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Cart")
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<CartVO> createCart(@RequestBody CartVO cart) {
        CartVO newCart = cartService.createCart(cart);
        return ResponseEntity.ok(newCart);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartVO> getCart(@PathVariable Integer id) {
        return cartService.getCartById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update")
    public ResponseEntity<CartVO> updateCart(@RequestBody CartVO cart) {
        CartVO updatedCart = cartService.updateCart(cart);
        return ResponseEntity.ok(updatedCart);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteCart(@PathVariable Integer id) {
        cartService.deleteCart(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addToCart(@RequestParam("memberNo") Integer memberNo,
                                       @RequestParam("productNo") Integer productNo,
                                       @RequestParam("quantity") Integer quantity) {
        // 假設您有一個方法來處理添加商品到購物車的邏輯
        boolean success = cartService.addProductToCart(memberNo, productNo, quantity);

        if (success) {
            return ResponseEntity.ok("商品已成功加入購物車");
        } else {
            return ResponseEntity.badRequest().body("無法加入商品到購物車");
        }
    }
}
