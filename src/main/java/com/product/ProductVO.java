package com.product;
import java.math.BigDecimal;
import java.sql.Date;

public class ProductVO implements java.io.Serializable{
    private Integer productNo;
    private Integer productCatNo;
    private Integer productCatDetNo;
    private String productName;
    private Double productPrice;
    private String productInfo;
    private Integer productStat;
    private Integer productEval;
    private Integer productEvalTotal;
    private Integer productSaleNum;
    
    

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

    public Integer getProductCatDetNo() {
        return productCatDetNo;
    }

    public void setProductCatDetNo(Integer productCatDetNo) {
        this.productCatDetNo = productCatDetNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
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
}
