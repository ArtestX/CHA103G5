package com.cha103g5.petinfo.service;

import com.cha103g5.petinfo.dto.PetInfoDto;
import com.cha103g5.petinfo.model.PetVO;
import com.cha103g5.petinfo.model.PetPicVO;
import com.cha103g5.petinfo.vin.InsertPetInfoVIn;

import java.io.IOException;
import java.util.List;

public interface PetInfoService {

    PetInfoDto getPetById(Integer petId);

    List<PetVO> getAllPetsWithPictures(); // 更新的方法


    Boolean addPet(InsertPetInfoVIn insertPetInfoVIn) throws IOException;

    Boolean updatePet(InsertPetInfoVIn insertPetInfoVIn);

    Boolean deletePet(Integer petId);

    PetPicVO getPetPicById(Integer picId);

    List<PetPicVO> getAllPetPics();

    void addPetPic(PetPicVO petPic);

    void updatePetPic(PetPicVO petPic);

    void deletePetPic(Integer picId);

}
