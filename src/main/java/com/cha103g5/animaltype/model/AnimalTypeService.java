package com.cha103g5.animaltype.model;

import java.util.List;

public class AnimalTypeService {

	private AnimalTypeDao dao;

    public AnimalTypeService() {
        dao = new AnimalTypeDaoImpl();
    }

    public AnimalType add(String animalTypeName) {
        return dao.add(animalTypeName);
    }

    public AnimalType update(String newAnimalTypeName, String oldAnimalTypeName) {
    	return dao.update(newAnimalTypeName, oldAnimalTypeName);
    }

    public void delete(String animalTypeName) {
        dao.delete(animalTypeName);
    }

    public AnimalType getByName(String animalTypeName) {
        return dao.getByName(animalTypeName);
    }

    public List<AnimalType> getAll() {
        return dao.getAll();
    }

}
