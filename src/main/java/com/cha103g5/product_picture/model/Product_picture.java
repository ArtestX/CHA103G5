package com.cha103g5.product_picture.model;

import javax.persistence.*;

@Entity
@Table(name = "product_picture")
public class Product_picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_pic_no", updatable = false)
    private Integer productPicNo;

    @Column(name = "product_no")
    private Integer productNo;

    @Column(name = "product_pic")
    private String productPic;

    public Integer getProductPicNo() {
        return productPicNo;
    }

    public void setProductPicNo(Integer productPicNo) {
        this.productPicNo = productPicNo;
    }

    public Integer getProductNo() {
        return productNo;
    }

    public void setProductNo(Integer productNo) {
        this.productNo = productNo;
    }

    public String getProductPic() {
        return productPic;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }
    
    @Override
    public String toString() {
        return "ProductPicture [productPicNo=" + productPicNo + ", productNo=" + productNo + ", productPic=" + productPic + "]";
    }
}
