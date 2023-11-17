package com.cha103g5.petpic.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pet")
public class PetInFo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "petId", updatable=false, nullable=false)
    private Integer petId;

    @Column(name = "animalTypeNo")
    private Integer animalTypeNo;

    @Column(name = "memberNo")
    private Integer memberNo;

    @Column(name = "petName")
    private String petName;

    @Column(name = "petSex")
    private String petSex;

    @Column(name = "petAge")
    private String petAge;

    @Column(name = "petNote")
    private String petNote;

    @Column(name = "stat", columnDefinition = "tinyint")
    private byte stat;

    @Column(name = "applicationDeadLine")
    private Date applicationDeadLine;

    @OneToMany(mappedBy = "petInFo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PetPic> petPics;

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

    public List<PetPic> getPetPics() {
        return petPics;
    }

    public void setPetPics(List<PetPic> petPics) {
        this.petPics = petPics;
    }
}
