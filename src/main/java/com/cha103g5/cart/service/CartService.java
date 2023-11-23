package com.cha103g5.cart.service;

import com.cha103g5.cart.dao.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public CartService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveCart(Integer memberNo, Cart cart) {
        redisTemplate.opsForValue().set(getCartKey(memberNo), cart);
    }

    public Cart getCart(Integer memberNo) {
        return (Cart) redisTemplate.opsForValue().get(getCartKey(memberNo));
    }

    public void deleteCart(Integer memberNo) {
        redisTemplate.delete(getCartKey(memberNo));
    }

    public void addProductToCart(Integer memberNo, Integer productNo, Integer quantity, Double price) {
        Cart cart = getCart(memberNo);

        if (cart == null) {
            cart = new Cart();
            cart.setMemberNo(memberNo);
        }

        cart.addItem(productNo, quantity, price);
        saveCart(memberNo, cart);
    }

    private String getCartKey(Integer memberNo) {
        return "cart:" + memberNo;
    }
}
