package com.cha103g5.petpic.controller;

import com.cha103g5.petpic.model.PetPic;
import com.cha103g5.petpic.service.PetInfoService;
import com.cha103g5.petpic.service.PetPicService;
import com.cha103g5.petpic.vin.InserPetInfoVIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Validated
@RestController
public class PetpicController {

    @Autowired
    private PetPicService petPicService;
    @Autowired
    private PetInfoService petInfoService;


    @PostMapping("/pet")
    public String insertList(@PathVariable InserPetInfoVIn inserPetInfoVIn) {
        // 流程控制通常在查詢會用
        Boolean goNext = true;
        Integer id = null;
        String name = null;
        Integer age = null;
        List<PetPic> img = null;

        //  錯誤驗證
        try {
            if (inserPetInfoVIn != null || inserPetInfoVIn.getPetId() != null
            || inserPetInfoVIn.getPetName() != null || inserPetInfoVIn.getPetAge() != null) {
                 id = inserPetInfoVIn.getPetId();
                 name = inserPetInfoVIn.getPetName();
                 age = inserPetInfoVIn.getPetAge();
                 img = inserPetInfoVIn.getPetPic();
            } else {
                goNext = false;
            }
        } catch (Exception e) {
            return "不能為空值";
        }

        //  新增寵物資訊
        if (goNext) {
            try {
                Boolean insertPetInfoSuccess = petInfoService.insertPetInfo(id, name, age);

                if (insertPetInfoSuccess = false) {
                    goNext = insertPetInfoSuccess;
                }
            } catch (Exception e) {
                System.out.println("新增寵物資料錯誤" + e);
            }
        }

        //  新增寵物照片
        if (goNext) {
            try {
                Boolean insertPetPicSuccess = petPicService.insertPic(img);
            } catch (Exception e) {
                System.out.println("新增照片錯誤" + e);
            }

        }



        return "新增操作成功";
    }

    @DeleteMapping("/petpic/{picId}")
    public String delete() {
        return "刪除成功";
    }

    @GetMapping("/petpic/{petId}")
    public List<PetPic> getById(@PathVariable Integer petId) {

        return petPicService.getById(petId);
    }

}
