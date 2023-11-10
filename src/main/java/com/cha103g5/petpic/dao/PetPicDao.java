package com.cha103g5.petpic.dao;

import com.cha103g5.petpic.model.PetPic;

import java.util.List;

public interface PetPicDao {

    //批次新增寵物照片
    void batchInsert(List<PetPic> petPicList);

    //刪除寵物照片
    void deleteById(Integer picId);

    //查詢寵物照片
    List<PetPic> getById(Integer petId);
}
