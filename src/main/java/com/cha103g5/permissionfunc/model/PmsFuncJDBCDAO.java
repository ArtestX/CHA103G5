package com.cha103g5.permissionfunc.model;


import com.cha103g5.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PmsFuncJDBCDAO implements PmsFuncDAOInterface {

    private static final String INSERT_STMT =
            "INSERT INTO permissionfunc (permissionsno, permissionsname, permissionsdes) VALUES (?, ?, ?)";
    private static final String GET_ALL_STMT =
            "SELECT permissionsno, permissionsname, permissionsdes FROM permissionfunc order by permissionsno";
    private static final String GET_ONE_STMT =
            "SELECT permissionsno, permissionsname, permissionsdes FROM permissionfunc where permissionsno = ?";
    private static final String DELETE =
            "DELETE FROM permissionfunc where permissionsno = ?";
    private static final String UPDATE =
            "UPDATE permissionfunc set permissionsname=?, permissionsdes=? where permissionsno = ?";


    @Override
    public void insert(PmsFuncVO pmsFuncVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = Util.getConnection();
            pstmt = con.prepareStatement(INSERT_STMT);

            pstmt.setInt(1, pmsFuncVO.getPmsNo());
            pstmt.setString(2, pmsFuncVO.getPmsName());
            pstmt.setString(3, pmsFuncVO.getPmsDes());

            pstmt.executeUpdate();

        } catch (SQLException se) {
            throw new RuntimeException("Database error occurred."
                    + se.getMessage());
        } finally {
            Util.closeResources(con, pstmt, null);
        }
    }

    @Override
    public void update(PmsFuncVO pmsFuncVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = Util.getConnection();
            pstmt = con.prepareStatement(UPDATE);

            pstmt.setString(1, pmsFuncVO.getPmsName());
            pstmt.setString(2, pmsFuncVO.getPmsDes());
            pstmt.setInt(3, pmsFuncVO.getPmsNo());

            pstmt.executeUpdate();

        } catch (SQLException se) {
            throw new RuntimeException("Database error occurred."
                    + se.getMessage());
        } finally {
            Util.closeResources(con, pstmt, null);
        }
    }


    @Override
    public void delete(Integer pmsNo) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = Util.getConnection();
            pstmt = con.prepareStatement(DELETE);

            pstmt.setInt(1, pmsNo);
            pstmt.executeUpdate();

        } catch (SQLException se) {
            throw new RuntimeException("Database error occurred."
                    + se.getMessage());
        } finally {
            Util.closeResources(con, pstmt, null);
        }
    }

    @Override
    public PmsFuncVO findByPrimaryKey(Integer pmsNo) {

        PmsFuncVO pmsFuncVO = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = Util.getConnection();
            pstmt = con.prepareStatement(GET_ONE_STMT);

            pstmt.setInt(1, pmsNo);
            rs = pstmt.executeQuery();

            while (rs.next()){
                pmsFuncVO = new PmsFuncVO();
                pmsFuncVO.setPmsNo(rs.getInt("permissionsno"));
                pmsFuncVO.setPmsName(rs.getString("permissionsname"));
                pmsFuncVO.setPmsDes(rs.getString("permissionsdes"));

            }

        } catch (SQLException se) {
            throw new RuntimeException("Database error occurred."
                    + se.getMessage());
        } finally {
            Util.closeResources(con, pstmt, rs);
        }
        return pmsFuncVO;
    }

    @Override
    public List<PmsFuncVO> getAll() {
        List<PmsFuncVO> list = new ArrayList<PmsFuncVO>();
        PmsFuncVO pmsFuncVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = Util.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()){
                pmsFuncVO = new PmsFuncVO();
                pmsFuncVO.setPmsNo(rs.getInt("permissionsno"));
                pmsFuncVO.setPmsName(rs.getString("permissionsname"));
                pmsFuncVO.setPmsDes(rs.getString("permissionsdes"));
                list.add(pmsFuncVO);
            }

        } catch (SQLException se) {
            throw new RuntimeException("Database error occurred."
                    + se.getMessage());
        } finally {
            Util.closeResources(con, pstmt, rs);
        }
        return list;

    }
}
