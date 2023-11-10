package com.cha103g5.petpic.service;

import com.cha103g5.petpic.dao.PetPicDao;
import com.cha103g5.petpic.model.PetPic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PetPicServiceImpl implements PetPicService {

    @Autowired
    private PetPicDao petPicDao;


    @Override
    public Boolean insertPic(List<PetPic> petPicList) {
        return true;
    }

    public List<PetPic> getById(Integer petId) {
        return petPicDao.getById(petId);
    }
}
