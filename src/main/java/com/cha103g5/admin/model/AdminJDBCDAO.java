package com.cha103g5.admin.model;


import com.cha103g5.admin.model.AdminDAO_interface;
import com.cha103g5.admin.model.AdminVO;
import com.cha103g5.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AdminJDBCDAO implements AdminDAO_interface {

    private static final String INSERT_STMT =
            "INSERT INTO admin (adminaccount,adminpassword,adminname,createddate,adminstat,adminemail,adminphone) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_ALL_STMT =
            "SELECT adminno,adminaccount,adminpassword,adminname,createddate,adminstat,adminemail,adminphone FROM admin order by adminno";
    private static final String GET_ONE_STMT =
            "SELECT adminno,adminaccount,adminpassword,adminname,createddate,adminstat,adminemail,adminphone FROM admin where adminno = ?";
    private static final String DELETE =
            "DELETE FROM admin where adminno = ?";
    private static final String UPDATE =
            "UPDATE admin set adminname=?, adminemail=?, adminphone=?, adminstat=? where adminno = ?";


//    static {
//        try {
//            Class.forName(Util.DRIVER);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException("Couldn't load database driver."
//                    + e.getMessage());
//        }
//    }
    @Override
    public void insert(AdminVO adminVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
//            con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
            con = Util.getConnection();
            pstmt = con.prepareStatement(INSERT_STMT);

            pstmt.setString(1, adminVO.getAdminAccount());
            pstmt.setString(2, adminVO.getAdminPassword());
            pstmt.setString(3, adminVO.getAdminName());
            pstmt.setDate(4, adminVO.getCreateDate());
            pstmt.setInt(5, adminVO.getAdminStat());
            pstmt.setString(6, adminVO.getAdminEmail());
            pstmt.setString(7, adminVO.getAdminPhone());

            pstmt.executeUpdate();

        } catch (SQLException se) {
            throw new RuntimeException("Database error occurred."
                    + se.getMessage());
        } finally {
            Util.closeResources(con, pstmt, null);
        }
    }

    @Override
    public void update(AdminVO adminVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
//            con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
            con = Util.getConnection();
            pstmt = con.prepareStatement(UPDATE);

            pstmt.setString(1, adminVO.getAdminName());
            pstmt.setString(2, adminVO.getAdminEmail());
            pstmt.setString(3, adminVO.getAdminPhone());
            pstmt.setInt(4, adminVO.getAdminStat());
            pstmt.setInt(5, adminVO.getAdminNo());

            pstmt.executeUpdate();

        } catch (SQLException se) {
            throw new RuntimeException("Database error occurred."
                    + se.getMessage());
        } finally {
            Util.closeResources(con, pstmt, null);
        }
    }


    @Override
    public void delete(Integer adminNo) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
//            con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
            con = Util.getConnection();
            pstmt = con.prepareStatement(DELETE);

            pstmt.setInt(1, adminNo);
            pstmt.executeUpdate();

        } catch (SQLException se) {
            throw new RuntimeException("Database error occurred."
                    + se.getMessage());
        } finally {
            Util.closeResources(con, pstmt, null);
        }
    }

    @Override
    public AdminVO findByPrimaryKey(Integer adminNo) {

        AdminVO adminVO = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
//            con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
            con = Util.getConnection();
            pstmt = con.prepareStatement(GET_ONE_STMT);

            pstmt.setInt(1, adminNo);
            rs = pstmt.executeQuery();

            while (rs.next()){
                adminVO = new AdminVO();
                adminVO.setAdminNo(rs.getInt("adminno"));
                adminVO.setAdminAccount(rs.getString("adminaccount"));
                adminVO.setAdminPassword(rs.getString("adminpassword"));
                adminVO.setAdminName(rs.getString("adminname"));
                adminVO.setCreateDate(rs.getDate("createddate"));
                adminVO.setAdminStat(rs.getInt("adminstat"));
                adminVO.setAdminEmail(rs.getString("adminemail"));
                adminVO.setAdminPhone(rs.getString("adminphone"));
            }

        } catch (SQLException se) {
            throw new RuntimeException("Database error occurred."
                    + se.getMessage());
        } finally {
            Util.closeResources(con, pstmt, rs);
        }
        return adminVO;
    }

    @Override
    public List<AdminVO> getAll() {
        List<AdminVO> list = new ArrayList<AdminVO>();
        AdminVO adminVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
//            con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
            con = Util.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()){
                adminVO = new AdminVO();
                adminVO.setAdminNo(rs.getInt("adminno"));
                adminVO.setAdminAccount(rs.getString("adminaccount"));
                adminVO.setAdminPassword(rs.getString("adminpassword"));
                adminVO.setAdminName(rs.getString("adminname"));
                adminVO.setCreateDate(rs.getDate("createddate"));
                adminVO.setAdminStat(rs.getInt("adminstat"));
                adminVO.setAdminEmail(rs.getString("adminemail"));
                adminVO.setAdminPhone(rs.getString("adminphone"));
                list.add(adminVO);
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
