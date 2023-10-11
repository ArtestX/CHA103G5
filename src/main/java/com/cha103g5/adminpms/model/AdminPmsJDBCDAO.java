package com.cha103g5.adminpms.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AdminPmsJDBCDAO implements AdminPmsDAO_interface {

    private static final String INSERT_STMT =
            "INSERT INTO admin_permission (admin_pms_no, permissions_no, admin_no) VALUES (?, ?, ?)";
    private static final String GET_ALL_STMT =
            "SELECT admin_pms_no, permissions_no, admin_no FROM admin_permission order by admin_pms_no";
    private static final String GET_ONE_STMT =
            "SELECT admin_pms_no, permissions_no, admin_no FROM admin_permission where admin_pms_no = ?";

    static {
        try {
            Class.forName(Util.DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver."
                    + e.getMessage());
        }
    }
    @Override
    public void insert(AdminPmsVO adminPmsVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DriverManager.getConnection(com.cha103g5.csrec.model.Util.URL, com.cha103g5.csrec.model.Util.USER, com.cha103g5.csrec.model.Util.PASSWORD);
            pstmt = con.prepareStatement(INSERT_STMT);

            pstmt.setInt(1, adminPmsVO.getAdminPmsNo());
            pstmt.setInt(2, adminPmsVO.getPmsNo());
            pstmt.setInt(3, adminPmsVO.getAdminNo());


            pstmt.executeUpdate();

        } catch (SQLException se) {
            throw new RuntimeException("Database error occurred."
                    + se.getMessage());
        } finally {
            com.cha103g5.csrec.model.Util.closeResources(con, pstmt, null);
        }
    }

    @Override
    public AdminPmsVO findByPrimaryKey(Integer adminPmsNO) {

        AdminPmsVO adminPmsVO = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
            pstmt = con.prepareStatement(GET_ONE_STMT);

            pstmt.setInt(1, adminPmsNO);
            rs = pstmt.executeQuery();

            while (rs.next()){
                adminPmsVO = new AdminPmsVO();
                adminPmsVO.setAdminPmsNo(rs.getInt("admin_pms_no"));
                adminPmsVO.setPmsNo(rs.getInt("permissions_no"));
                adminPmsVO.setAdminNo(rs.getInt("admin_no"));
            }

        } catch (SQLException se) {
            throw new RuntimeException("Database error occurred."
                    + se.getMessage());
        } finally {
           Util.closeResources(con, pstmt, rs);
        }
        return adminPmsVO;
    }

    @Override
    public List<AdminPmsVO> getAll() {
        List<AdminPmsVO> list = new ArrayList<AdminPmsVO>();
        AdminPmsVO adminPmsVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection(com.cha103g5.csrec.model.Util.URL, com.cha103g5.csrec.model.Util.USER, com.cha103g5.csrec.model.Util.PASSWORD);
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()){
                adminPmsVO = new AdminPmsVO();
                adminPmsVO.setAdminPmsNo(rs.getInt("admin_pms_no"));
                adminPmsVO.setPmsNo(rs.getInt("permissions_no"));
                adminPmsVO.setAdminNo(rs.getInt("admin_no"));
                list.add(adminPmsVO);
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
