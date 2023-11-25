package com.cha103g5.petinfo.controller;

import com.cha103g5.petinfo.model.PetVO;
import com.cha103g5.petinfo.vin.InsertPetInfoVIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
public class PetInfoController {

    @Autowired
    private PetinfoService petInfoService;


    @GetMapping("/GetPetInfo/{petId}")
    public PetVO getPetById(@PathVariable Integer petId) {
        return petInfoService.getPetById(petId);
    }

    @GetMapping("/GetAllPetInfo")
    public List<PetVO> getAllPetsWithPictures() {
        return petInfoService.getAllPetsWithPictures();
    }

    @PostMapping("/addPetInfo")
    public Boolean addPet(@RequestBody @Valid InsertPetInfoVIn insertPetInfoVIn) throws IOException {

        Boolean isAddSuccess = petInfoService.addPet(insertPetInfoVIn);

        return isAddSuccess;
    }

    @PutMapping("/updatePetInfo/{petId}")
    public void updatePet(@RequestBody InsertPetInfoVIn insertPetInfoVIn) {
        petInfoService.updatePet(insertPetInfoVIn);
    }

    @DeleteMapping("/petinfo/{petId}")
    public void deletePet(@PathVariable Integer petId) {
        petInfoService.deletePet(petId);
    }
}
