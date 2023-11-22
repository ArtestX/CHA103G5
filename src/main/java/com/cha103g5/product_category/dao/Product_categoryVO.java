package com.cha103g5.product_category.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productcategory")
public class Product_categoryVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productcatno", updatable = false)
    private Integer productCatNo;
	
	@Column(name = "productcatname")
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
