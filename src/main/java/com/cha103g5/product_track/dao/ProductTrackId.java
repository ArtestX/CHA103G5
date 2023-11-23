package com.cha103g5.product_track.dao;
import java.io.Serializable;
import java.util.Objects;

public class ProductTrackId implements Serializable {
    private int productNo;
    private int memberNo;

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

    // 覆寫 equals 和 hashCode 方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductTrackId)) return false;
        ProductTrackId that = (ProductTrackId) o;
        return productNo == that.productNo &&
                memberNo == that.memberNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNo, memberNo);
    }
}
