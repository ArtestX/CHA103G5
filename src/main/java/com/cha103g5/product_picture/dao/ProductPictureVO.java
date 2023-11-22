// ProductPictureVO.java
package com.cha103g5.product_picture.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cha103g5.product.dao.ProductVO;

@Entity
@Table(name = "product_picture")
public class ProductPictureVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_pic_no")
    private Integer productPicNo;

    @ManyToOne
    @JoinColumn(name = "product_no", referencedColumnName = "product_no")
    private ProductVO product;

    @Column(name = "product_pic")
    private String productPic; // 儲存圖片的檔案名稱或路徑

    public Integer getProductPicNo() {
        return productPicNo;
    }

    public void setProductPicNo(Integer productPicNo) {
        this.productPicNo = productPicNo;
    }

    public ProductVO getProduct() {
        return product;
    }

    public void setProduct(ProductVO product) {
        this.product = product;
    }

    public String getProductPic() {
        return productPic;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }
}
