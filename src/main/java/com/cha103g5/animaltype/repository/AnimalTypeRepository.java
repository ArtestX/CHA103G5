package com.cha103g5.animaltype.repository;

import com.cha103g5.animaltype.model.AnimalType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalTypeRepository extends JpaRepository<AnimalType, Integer> {

}
