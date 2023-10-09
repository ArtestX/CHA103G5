package com.cha103g5.csimg.model;

public class CSImgVO {

    private Integer pictureNo;
    private Integer recordNo;
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