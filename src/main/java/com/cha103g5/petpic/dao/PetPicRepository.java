package com.cha103g5.petpic.dao;

import com.cha103g5.petpic.model.PetPic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetPicRepository extends JpaRepository<PetPic, Integer> {

}

