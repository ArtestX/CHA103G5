package com.cha103g5.petpic.service;

import com.cha103g5.petpic.bo.PetPicInfoBO;
import com.cha103g5.petpic.dao.PetInFoRepository;
import com.cha103g5.petpic.model.PetPicVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PetPicServiceImpl implements PetPicService {

    @Autowired
    private PetInFoRepository petDao;


    @Override
    public Boolean insertPic(List<PetPicInfoBO> petPicList) {
        return true;
    }

    public List<PetPicVO> getById(Integer petId) {
        return (List<PetPicVO>) petDao.getById(petId);
    }
}
