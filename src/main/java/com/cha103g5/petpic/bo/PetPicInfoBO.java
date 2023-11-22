package com.cha103g5.petpic.bo;

public class PetPicInfoBO {

    private Integer picId;

    private Integer petId;

    private byte[] petPic;

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public byte[] getPetPic() {
        return petPic;
    }

    public void setPetPic(byte[] petPic) {
        this.petPic = petPic;
    }

}
