package com.cha103g5.petpic.service;

import com.cha103g5.petpic.model.PetPic;

import java.util.List;

public interface PetPicService {

    public Boolean insertPic(List<PetPic> petPicList);
    public List<PetPic> getById(Integer petId);
}
