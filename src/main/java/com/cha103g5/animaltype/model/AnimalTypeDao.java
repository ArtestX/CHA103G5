package com.cha103g5.animaltype.model;

import java.util.List;

public interface AnimalTypeDao {

	public AnimalType add(String animalTypeName);
    public AnimalType update(String newAnimalTypeName, String oldAnimalTypeName);
    public void delete(String animalTypeName);

    public AnimalType getByName(String animalTypeName);
    public List<AnimalType> getAll();

}
