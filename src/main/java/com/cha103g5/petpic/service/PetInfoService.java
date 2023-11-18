package com.cha103g5.petpic.service;

import com.cha103g5.petpic.model.PetInFoVO;

import java.util.Date;
import java.util.List;

public interface PetInfoService {


    public Boolean insertPetInfo ( Integer animalTypeNo, Integer memberNo,
                                  String petName, String petSex,
                                  String petAge, String petNote,
                                  Byte stat, Date applicationDeadLine);
    public Boolean updatePetInfo (Integer petId, Integer memberNo,
                                  String petName, String petSex,
                                  String petAge, String petNote,
                                  Byte stat, Date applicationDeadLine);

    public Boolean deletePetInfo (Integer petId);

    public List<PetInFoVO> getAllPets(Integer petId);

    public PetInFoVO getPetById(Integer petId);


}
