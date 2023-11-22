package com.cha103g5.product.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cha103g5.product_picture.dao.ProductPictureVO;

@Entity
@Table(name = "product")
public class ProductVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_no", updatable = false)
    private Integer productNo;

    @Column(name = "product_cat_no")
    private Integer productCatNo;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private BigDecimal productPrice;

    @Column(name = "product_info")
    private String productInfo;

    @Column(name = "product_stat")
    private Integer productStat;

    @Column(name = "product_eval")
    private Integer productEval;

    @Column(name = "product_eval_total")
    private Integer productEvalTotal;

    @Column(name = "product_sale_num")
    private Integer productSaleNum;

    // 使用 @OneToMany 註解來定義與 ProductPictureVO 的一對多關聯
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductPictureVO> productPictures = new ArrayList<>();

    // Getters and Setters
    public Integer getProductNo() {
        return productNo;
    }

    public void setProductNo(Integer productNo) {
        this.productNo = productNo;
    }

    public Integer getProductCatNo() {
        return productCatNo;
    }

    public void setProductCatNo(Integer productCatNo) {
        this.productCatNo = productCatNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public Integer getProductStat() {
        return productStat;
    }

    public void setProductStat(Integer productStat) {
        this.productStat = productStat;
    }

    public Integer getProductEval() {
        return productEval;
    }

    public void setProductEval(Integer productEval) {
        this.productEval = productEval;
    }

    public Integer getProductEvalTotal() {
        return productEvalTotal;
    }

    public void setProductEvalTotal(Integer productEvalTotal) {
        this.productEvalTotal = productEvalTotal;
    }

    public Integer getProductSaleNum() {
        return productSaleNum;
    }

    public void setProductSaleNum(Integer productSaleNum) {
        this.productSaleNum = productSaleNum;
    }

    public List<ProductPictureVO> getProductPictures() {
        return productPictures;
    }

    public void setProductPictures(List<ProductPictureVO> productPictures) {
        this.productPictures = productPictures;
    }

    // 可以添加一個方法來獲取所有圖片的路徑
    public List<String> getProductImagePaths() {
        List<String> imagePaths = new ArrayList<>();
        for (ProductPictureVO picture : productPictures) {
            imagePaths.add(picture.getProductPic());
        }
        return imagePaths;
    }

    // 可以添加一個方法來獲取第一張圖片的路徑
    public String getFirstProductImagePath() {
        if (productPictures != null && !productPictures.isEmpty()) {
            return productPictures.get(0).getProductPic();
        }
        return null; // 或者返回一個預設的圖片路徑
    }
}

