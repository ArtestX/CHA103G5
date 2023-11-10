package com.cha103g5.petpic.vin;

import com.cha103g5.petpic.model.PetPic;

import javax.validation.constraints.NotNull;
import java.util.List;

public class InserPetInfoVIn {
    @NotNull
    private Integer petId;
    @NotNull
    private String petName;
    @NotNull
    private Integer petAge;
    private List<PetPic> petPic;

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Integer getPetAge() {
        return petAge;
    }

    public void setPetAge(Integer petAge) {
        this.petAge = petAge;
    }

    public List<PetPic> getPetPic() {
        return petPic;
    }

    public void setPetPic(List<PetPic> petPic) {
        this.petPic = petPic;
    }
}
