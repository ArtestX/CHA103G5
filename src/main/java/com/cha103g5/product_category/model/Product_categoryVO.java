package com.cha103g5.product_category.model;

public class Product_categoryVO implements java.io.Serializable {
    private Integer productCatNo;
    private String productCatName;

    public Integer getProductCatNo() {
        return productCatNo;
    }

    public void setProductCatNo(Integer productCatNo) {
        this.productCatNo = productCatNo;
    }

    public String getProductCatName() {
        return productCatName;
    }

    public void setProductCatName(String productCatName) {
        this.productCatName = productCatName;
    }
}
