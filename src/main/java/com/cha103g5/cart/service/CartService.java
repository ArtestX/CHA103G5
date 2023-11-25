package com.cha103g5.cart.service;

import com.cha103g5.cart.dao.Cart;
import com.cha103g5.product.dao.ProductRepository;
import com.cha103g5.product.dao.ProductVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public void addProductToCart(Integer memberNo, Integer productNo, Integer quantity) {
        try {
            Cart cart = getCart(memberNo);
            if (cart == null) {
                cart = new Cart();
                cart.setMemberNo(memberNo);
            }
            ProductVO product = productRepository.findById(productNo)
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            Cart.CartItem item = cart.getItems().get(productNo);
            if (item != null) {
                item.setQuantity(item.getQuantity() + quantity);
            } else {
                item = new Cart.CartItem(productNo, quantity, product.getProductPrice());
                cart.getItems().put(productNo, item);
            }

            // 更新商品名稱
            item.setProductName(product.getProductName());

            // 直接使用保存在ProductVO中的圖片路徑
            item.setImageUrl(product.getFirstProductImagePath());

            saveCart(memberNo, cart);
        } catch (Exception e) {
            throw new RuntimeException("Error adding product to cart", e);
        }
    }



    private String getCartKey(Integer memberNo) {
        return "cart:" + memberNo;
    }


    public void updateProductQuantity(Integer memberNo, Integer productNo, Integer quantity) {
        Cart cart = getCart(memberNo);
        if (cart != null && cart.getItems().containsKey(productNo)) {
            Cart.CartItem item = cart.getItems().get(productNo);
            if (quantity > 0) {
                item.setQuantity(quantity);
            } else {
                cart.getItems().remove(productNo);
            }
            saveCart(memberNo, cart); // 這會將更新寫入到 Redis
        }
    }

    public void deleteProductFromCart(Integer memberNo, Integer productNo) {
        Cart cart = getCart(memberNo);
        if (cart != null) {
            cart.getItems().remove(productNo);
            saveCart(memberNo, cart);
        }
    }

    public BigDecimal calculateTotalPrice(Integer memberNo) {
        Cart cart = getCart(memberNo);
        if (cart == null) {
            return BigDecimal.ZERO;
        }
        return cart.getItems().values().stream()
                .map(Cart.CartItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
