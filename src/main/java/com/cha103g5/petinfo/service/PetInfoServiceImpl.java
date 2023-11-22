package com.cha103g5.petinfo.service;

import com.cha103g5.petinfo.model.PetVO;
import com.cha103g5.petinfo.model.PetPicVO;
import com.cha103g5.petinfo.repository.PetPicRepository;
import com.cha103g5.petinfo.repository.PetRepository;
import com.cha103g5.petinfo.vin.InsertPetInfoVIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Component
public class PetInfoServiceImpl implements PetinfoService{

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetPicRepository petPicRepository;

    @Override
    public PetVO getPetById(Integer petId) {
//        return petRepository.getPetWithPicsById(petId).orElse(null);
        return null;
    }

    @Override
    public List<PetVO> getAllPetsWithPictures() {
        return null;
    }

    @Override
    public Boolean addPet(InsertPetInfoVIn insertPetInfoVIn) {
        //儲存寵物資訊
        PetVO savePetVo;
        try {
            PetVO petVO = new PetVO();

            petVO.setAnimalTypeNo(insertPetInfoVIn.getAnimalTypeNo());
            petVO.setMemberNo(insertPetInfoVIn.getMemberNo());
            petVO.setPetName(insertPetInfoVIn.getPetName());
            petVO.setPetSex(insertPetInfoVIn.getPetSex());
            petVO.setPetAge(insertPetInfoVIn.getPetAge());
            petVO.setPetNote(insertPetInfoVIn.getPetNote());
            petVO.setStat(insertPetInfoVIn.getStat());
            petVO.setApplicationDeadLine(insertPetInfoVIn.getApplicationDeadLine());

            savePetVo = petRepository.save(petVO);
        } catch (Exception e) {
            System.out.println("新增寵物資訊錯誤");
            return false;
        }

        if (insertPetInfoVIn.getPetPic() != null && insertPetInfoVIn.getPetPic().length != 0) {
            //儲存寵物圖片
            try {
                List<PetPicVO> petPics = new ArrayList<>();

                for (String base64String : insertPetInfoVIn.getPetPic()) {
                    // 移除 data URL 開頭部分，只保留 base64 部分
                    String base64Data = base64String.replaceFirst("data:image/.*;base64,", "");

                    // 解碼 base64 字串為 byte[]
                    byte[] imageData = Base64.getDecoder().decode(base64Data);

                    // 創建 PetPicVO 對象，設定相應的屬性
                    PetPicVO petPicVO = new PetPicVO();
                    petPicVO.setPetId(savePetVo.getPetId());
                    petPicVO.setPetPic(imageData);

                    // 將 PetPicVO 添加到列表中
                    petPics.add(petPicVO);
                }
                //一次性的新增
                petPicRepository.saveAll(petPics);

            } catch (Exception e) {
                System.out.println("新增寵物圖片錯誤");
                return false;
            }
        }
        return true;

    }

    @Override
    public Boolean updatePet(InsertPetInfoVIn insertPetInfoVIn) {
        return null;
    }

    @Override
    public Boolean deletePet(Integer petId) {
        return null;
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
