package com.cha103g5.admin.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AdminJDBCDAO implements AdminDAO_interface {

    private static final String INSERT_STMT =
            "INSERT INTO admin (admin_account,admin_password,admin_name,created_date,admin_stat,admin_email,admin_phone) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_ALL_STMT =
            "SELECT admin_no,admin_account,admin_password,admin_name,created_date,admin_stat,admin_email,admin_phone FROM admin order by admin_no";
    private static final String GET_ONE_STMT =
            "SELECT admin_no,admin_account,admin_password,admin_name,created_date,admin_stat,admin_email,admin_phone FROM admin where admin_no = ?";
    private static final String DELETE =
            "DELETE FROM admin where admin_no = ?";
    private static final String UPDATE =
            "UPDATE admin set admin_name=?, admin_email=?, admin_phone=?, admin_stat=? where admin_no = ?";

    static {
        try {
            Class.forName(Util.DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver."
                    + e.getMessage());
        }
    }
    @Override
    public void insert(AdminVO adminVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
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
            con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
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
            con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
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
            con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
            pstmt = con.prepareStatement(GET_ONE_STMT);

            pstmt.setInt(1, adminNo);
            rs = pstmt.executeQuery();

            while (rs.next()){
                adminVO = new AdminVO();
                adminVO.setAdminNo(rs.getInt("admin_no"));
                adminVO.setAdminAccount(rs.getString("admin_account"));
                adminVO.setAdminPassword(rs.getString("admin_password"));
                adminVO.setAdminName(rs.getString("admin_name"));
                adminVO.setCreateDate(rs.getDate("created_date"));
                adminVO.setAdminStat(rs.getInt("admin_stat"));
                adminVO.setAdminEmail(rs.getString("admin_email"));
                adminVO.setAdminPhone(rs.getString("admin_phone"));
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
            con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()){
                adminVO = new AdminVO();
                adminVO.setAdminNo(rs.getInt("admin_no"));
                adminVO.setAdminAccount(rs.getString("admin_account"));
                adminVO.setAdminPassword(rs.getString("admin_password"));
                adminVO.setAdminName(rs.getString("admin_name"));
                adminVO.setCreateDate(rs.getDate("created_date"));
                adminVO.setAdminStat(rs.getInt("admin_stat"));
                adminVO.setAdminEmail(rs.getString("admin_email"));
                adminVO.setAdminPhone(rs.getString("admin_phone"));
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
