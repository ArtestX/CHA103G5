package com.cha103g5.order.orderdetail.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orderdetail")
public class OrderDetailVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderdetailno")
    private Integer orderDetailNo;

    @Column(name = "ordertableno", nullable = false)
    private Integer orderTableNo;

    @Column(name = "productno", nullable = false)
    private Integer productNo;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "productprice", nullable = false)
    private Integer productPrice;

}
