package com.cha103g5.petinfo.repository;

import com.cha103g5.petinfo.model.PetPicVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetPicRepository extends JpaRepository<PetPicVO, Integer> {

    // 在 PetPicRepository 中添加自訂的查詢方法
    List<PetPicVO> findByPetId(Integer petId);

}
