package com.cha103g5.customerserviceimage.model;

import javax.persistence.*;

@Entity
@Table(name = "customerserviceimage")
public class CSImgVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pictureno", updatable = false)
    private Integer pictureNo;

    @Column(name = "recordno")
    private Integer recordNo;

    @Column(name = "picture")
    private byte[] picture;


    public Integer getPictureNo() {
        return pictureNo;
    }

    public void setPictureNo(Integer pictureNo) {
        this.pictureNo = pictureNo;
    }

    public Integer getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(Integer recordNo) {
        this.recordNo = recordNo;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}