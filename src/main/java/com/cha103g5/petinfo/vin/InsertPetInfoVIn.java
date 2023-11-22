package com.cha103g5.petinfo.vin;


import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class InsertPetInfoVIn {


    @NotNull
    private Integer animalTypeNo;

    private Integer memberNo;

    @NotNull
    @Size(min = 1, max = 2, message = "寵物名稱長度應在1到2個字元之間")
    private String petName;

    @NotNull
    private String petSex;

    @NotNull
    private String petAge;

    private String petNote;

    @NotNull
    private Byte stat;

    @NotNull
    private Date applicationDeadLine;

    private String[] petPic;

}
