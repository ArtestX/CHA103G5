package com.cha103g5.animaltype.model;

public class TestCRUD {
    public static void main(String[] args) {
        AnimalTypeDao animalTypeDao = new AnimalTypeDaoImpl();

//        // 測試add方法
//        AnimalType addedAnimalType = animalTypeDao.add("豬");
//        System.out.println("==================");
//        System.out.println("Added AnimalType: " + addedAnimalType.getAnimalTypeName());
//        System.out.println("==================");
//
//        // 測試getByName方法
//        AnimalType gottenAnimalType = animalTypeDao.getByName("豬");
//        System.out.println("==================");
//        System.out.println("Gotten AnimalType: " + gottenAnimalType.getAnimalTypeName());
//        System.out.println("==================");
//
        // 測試update方法
        AnimalType updatedAnimalType = animalTypeDao.update("猴子", "豬");
        System.out.println("==================");
        System.out.println("Updated AnimalType: " + updatedAnimalType.getAnimalTypeName());
        System.out.println("==================");

//        // 測試getAll方法
//        List<AnimalType> allAnimalTypes = animalTypeDao.getAll();
//        System.out.println("All AnimalTypes:");
//        for (AnimalType animalType : allAnimalTypes) {
//            System.out.println(animalType.getAnimalTypeName());
//        }

//        // 測試delete方法
//        animalTypeDao.delete("豬");
//        System.out.println("==================");
//        System.out.println("Deleted AnimalType: ");
//        System.out.println("==================");

//        // 再次測試getAll方法，確認"猴子"已被刪除
//        allAnimalTypes = animalTypeDao.getAll();
//        System.out.println("All AnimalTypes after deletion:");
//        for (AnimalType animalType : allAnimalTypes) {
//            System.out.println(animalType.getAnimalTypeName());
//        }
    }
}
