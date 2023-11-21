package com.cha103g5.petinfo.service;

import com.cha103g5.petinfo.model.PetInfoVO;
import com.cha103g5.petinfo.model.PetPicVO;

import java.util.List;

public interface PetinfoService {

    PetInfoVO getPetById(Integer petId);

    List<PetInfoVO> getAllPetsWithPictures(); // 更新的方法


    void addPet(PetInfoVO petInfo);

    void updatePet(PetInfoVO petInFo);

    void deletePet(Integer petId);

    PetPicVO getPetPicById(Integer picId);

    List<PetPicVO> getAllPetPics();

    void addPetPic(PetPicVO petPic);

    void updatePetPic(PetPicVO petPic);

    void deletePetPic(Integer picId);

}
