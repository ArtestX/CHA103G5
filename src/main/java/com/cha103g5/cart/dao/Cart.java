package com.cha103g5.cart.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer memberNo; // 會員主鍵
    private Map<Integer, CartItem> items; // key: 商品編號, value: CartItem

    public Cart() {
        this.items = new HashMap<>();
    }

    // 內部類，表示購物車中的單個項目
    public static class CartItem {
        private Integer productNo;
        private Integer quantity;
        private Double price;

        public CartItem(Integer productNo, Integer quantity, Double price) {
            this.productNo = productNo;
            this.quantity = quantity;
            this.price = price;
        }

        public Integer getProductNo() {
            return productNo;
        }

        public void setProductNo(Integer productNo) {
            this.productNo = productNo;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
    }

    // 添加商品到購物車
    public void addItem(Integer productNo, Integer quantity, Double price) {
        items.put(productNo, new CartItem(productNo, quantity, price));
    }

    // 從購物車移除商品
    public void removeItem(Integer productNo) {
        items.remove(productNo);
    }

    public Integer getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Integer memberNo) {
        this.memberNo = memberNo;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }
}
