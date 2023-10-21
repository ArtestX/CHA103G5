package com.cha103g5.product_category_detail.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product_category_detail")
public class Product_category_detail  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_cat_det_no", updatable = false)
    private Integer productCatDetNo;

    @Column(name = "product_cat_name")
    private String productCatName;

    public Integer getProductCatDetNo() {
        return productCatDetNo;
    }

    public void setProductCatDetNo(Integer productCatDetNo) {
        this.productCatDetNo = productCatDetNo;
    }

    public String getProductCatName() {
        return productCatName;
    }

    public void setProductCatName(String productCatName) {
        this.productCatName = productCatName;
    }
    
    @Override
    public String toString() {
        return "ProductCategoryDetail [productCatDetNo=" + productCatDetNo + ", productCatName=" + productCatName + "]";
    }
}
