package com.cha103g5.petpic.service;

import com.cha103g5.petpic.dao.PetInFoRepository;
import com.cha103g5.petpic.model.PetInFo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class PetInfoServiceImpl implements PetInfoService{

    @Autowired
    private PetInFoRepository petInFoRepository;

    @Override
    public Boolean insertPetInfo(Integer petId, Integer memberNo, String petName, String petSex, String petAge, String petNote, Byte stat, Date applicationDeadLine) {
        PetInFo petInfo = new PetInFo();
        // 設定相應的屬性值
        petInfo.setPetId(petId);
        petInfo.setMemberNo(memberNo);
        petInfo.setPetName(petName);
        petInfo.setPetSex(petSex);
        petInfo.setPetAge(petAge);
        petInfo.setPetNote(petNote);
        petInfo.setStat(stat);
        petInfo.setApplicationDeadLine(applicationDeadLine);

        petInFoRepository.save(petInfo);
        return true;
    }

    @Override
    public Boolean updatePetInfo(Integer petId, Integer memberNo, String petName, String petSex, String petAge, String petNote, Byte stat, Date applicationDeadLine) {
        // 先確認資料庫中是否存在該 petId 對應的 PetInFo
        PetInFo existingPet = petInFoRepository.findById(petId).orElse(null);

        if (existingPet != null) {
            // 更新相應的屬性值
            existingPet.setMemberNo(memberNo);
            existingPet.setPetName(petName);
            existingPet.setPetSex(petSex);
            existingPet.setPetAge(petAge);
            existingPet.setPetNote(petNote);
            existingPet.setStat(stat);
            existingPet.setApplicationDeadLine(applicationDeadLine);

            petInFoRepository.save(existingPet);
            return true;
        }

        return false; // 如果 petId 對應的 PetInFo 不存在，返回 false
    }

    @Override
    public Boolean deletePetInfo(Integer petId) {
        Optional<PetInFo> petInfoOptional = petInFoRepository.findById(petId);

        if (petInfoOptional.isPresent()) {
            PetInFo petInfo = petInfoOptional.get();
            petInFoRepository.delete(petInfo);
            return true;
        }

        return false; // 如果 petId 對應的 PetInFo 不存在，返回 fals
    }

    @Override
    public List<PetInFo> getAllPets(Integer petId) {
        return petInFoRepository.findAll();
    }

    @Override
    public PetInFo getPetById(Integer petId) {
        return petInFoRepository.findById(petId).orElse(null);
    }


}
