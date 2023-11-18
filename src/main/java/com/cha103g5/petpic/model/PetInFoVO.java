package com.cha103g5.petpic.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pet")
public class PetInFoVO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "petid", updatable=false, nullable=false)
    private Integer petId;

    @Column(name = "animaltypeno")
    private Integer animalTypeNo;

    @Column(name = "memberno")
    private Integer memberNo;

    @Column(name = "petname")
    private String petName;

    @Column(name = "petsex")
    private String petSex;

    @Column(name = "petage")
    private String petAge;

    @Column(name = "petnote")
    private String petNote;

    @Column(name = "stat", columnDefinition = "tinyint")
    private byte stat;

    @Column(name = "applicationdeadline")
    private Date applicationDeadLine;

    @OneToMany(mappedBy = "petInFo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PetPicVO> petPics;

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

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

    public byte getStat() {
        return stat;
    }

    public void setStat(byte stat) {
        this.stat = stat;
    }

    public Date getApplicationDeadLine() {
        return applicationDeadLine;
    }

    public void setApplicationDeadLine(Date applicationDeadLine) {
        this.applicationDeadLine = applicationDeadLine;
    }

    public List<PetPicVO> getPetPics() {
        return petPics;
    }

    public void setPetPics(List<PetPicVO> petPics) {
        this.petPics = petPics;
    }
}
