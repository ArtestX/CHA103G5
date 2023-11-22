package com.cha103g5.product_track.dao;

import javax.persistence.*;

@Entity
@Table(name = "product_track")
public class ProductTrackVO {
    @Column(name = "product_no")
    private int productNo;

    @Column(name = "member_no")
    private int memberNo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "track_no")
    private int trackNo;

    // 新增商品名稱字段
    @Transient // 使用 Transient 注解，因為這個字段不直接對應數據庫中的欄位
    private String productName;

    // Getters and setters
    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public int getTrackNo() {
        return trackNo;
    }

    public void setTrackNo(int trackNo) {
        this.trackNo = trackNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
