package com.cha103g5.petpic.service;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PetInfoServiceImpl implements PetInfoService{
    @Override
    public Boolean insertPetInfo(Integer petId, String petName, Integer petAge) {
        return true;
    }
}
