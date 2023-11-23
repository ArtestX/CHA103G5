package com.cha103g5.petinfo.repository;


import com.cha103g5.petinfo.model.PetVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<PetVO, Integer> {

//    @Query("SELECT p FROM PetVO p LEFT JOIN FETCH p.petPics WHERE p.petId = :petId")
//    Optional<PetVO> getPetWithPicsById(@Param("petId") Integer petId);
}