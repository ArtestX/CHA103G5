package com.cha103g5.petinfo.controller;

import com.cha103g5.petinfo.dto.PetInfoDto;
import com.cha103g5.petinfo.model.PetVO;
import com.cha103g5.petinfo.service.PetInfoService;
import com.cha103g5.petinfo.vin.InsertPetInfoVIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
public class PetInfoController {

    @Autowired
    private PetInfoService petInfoService;


    @GetMapping("/GetPetInfo/{petId}")
    public PetInfoDto getPetById(@PathVariable Integer petId) {

        return petInfoService.getPetById(petId);
    }

    @GetMapping("/GetAllPetInfo")
    public List<PetVO> getAllPetsWithPictures() {
        return petInfoService.getAllPetsWithPictures();
    }

    @PostMapping("/addPetInfo")
    public Boolean addPet(@RequestBody @Valid InsertPetInfoVIn insertPetInfoVIn) throws IOException {

        return petInfoService.addPet(insertPetInfoVIn);
    }

    @PutMapping("/updatePetInfo/{petId}")
    public ResponseEntity<String> updatePet(@RequestBody InsertPetInfoVIn insertPetInfoVIn) {
        boolean isSuccess = petInfoService.updatePet(insertPetInfoVIn);

        if (isSuccess) {
            return ResponseEntity.ok("寵物資訊更新成功");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("寵物資訊更新失敗");
        }
    }

    @DeleteMapping("/deletePetInfo/{petId}")
    public ResponseEntity<String> deletePet(@PathVariable Integer petId) {
        boolean isSuccess = petInfoService.deletePet(petId);

        if (isSuccess) {
            return ResponseEntity.ok("寵物資訊刪除成功");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("寵物資訊刪除失敗");
        }
    }

    @GetMapping("/pets")
    public String listPets(Model model) {
        List<PetVO> pets = petInfoService.getAllPetsWithPictures();
        System.out.println("Pets: " + pets);
        model.addAttribute("pets", pets);
        return "pets"; // JSP 頁面名稱
    }
}
