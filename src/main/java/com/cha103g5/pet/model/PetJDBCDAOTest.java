package com.cha103g5.pet.model;

import java.sql.Date;

public class PetJDBCDAOTest {
    public static void main(String[] args) {

        // 創建一個 PetVO 物件
        PetVO pet = new PetVO();
        pet.setPettype(1); // 設定寵物類型
        pet.setMemberid(2); // 設定會員編號
        pet.setPetname("Fluffy"); // 設定寵物名稱
        pet.setPetsex("Male"); // 設定寵物性別
        pet.setPetage(3); // 設定寵物年齡
        pet.setPetnote("A cute pet"); // 設定寵物備註
        pet.setStat((byte) 1); // 設定寵物狀態
        pet.setApplicationdeadline(new Date(System.currentTimeMillis())); // 設定申請截止日期

        // 測試 insert 方法
        PetJDBCDAO petDAO = new PetJDBCDAO();
        petDAO.insert(pet);
        System.out.println("Pet inserted with ID: " + pet.getPetid());

        // 測試 update 方法
        pet.setPetname("Fido"); // 修改寵物名稱
        petDAO.update(pet);
        System.out.println("Pet updated with ID: " + pet.getPetid());

        // 測試 delete 方法
        petDAO.delete(pet);
        System.out.println("Pet deleted with ID: " + pet.getPetid());
    }
}

