package com.cha103g5.animaltype.model;

import javax.persistence.*;

@Entity
@Table(name = "animaltype")
public class AnimalType {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animaltypeno")
    private Integer animalTypeNo;

    @Column(name = "animaltypename")
    private String animalTypeName;

	public AnimalType() {
		super();
	}

	public AnimalType(Integer animalTypeNo, String animalTypeName) {
		super();
		this.animalTypeNo = animalTypeNo;
		this.animalTypeName = animalTypeName;
	}

	public Integer getAnimalTypeNo() {
		return animalTypeNo;
	}

	public void setAnimalTypeNo(Integer animalTypeNo) {
		this.animalTypeNo = animalTypeNo;
	}

	public String getAnimalTypeName() {
		return animalTypeName;
	}

	public void setAnimalTypeName(String animalTypeName) {
		this.animalTypeName = animalTypeName;
	}

}
