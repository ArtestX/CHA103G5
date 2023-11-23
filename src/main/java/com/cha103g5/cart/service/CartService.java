package com.cha103g5.cart.service;

import com.cha103g5.cart.dao.Cart;
import com.cha103g5.product.dao.ProductRepository;
import com.cha103g5.product.dao.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CartService {
    private final RedisTemplate<String, Object> redisTemplate;
    private final ProductRepository productRepository;


    @Autowired
    public CartService(RedisTemplate<String, Object> redisTemplate, ProductRepository productRepository) {
        this.redisTemplate = redisTemplate;
        this.productRepository = productRepository;
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

    public void addProductToCart(Integer memberNo, Integer productNo, Integer quantity, BigDecimal productPrice) {
        Cart cart = getCart(memberNo);

        if (cart == null) {
            cart = new Cart();
            cart.setMemberNo(memberNo);
        }

        // 根據商品編號查找商品信息
        ProductVO product = productRepository.findById(productNo).orElse(null);

        if (product != null) {
            // 獲取商品名稱和價格
            String productName = product.getProductName();
            BigDecimal price = product.getProductPrice();

            cart.addItem(productNo, quantity, price);
            saveCart(memberNo, cart);
        }
    }



    private String getCartKey(Integer memberNo) {
        return "cart:" + memberNo;
    }
}
