package com.cha103g5.petpic.dao;

import com.cha103g5.petpic.model.PetInFo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetInFoRepository extends JpaRepository<PetInFo, Integer> {
}
