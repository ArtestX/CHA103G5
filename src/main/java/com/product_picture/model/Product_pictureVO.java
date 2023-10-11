package com.product_picture.model;

public class Product_pictureVO implements java.io.Serializable {
    private Integer productPicNo;
    private Integer productNo;
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
}
