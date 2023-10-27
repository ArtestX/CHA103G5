package com.cha103g5.adoptedapplication.rowmapper;

import com.cha103g5.adoptedapplication.model.AdoptedApplication;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdoptedApplicationRowMapper implements RowMapper<AdoptedApplication> {

    @Override
    public AdoptedApplication mapRow(ResultSet rs, int rowNum) throws SQLException {
        AdoptedApplication adoptedApplication = new AdoptedApplication();
        adoptedApplication.setApplicationNo(rs.getInt("applicationno"));
        adoptedApplication.setAdminNo(rs.getInt("adminno"));
        adoptedApplication.setMemberNo(rs.getInt("memberno"));
        adoptedApplication.setPetId(rs.getInt("petid"));
        adoptedApplication.setInteractionDate(rs.getDate("interactiondate"));
        adoptedApplication.setLotteryResult(rs.getInt("lotteryresult"));
        adoptedApplication.setLotteryDate(rs.getDate("lotterydate"));
        adoptedApplication.setApplicationStat(rs.getInt("applicationstat"));
        adoptedApplication.setApplicantNotes(rs.getString("applicantnotes"));
        adoptedApplication.setAgreement(rs.getString("agreement"));
        adoptedApplication.setApplicationDate(rs.getDate("applicationdate"));
        return adoptedApplication;
    }
}
