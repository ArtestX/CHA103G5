package com.cha103g5.adoptedapplication.dao;

import com.cha103g5.adoptedapplication.dto.AdoptedApplicationQueryParams;
import com.cha103g5.adoptedapplication.dto.AdoptedApplicationRequest;
import com.cha103g5.adoptedapplication.model.AdoptedApplication;
import com.cha103g5.adoptedapplication.rowmapper.AdoptedApplicationRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AdoptedApplicationDaoImpl implements AdoptedApplicationDao{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer countAdoptedApplication(AdoptedApplicationQueryParams adoptedApplicationQueryParams) {
        String sql = "SELECT count(*) FROM adoptedapplication WHERE 1=1 ";

        Map<String, Object> map = new HashMap<>();

        // 查詢條件
        sql = addFilteringSql(sql, map, adoptedApplicationQueryParams);

        Integer total = namedParameterJdbcTemplate.queryForObject(sql, map, Integer.class);

        return total;
    }

    @Override
    public List<AdoptedApplication> getAll(AdoptedApplicationQueryParams adoptedApplicationQueryParams) {
        String sql = "SELECT applicationno, adminno, memberno, petid, " +
                "interactiondate, lotteryresult, lotterydate, applicationstat, " +
                "applicantnotes, agreement, applicationdate " +
                "FROM adoptedapplication WHERE 1=1 ";

        Map<String, Object> map = new HashMap<>();

        // 查詢條件
        sql = addFilteringSql(sql, map, adoptedApplicationQueryParams);

        // 排序
        String[] orderFields = adoptedApplicationQueryParams.getOrderBy().split(",");
        String[] sortDirections = adoptedApplicationQueryParams.getSort().split(",");
        StringBuilder orderClause = new StringBuilder("ORDER BY ");
        for (int i = 0; i < orderFields.length; i++) {
            orderClause.append(orderFields[i] + " " + sortDirections[i]);
            if (i < orderFields.length - 1) {
                orderClause.append(", ");
            }
        }
        sql = sql + orderClause.toString();

        // 分頁
        sql = sql + " LIMIT :limit OFFSET :offset";
        map.put("limit", adoptedApplicationQueryParams.getLimit());
        map.put("offset", adoptedApplicationQueryParams.getOffset());

        List<AdoptedApplication> adoptedApplicationList = namedParameterJdbcTemplate.query(
                sql,
                map,
                new AdoptedApplicationRowMapper()
        );

        return adoptedApplicationList;
    }

//    @Override
//    public List<AdoptedApplication> getByPetIdAndLotteryDate(Integer petId, Date lotteryDate) {
//        String sql = "SELECT applicationno, adminno, memberno, petid, " +
//                "interactiondate, lotteryresult, lotterydate, applicationstat, " +
//                "applicantnotes, agreement, applicationdate " +
//                "FROM adoptedapplication WHERE petid = :petId AND lotterydate = :lotteryDate";
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("petId", petId);
//        map.put("lotteryDate", lotteryDate);
//
//        List<AdoptedApplication> adoptedApplicationList = namedParameterJdbcTemplate.query(
//                sql,
//                map,
//                new AdoptedApplicationRowMapper()
//        );
//
//        if (adoptedApplicationList.size() > 0) {
//            return adoptedApplicationList;
//        } else {
//            return null;
//        }
//    }

    @Override
    public AdoptedApplication getById(Integer applicationNo) {
        String sql = "SELECT applicationno, adminno, memberno, petid, " +
                "interactiondate, lotteryresult, lotterydate, applicationstat, " +
                "applicantnotes, agreement, applicationdate " +
                "FROM adoptedapplication WHERE applicationno = :applicationNo";

        Map<String, Object> map = new HashMap<>();
        map.put("applicationNo", applicationNo);

        List<AdoptedApplication> adoptedApplicationList = namedParameterJdbcTemplate.query(
                sql,
                map,
                new AdoptedApplicationRowMapper()
        );

        if (adoptedApplicationList.size() > 0) {
            return adoptedApplicationList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Integer createAdoptedApplication(AdoptedApplicationRequest adoptedApplicationRequest) {
        String sql = "INSERT INTO adoptedapplication(adminno, memberno, petid, interactiondate, " +
                "lotteryresult, lotterydate, applicationstat, applicantnotes, agreement, applicationdate) " +
                "VALUES (:adminNo, :memberNo, :petId, :interactionDate, " +
                ":lotteryResult, :lotteryDate, :applicationStat, :applicantNotes, :agreement, :applicationDate)";

        Map<String, Object> map = new HashMap<>();
        map.put("adminNo", adoptedApplicationRequest.getAdminNo());
        map.put("memberNo", adoptedApplicationRequest.getMemberNo());
        map.put("petId", adoptedApplicationRequest.getPetId());
        map.put("interactionDate", adoptedApplicationRequest.getInteractionDate());
        map.put("lotteryResult", adoptedApplicationRequest.getLotteryResult());
        map.put("lotteryDate", adoptedApplicationRequest.getLotteryDate());
        map.put("applicationStat", adoptedApplicationRequest.getApplicationStat());
        map.put("applicantNotes", adoptedApplicationRequest.getApplicantNotes());
        map.put("agreement", adoptedApplicationRequest.getAgreement());
        map.put("applicationDate", adoptedApplicationRequest.getApplicationDate());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int applicationNo = keyHolder.getKey().intValue();

        return applicationNo;
    }

    @Override
    public void updateAdoptedApplication(Integer applicationNo, AdoptedApplicationRequest adoptedApplicationRequest) {
        String sql = "UPDATE adoptedapplication SET " +
                "adminno = :adminNo, " +
                "memberno = :memberNo, " +
                "petid = :petId, " +
                "interactiondate = :interactionDate, " +
                "lotteryresult = :lotteryResult, " +
                "lotterydate = :lotteryDate, " +
                "applicationstat = :applicationStat, " +
                "applicantnotes = :applicantNotes, " +
                "agreement = :agreement, " +
                "applicationdate = :applicationDate " +
                "WHERE applicationno = :applicationNo";

        Map<String, Object> map = new HashMap<>();
        map.put("applicationNo", applicationNo);

        map.put("adminNo", adoptedApplicationRequest.getAdminNo());
        map.put("memberNo", adoptedApplicationRequest.getMemberNo());
        map.put("petId", adoptedApplicationRequest.getPetId());
        map.put("interactionDate", adoptedApplicationRequest.getInteractionDate());
        map.put("lotteryResult", adoptedApplicationRequest.getLotteryResult());
        map.put("lotteryDate", adoptedApplicationRequest.getLotteryDate());
        map.put("applicationStat", adoptedApplicationRequest.getApplicationStat());
        map.put("applicantNotes", adoptedApplicationRequest.getApplicantNotes());
        map.put("agreement", adoptedApplicationRequest.getAgreement());
        map.put("applicationDate", adoptedApplicationRequest.getApplicationDate());

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void deleteAdoptedApplication(Integer applicationNo) {
        String sql = "DELETE FROM adoptedapplication WHERE applicationno = :applicationNo";

        Map<String, Object> map = new HashMap<>();
        map.put("applicationNo", applicationNo);

        namedParameterJdbcTemplate.update(sql, map);
    }

    private String addFilteringSql(String sql, Map<String, Object> map, AdoptedApplicationQueryParams adoptedApplicationQueryParams) {
        if (adoptedApplicationQueryParams.getPetId() != null) {
            sql = sql + "AND petid = :petId ";
            map.put("petId", adoptedApplicationQueryParams.getPetId());
        }
        if (adoptedApplicationQueryParams.getLotteryDate() != null) {
            sql = sql + "AND lotterydate = :lotteryDate ";
            map.put("lotteryDate", adoptedApplicationQueryParams.getLotteryDate());
        }

        return sql;
    }
}
