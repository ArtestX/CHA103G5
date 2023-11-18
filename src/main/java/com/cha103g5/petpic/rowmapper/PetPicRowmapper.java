package com.cha103g5.petpic.rowmapper;

import com.cha103g5.petpic.model.PetPicVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PetPicRowmapper implements RowMapper<PetPicVO> {

    @Override
    public PetPicVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        PetPicVO petPic = new PetPicVO();
        petPic.setPicId(rs.getInt("picid"));
        petPic.setPetPic(rs.getBytes("petpic"));
        return petPic;

    }
}
