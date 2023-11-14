package com.cha103g5.petpic.rowmapper;

import com.cha103g5.petpic.model.PetPic;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PetPicRowmapper implements RowMapper<PetPic> {

    @Override
    public PetPic mapRow(ResultSet rs, int rowNum) throws SQLException {
        PetPic petPic = new PetPic();
        petPic.setPicId(rs.getInt("picid"));
        petPic.setPetId(rs.getInt("petid"));
        petPic.setPetPic(rs.getBytes("petpic"));
        return petPic;

    }
}
