package com.cha103g5.product_category.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product_category")
public class Product_category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_cat_no", updatable = false)
    private Integer productCatNo;
	
	@Column(name = "product_cat_name")
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
    
    @Override
    public String toString() {
        return "Product_category [productCatNo=" + productCatNo + ", productCatName=" + productCatName +"]";
    }
}
