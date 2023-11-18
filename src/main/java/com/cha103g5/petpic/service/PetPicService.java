package com.cha103g5.petpic.service;

import com.cha103g5.petpic.bo.PetPicInfoBO;
import com.cha103g5.petpic.model.PetPicVO;

import java.util.List;

public interface PetPicService {

    public Boolean insertPic(List<PetPicInfoBO> petPicList);
    public List<PetPicVO> getById(Integer petId);
}
