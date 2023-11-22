package com.cha103g5.petpic.vin;

import com.cha103g5.petpic.bo.PetPicInfoBO;

import java.util.Date;
import java.util.List;

public class InserPetInfoVIn {


    private Integer animalTypeNo;

    private Integer memberNo;

    private String petName;

    private String petSex;

    private String petAge;

    private String petNote;

    private Byte stat;

    private Date applicationDeadLine;

    private List<PetPicInfoBO> petPicInfo;


    public Integer getAnimalTypeNo() {
        return animalTypeNo;
    }

    public void setAnimalTypeNo(Integer animalTypeNo) {
        this.animalTypeNo = animalTypeNo;
    }

    public Integer getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Integer memberNo) {
        this.memberNo = memberNo;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetSex() {
        return petSex;
    }

    public void setPetSex(String petSex) {
        this.petSex = petSex;
    }

    public String getPetAge() {
        return petAge;
    }

    public void setPetAge(String petAge) {
        this.petAge = petAge;
    }

    public String getPetNote() {
        return petNote;
    }

    public void setPetNote(String petNote) {
        this.petNote = petNote;
    }

    public Byte getStat() {
        return stat;
    }

    public void setStat(Byte stat) {
        this.stat = stat;
    }

    public Date getApplicationDeadLine() {
        return applicationDeadLine;
    }

    public void setApplicationDeadLine(Date applicationDeadLine) {
        this.applicationDeadLine = applicationDeadLine;
    }

    public List<PetPicInfoBO> getPetPicInfo() {
        return petPicInfo;
    }

    public void setPetPicInfo(List<PetPicInfoBO> petPicInfo) {
        this.petPicInfo = petPicInfo;
    }
}
