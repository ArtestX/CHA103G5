package com.cha103g5.petinfo.repository;


import com.cha103g5.petinfo.model.PetInfoVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetInfoRepository extends JpaRepository<PetInfoVO, Integer> {

    @Query("SELECT p FROM PetInfoVO p LEFT JOIN FETCH p.petPics WHERE p.petId = :petId")
    Optional<PetInfoVO> getPetWithPicsById(@Param("petId") Integer petId);
}