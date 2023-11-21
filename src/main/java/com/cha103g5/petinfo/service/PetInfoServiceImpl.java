package com.cha103g5.petinfo.service;

import com.cha103g5.petinfo.model.PetInfoVO;
import com.cha103g5.petinfo.model.PetPicVO;
import com.cha103g5.petinfo.repository.PetInfoRepository;
import com.cha103g5.petinfo.repository.PetPicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PetInfoServiceImpl implements PetinfoService{

    @Autowired
    private PetInfoRepository petInFoRepository;

    @Autowired
    private PetPicRepository petPicRepository;

    @Override
    public PetInfoVO getPetById(Integer petId) {
        return petInFoRepository.getPetWithPicsById(petId).orElse(null);
    }

    @Override
    public List<PetInfoVO> getAllPetsWithPictures() {
        return null;
    }

    @Override
    public void addPet(PetInfoVO petInfo) {

    }

    @Override
    public void updatePet(PetInfoVO petInFo) {

    }

    @Override
    public void deletePet(Integer petId) {

    }

    @Override
    public PetPicVO getPetPicById(Integer picId) {
        return null;
    }

    @Override
    public List<PetPicVO> getAllPetPics() {
        return null;
    }

    @Override
    public void addPetPic(PetPicVO petPic) {

    }

    @Override
    public void updatePetPic(PetPicVO petPic) {

    }

    @Override
    public void deletePetPic(Integer picId) {

    }
}
