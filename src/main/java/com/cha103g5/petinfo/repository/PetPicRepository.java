package com.cha103g5.petinfo.repository;

import com.cha103g5.petinfo.model.PetPicVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetPicRepository extends JpaRepository<PetPicVO, Integer> {
}
