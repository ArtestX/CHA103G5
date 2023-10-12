package com.cha103g5.order.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class orderVO implements java.io.Serializable {
	private Integer orderNo;
	private Integer memberNo;
	private Timestamp orderTime;
	private BigDecimal orderTotal;
	private Integer orderPointsTotal;
	private BigDecimal orderSalePrice;
	private Integer orderStat;
	private Integer shipStat;
	private Integer paymentStat;
	private String paymentMethod;
	private String creditCard;
	private String remitAccount;
	private Integer pointUsedOrder;
	private String shipMethod;
	private String orderAddress;
	private String shipName;

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public BigDecimal getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(BigDecimal orderTotal) {
		this.orderTotal = orderTotal;
	}

	public Integer getOrderPointsTotal() {
		return orderPointsTotal;
	}

	public void setOrderPointsTotal(Integer orderPointsTotal) {
		this.orderPointsTotal = orderPointsTotal;
	}

	public BigDecimal getOrderSalePrice() {
		return orderSalePrice;
	}

	public void setOrderSalePrice(BigDecimal orderSalePrice) {
		this.orderSalePrice = orderSalePrice;
	}

	public Integer getOrderStat() {
		return orderStat;
	}

	public void setOrderStat(Integer orderStat) {
		this.orderStat = orderStat;
	}

	public Integer getShipStat() {
		return shipStat;
	}

	public void setShipStat(Integer shipStat) {
		this.shipStat = shipStat;
	}

	public Integer getPaymentStat() {
		return paymentStat;
	}

	public void setPaymentStat(Integer paymentStat) {
		this.paymentStat = paymentStat;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public String getRemitAccount() {
		return remitAccount;
	}

	public void setRemitAccount(String remitAccount) {
		this.remitAccount = remitAccount;
	}

	public Integer getPointUsedOrder() {
		return pointUsedOrder;
	}

	public void setPointUsedOrder(Integer pointUsedOrder) {
		this.pointUsedOrder = pointUsedOrder;
	}

	public String getShipMethod() {
		return shipMethod;
	}

	public void setShipMethod(String shipMethod) {
		this.shipMethod = shipMethod;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

}
