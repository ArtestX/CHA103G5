package com.cha103g5.ordertable.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ordertable")
public class OrderTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_no", updatable = false)
    private Integer orderNo;

    @Column(name = "member_no")
    private Integer memberNo;

    @Column(name = "order_time")
    private Timestamp orderTime;

    @Column(name = "order_total")
    private BigDecimal orderTotal;

    @Column(name = "order_points_total")
    private Integer orderPointsTotal;

    @Column(name = "order_sale_price")
    private BigDecimal orderSalePrice;

    @Column(name = "order_stat")
    private Integer orderStat;

    @Column(name = "ship_stat")
    private Integer shipStat;

    @Column(name = "payment_stat")
    private Integer paymentStat;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "credit_card")
    private String creditCard;

    @Column(name = "remit_account")
    private String remitAccount;

    @Column(name = "point_used_order")
    private Integer pointUsedOrder;

    @Column(name = "ship_method")
    private String shipMethod;

    @Column(name = "order_address")
    private String orderAddress;

    @Column(name = "ship_name")
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

    @Override
    public String toString() {
        return "OrderTable [orderNo=" + orderNo + ", memberNo=" + memberNo + ", orderTime=" + orderTime + ", orderTotal=" + orderTotal +
                ", orderPointsTotal=" + orderPointsTotal + ", orderSalePrice=" + orderSalePrice + ", orderStat=" + orderStat +
                ", shipStat=" + shipStat + ", paymentStat=" + paymentStat + ", paymentMethod=" + paymentMethod +
                ", creditCard=" + creditCard + ", remitAccount=" + remitAccount + ", pointUsedOrder=" + pointUsedOrder +
                ", shipMethod=" + shipMethod + ", orderAddress=" + orderAddress + ", shipName=" + shipName + "]";
    }
}
