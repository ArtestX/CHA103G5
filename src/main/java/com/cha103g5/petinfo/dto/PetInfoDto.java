package com.cha103g5.petinfo.dto;

import com.cha103g5.petinfo.model.PetVO;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class PetInfoDto {

    private Integer petId;

    private Integer animalTypeNo;

    private Integer memberNo;

    private String petName;

    private String petSex;

    private String petAge;

    private String petNote;

    private Byte stat;

    private Date applicationDeadLine;

    private Integer picId;

    private byte[] petPic;

    public PetInfoDto(Integer petId, Integer animalTypeNo, Integer memberNo, String petName, String petSex, String petAge, String petNote, Byte stat, Date applicationDeadLine, Integer picId, byte[] petPic) {
        this.petId = petId;
        this.animalTypeNo = animalTypeNo;
        this.memberNo = memberNo;
        this.petName = petName;
        this.petSex = petSex;
        this.petAge = petAge;
        this.petNote = petNote;
        this.stat = stat;
        this.applicationDeadLine = applicationDeadLine;
        this.picId = picId;
        this.petPic = petPic;
    }

    public PetInfoDto() {
    }
}
