package com.cha103g5.petpic.dao;

import com.cha103g5.petpic.model.PetPicVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetPicRepository extends JpaRepository<PetPicVO, Integer> {

}

