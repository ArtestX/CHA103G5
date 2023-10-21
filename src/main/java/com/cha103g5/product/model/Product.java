package com.cha103g5.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_no", updatable = false)
	private Integer productNo;

	@Column(name = "product_cat_no")
	private Integer productCatNo;

	@Column(name = "product_cat_det_no")
	private Integer productCatDetNo;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_price")
	private Double productPrice;

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

	@Override
	public String toString() {
		return "Product [productNo=" + productNo + ", productCatNo=" + productCatNo + ", productCatDetNo="
				+ productCatDetNo + ", productName=" + productName + ", productPrice=" + productPrice + ", productInfo="
				+ productInfo + ", productStat=" + productStat + ", productEval=" + productEval + ", productEvalTotal="
				+ productEvalTotal + ", productSaleNum=" + productSaleNum + "]";
	}

}
