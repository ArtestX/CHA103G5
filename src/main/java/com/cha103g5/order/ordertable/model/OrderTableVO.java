package com.cha103g5.order.ordertable.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ordertable")
public class OrderTableVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderTableNo")
    private Integer orderTableNo;

    @Column(name = "memberno", nullable = false)
    private Integer memberNo;

    @Column(name = "ordertime", nullable = false, updatable = false)
    private Timestamp orderTime;

    @Column(name = "totalamount", nullable = false)
    private Integer totalAmount;

    @Column(name = "orderstat", nullable = false)
    private Byte orderStat;

    @Column(name = "paymentmethod", nullable = false)
    private Byte paymentMethod;

    @Column(name = "shipmethod", nullable = false)
    private Byte shipMethod;

    @Column(name = "shippingaddress", nullable = false)
    private String shippingAddress;

}
