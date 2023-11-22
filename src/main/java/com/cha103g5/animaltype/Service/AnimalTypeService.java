package com.cha103g5.animaltype.Service;

import com.cha103g5.animaltype.hibernate.util.CompositeQuery.HibernateUtilCompositeQueryAnimalType;
import com.cha103g5.animaltype.model.AnimalType;
import com.cha103g5.animaltype.repository.AnimalTypeRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AnimalTypeService {

    @Autowired
    private AnimalTypeRepository animalTypeRepository;

    @Autowired
    private SessionFactory sessionFactory;

    public void addAnimalType(AnimalType animalType) {
        animalTypeRepository.save(animalType);
    }

    public void updateAnimalType(AnimalType animalType) {
        animalTypeRepository.save(animalType);
    }

    public void deleteAnimalType(Integer animalTypeNo) {
        if (animalTypeRepository.existsById(animalTypeNo))
            animalTypeRepository.deleteById(animalTypeNo);
    }

    public AnimalType getOneAnimalType(Integer animalTypeNo) {
        Optional<AnimalType> optional = animalTypeRepository.findById(animalTypeNo);
        return optional.orElse(null);
    }

    public List<AnimalType> getAll() {
        return animalTypeRepository.findAll();
    }

    public List<AnimalType> getAll(Map<String, String[]> map) {
        return HibernateUtilCompositeQueryAnimalType.getAllC(map, sessionFactory.openSession());
    }

}
