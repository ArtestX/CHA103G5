package com.cha103g5.petinfo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "pet")
public class PetVO implements Serializable {

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

    @OneToMany(mappedBy = "petVo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PetPicVO> petPics;



}
