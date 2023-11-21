package com.cha103g5.petinfo.controller;

import com.cha103g5.petinfo.model.PetInfoVO;
import com.cha103g5.petinfo.service.PetinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class PetInfoController {

    @Autowired
    private PetinfoService petInfoService;


    @GetMapping("/CHA103G5/petinfo/{petId}")
    public PetInfoVO getPetById(@PathVariable Integer petId) {
        return petInfoService.getPetById(petId);
    }

    @GetMapping("/CHA103G5/petinfo")
    public List<PetInfoVO> getAllPetsWithPictures() {
        return petInfoService.getAllPetsWithPictures();
    }

    @PostMapping("/CHA103G5/petinfo")
    public void addPet(@RequestBody PetInfoVO petInFo) {
        petInfoService.addPet(petInFo);
    }

    @PutMapping("/CHA103G5/petinfo/{petId}")
    public void updatePet(@RequestBody PetInfoVO petInFo) {
        petInfoService.updatePet(petInFo);
    }

    @DeleteMapping("/CHA103G5/petinfo/{petId}")
    public void deletePet(@PathVariable Integer petId) {
        petInfoService.deletePet(petId);
    }
}
