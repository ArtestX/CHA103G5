package com.cha103g5.petpic.controller;

import com.cha103g5.petpic.bo.PetPicInfoBO;
import com.cha103g5.petpic.model.PetPicVO;
import com.cha103g5.petpic.service.PetInfoService;
import com.cha103g5.petpic.service.PetPicService;
import com.cha103g5.petpic.vin.InserPetInfoVIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Validated
@RestController
public class PetInfoController {

    @Autowired
    private PetInfoService petInfoService;
    @Autowired
    private PetPicService petPicService;

    private String petNameReg =  "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
    @PostMapping("/petinfo")
    public String insertList(@RequestBody InserPetInfoVIn inserPetInfoVIn) {
        // 流程控制通常在查詢會用
        Boolean goNext = true;

        Integer id = null;
        Integer type = null;
        Integer memNo = null;
        String name = null;
        String sex = null;
        String age = null;
        String note = null;
        Byte stat = null;
        Date deadLine = null;
        List<PetPicInfoBO> img = null;

        //  錯誤驗證
        try {
            if ( !inserPetInfoVIn.getPetName().isBlank() && !inserPetInfoVIn.getPetName().matches(petNameReg)
                && !inserPetInfoVIn.getPetAge().isBlank() && !inserPetInfoVIn.getPetSex().isBlank()
                && inserPetInfoVIn.getStat() != null ) {
                 type = inserPetInfoVIn.getAnimalTypeNo();
                 memNo = inserPetInfoVIn.getMemberNo();
                 name = inserPetInfoVIn.getPetName();
                 sex = inserPetInfoVIn.getPetSex();
                 age = inserPetInfoVIn.getPetAge();
                 note = inserPetInfoVIn.getPetNote();
                 stat = inserPetInfoVIn.getStat();
                 img = inserPetInfoVIn.getPetPicInfo();
            } else {
                goNext = false;
            }
        } catch (Exception e) {
            return "不能為空值";
        }

        //  新增寵物資訊
        if (goNext) {
            try {
                petInfoService.insertPetInfo(type, memNo, name, sex, age, note, stat, deadLine);
                Boolean insertPetInfoSuccess;

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
                petPicService.insertPic(img);
            } catch (Exception e) {
                System.out.println("新增照片錯誤" + e);
            }

        }



        return "新增操作成功";
    }

    @PostMapping("/petinfo/{petId}")
    public String updateList(@RequestBody InserPetInfoVIn inserPetInfoVIn) {
        Boolean goNext = true;

        Integer id = null;
        Integer type = null;
        Integer memNo = null;
        String name = null;
        String sex = null;
        String age = null;
        String note = null;
        Byte stat = null;
        Date deadLine = null;
        List<PetPicInfoBO> img = null;

        //  錯誤驗證
        try {
            if ( !inserPetInfoVIn.getPetName().isBlank() && !inserPetInfoVIn.getPetName().matches(petNameReg)
                    && !inserPetInfoVIn.getPetAge().isBlank() && !inserPetInfoVIn.getPetSex().isBlank()
                    && inserPetInfoVIn.getStat() != null ) {
                type = inserPetInfoVIn.getAnimalTypeNo();
                memNo = inserPetInfoVIn.getMemberNo();
                name = inserPetInfoVIn.getPetName();
                sex = inserPetInfoVIn.getPetSex();
                age = inserPetInfoVIn.getPetAge();
                note = inserPetInfoVIn.getPetNote();
                stat = inserPetInfoVIn.getStat();
                img = inserPetInfoVIn.getPetPicInfo();
            } else {
                goNext = false;
            }
        } catch (Exception e) {
            return "不能為空值";
        }

        //  新增寵物資訊
        if (goNext) {
            try {
                petInfoService.updatePetInfo(id, memNo, name, sex, age, note, stat, deadLine);
                Boolean insertPetInfoSuccess;

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
                petPicService.insertPic(img);
            } catch (Exception e) {
                System.out.println("新增照片錯誤" + e);
            }

        }


        return "更新操作成功";
    }

    @DeleteMapping("/petpic/{picId}")
    public String delete() {
        return "刪除成功";
    }

    @GetMapping("/petpic/{petId}")
    public List<PetPicVO> getById(@PathVariable Integer petId) {

        return petPicService.getById(petId);
    }

}
