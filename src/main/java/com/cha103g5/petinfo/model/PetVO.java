package com.cha103g5.petinfo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "pet")
@Table
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
    private Byte stat;

    @Column(name = "applicationdeadline")
    private Date applicationDeadLine;

    @Transient // 這個註解表示該屬性不會映射到數據庫表中
    private List<PetPicVO> petPics = new ArrayList<>();

//    @JsonBackReference
//    @OneToMany(mappedBy = "petVo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<PetPicVO> petPics;



}
