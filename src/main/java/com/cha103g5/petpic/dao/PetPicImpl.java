package com.cha103g5.petpic.dao;

import com.cha103g5.petpic.model.PetPic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PetPicImpl implements PetPicDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void batchInsert(List<PetPic> petPicList) {


    }

    @Override
    public void deleteById(Integer picId) {

    }

    @Override
    public List<PetPic> getById(Integer petId) {
        String sql = "SELECT petpic FROM petpic WHERE petid = :petid";

        Map<String, Object> map = new HashMap<>();
        map.put("petid", petId);

        try {
            // 使用 query 方法，指定返回的類型為 List<byte[]>
            List<byte[]> petPicListBytes = namedParameterJdbcTemplate.query(sql, map, (resultSet, i) -> resultSet.getBytes("petpic"));

            // 創建 PetPic 對象的 List，設置 petPicListBytes
            List<PetPic> petPicList = new ArrayList<>();
            for (byte[] petPicBytes : petPicListBytes) {
                PetPic petPic = new PetPic();
                petPic.setPetPic(petPicBytes);
                petPicList.add(petPic);
            }

            return petPicList;
        } catch (EmptyResultDataAccessException e) {
            // 如果查詢結果為空，返回空的 List 或進行其他處理
            return Collections.emptyList();
        }
    }
}
