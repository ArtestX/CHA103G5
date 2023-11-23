package com.cha103g5.cart.controller;

import com.cha103g5.cart.dao.Cart;
import com.cha103g5.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
                                       @RequestParam("price") Double price) {
        cartService.addProductToCart(memberNo, productNo, quantity, price);
        return ResponseEntity.ok("商品已成功加入購物車");
    }

    @DeleteMapping("/{memberNo}/delete")
    public ResponseEntity<Void> deleteCart(@PathVariable Integer memberNo) {
        cartService.deleteCart(memberNo);
        return ResponseEntity.ok().build();
    }

}
