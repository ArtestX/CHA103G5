package com.cha103g5.petinfo.vin;


import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
public class InsertPetInfoVIn {

    private Integer petId;
    @NotNull
    private Integer animalTypeNo;

    private Integer memberNo;

    @NotNull
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
