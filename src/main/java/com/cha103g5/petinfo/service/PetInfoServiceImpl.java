package com.cha103g5.petinfo.service;

import com.cha103g5.petinfo.dto.PetInfoDto;
import com.cha103g5.petinfo.model.PetVO;
import com.cha103g5.petinfo.model.PetPicVO;
import com.cha103g5.petinfo.repository.PetPicRepository;
import com.cha103g5.petinfo.repository.PetRepository;
import com.cha103g5.petinfo.vin.InsertPetInfoVIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PetInfoServiceImpl implements PetInfoService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetPicRepository petPicRepository;

    @Override
    public PetInfoDto getPetById(Integer petId) {
        PetInfoDto petInfoDto = new PetInfoDto();
        PetVO petVO = petRepository.getPetWithPicsById(petId).orElse(null);
        List<PetPicVO> petPicVO = petPicRepository.findByPetId(petId);
        petInfoDto.setPetId(petVO.getPetId());
        petInfoDto.setAnimalTypeNo(petVO.getAnimalTypeNo());
        petInfoDto.setMemberNo(petVO.getMemberNo());
        petInfoDto.setPetName(petVO.getPetName());
        petInfoDto.setPetSex(petVO.getPetSex());
        petInfoDto.setPetAge(petVO.getPetAge());
        petInfoDto.setPetNote(petVO.getPetNote());
        petInfoDto.setStat(petVO.getStat());
        petInfoDto.setApplicationDeadLine(petVO.getApplicationDeadLine());

        StringBuilder stringBuilder = new StringBuilder();

        // 將List中的每個元素拼接到StringBuilder中
        for (PetPicVO petPicVO1 : petPicVO) {
            stringBuilder.append(petPicVO1);
        }

        // 將StringBuilder轉換為byte陣列
        byte[] petPic =stringBuilder.toString().getBytes(StandardCharsets.UTF_8);
        petInfoDto.setPetPic(petPic);
        return  petInfoDto;
    }

    @Override
    public List<PetVO> getAllPetsWithPictures() {
        try {
            // 使用 Java 8 Stream API 來簡化邏輯
            return petRepository.findAll().stream()
                    .peek(this::attachPetPictures)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("獲取所有寵物信息錯誤: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    private void attachPetPictures(PetVO pet) {
        // 為每個 PetVO 對象附加圖片信息
        List<PetPicVO> petPics = petPicRepository.findByPetId(pet.getPetId())
                .stream()
                .peek(this::convertPictureToBase64) // 新增的 Base64 轉換邏輯
                .collect(Collectors.toList());
        pet.setPetPics(petPics);
    }

    private void convertPictureToBase64(PetPicVO petPic) {
        try {
            if (petPic.getPetPic() != null) {
                String base64Image = Base64.getEncoder().encodeToString(petPic.getPetPic());
                petPic.setBase64Image(base64Image);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Base64编码异常: " + e.getMessage());
            // 处理异常，可以记录日志或采取其他适当的操作
        }
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

    public Boolean updatePet(InsertPetInfoVIn insertPetInfoVIn) {
        // 儲存寵物資訊
        try {
            Optional<PetVO> optionalPetVO = petRepository.findById(insertPetInfoVIn.getPetId());

            if (optionalPetVO.isPresent()) {
                PetVO petVO = optionalPetVO.get();

                petVO.setAnimalTypeNo(insertPetInfoVIn.getAnimalTypeNo());
                petVO.setMemberNo(insertPetInfoVIn.getMemberNo());
                petVO.setPetName(insertPetInfoVIn.getPetName());
                petVO.setPetSex(insertPetInfoVIn.getPetSex());
                petVO.setPetAge(insertPetInfoVIn.getPetAge());
                petVO.setPetNote(insertPetInfoVIn.getPetNote());
                petVO.setStat(insertPetInfoVIn.getStat());
                petVO.setApplicationDeadLine(insertPetInfoVIn.getApplicationDeadLine());

                petRepository.save(petVO);

                if (insertPetInfoVIn.getPetPic() != null && insertPetInfoVIn.getPetPic().length != 0) {
                    // 儲存寵物圖片
                    try {
                        List<PetPicVO> petPics = new ArrayList<>();

                        for (String base64String : insertPetInfoVIn.getPetPic()) {
                            // 移除 data URL 開頭部分，只保留 base64 部分
                            String base64Data = base64String.replaceFirst("data:image/.*;base64,", "");

                            // 解碼 base64 字串為 byte[]
                            byte[] imageData = Base64.getDecoder().decode(base64Data);

                            // 創建 PetPicVO 對象，設定相應的屬性
                            PetPicVO petPicVO = new PetPicVO();
                            petPicVO.setPetId(petVO.getPetId());
                            petPicVO.setPetPic(imageData);

                            // 將 PetPicVO 添加到列表中
                            petPics.add(petPicVO);
                        }
                        // 一次性的新增
                        petPicRepository.saveAll(petPics);

                    } catch (Exception e) {
                        System.out.println("新增寵物圖片錯誤");
                        return false;
                    }
                }

                return true;
            } else {
                System.out.println("找不到寵物資訊，無法更新");
                return false;
            }
        } catch (Exception e) {
            System.out.println("更新寵物資訊錯誤");
            return false;
        }
    }
    @Override
    public Boolean deletePet(Integer petId) {
        try {
            Optional<PetVO> optionalPetVO = petRepository.findById(petId);

            if (optionalPetVO.isPresent()) {
                PetVO petVO = optionalPetVO.get();

                // 先刪除 petpic 表中相應的行
                List<PetPicVO> petPics = petPicRepository.findByPetId(petId);
                petPicRepository.deleteAll(petPics);

                // 再刪除 pet 表中的行
                petRepository.delete(petVO);

                return true;
            } else {
                System.out.println("找不到寵物資訊，無法刪除");
                return false;
            }
        } catch (Exception e) {
            System.out.println("刪除寵物資訊錯誤");
            return false;
        }
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
