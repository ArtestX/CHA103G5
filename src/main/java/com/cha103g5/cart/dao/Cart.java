package com.cha103g5.cart.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer memberNo; // 會員主鍵
    private Map<Integer, CartItem> items; // key: 商品編號, value: CartItem

    public Cart() {
        this.items = new HashMap<>();
    }

    public static class CartItem {
        private Integer productNo;
        private Integer quantity;
        private BigDecimal price;
        private String productName;
        private String imageUrl;

        public CartItem() {
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public CartItem(Integer productNo, Integer quantity, BigDecimal price) {
            this.productNo = productNo;
            this.quantity = quantity;
            this.price = price;
        }

        @JsonIgnore
        public BigDecimal getTotalPrice() {
            return price.multiply(new BigDecimal(quantity));
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

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }
    }


    public void addItem(Integer productNo, Integer quantity, BigDecimal price) {
        items.put(productNo, new CartItem(productNo, quantity, price));
    }

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
