package com.cha103g5.adminpms.model;

import com.cha103g5.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AdminPmsJDBCDAO implements AdminPmsDAO_interface {

    private static final String INSERT_STMT =
            "INSERT INTO adminpermission (adminpmsno, permissionsno, adminno) VALUES (?, ?, ?)";
    private static final String GET_ALL_STMT =
            "SELECT adminpmsno, permissionsno, adminno FROM adminpermission order by adminpmsno";
    private static final String GET_ONE_STMT =
            "SELECT adminpmsno, permissionsno, adminno FROM adminpermission where adminpmsno = ?";


    @Override
    public void insert(AdminPmsVO adminPmsVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = Util.getConnection();
            pstmt = con.prepareStatement(INSERT_STMT);

            pstmt.setInt(1, adminPmsVO.getAdminPmsNo());
            pstmt.setInt(2, adminPmsVO.getPmsNo());
            pstmt.setInt(3, adminPmsVO.getAdminNo());


            pstmt.executeUpdate();

        } catch (SQLException se) {
            throw new RuntimeException("Database error occurred."
                    + se.getMessage());
        } finally {
            Util.closeResources(con, pstmt, null);
        }
    }

    @Override
    public AdminPmsVO findByPrimaryKey(Integer adminPmsNO) {

        AdminPmsVO adminPmsVO = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = Util.getConnection();
            pstmt = con.prepareStatement(GET_ONE_STMT);

            pstmt.setInt(1, adminPmsNO);
            rs = pstmt.executeQuery();

            while (rs.next()){
                adminPmsVO = new AdminPmsVO();
                adminPmsVO.setAdminPmsNo(rs.getInt("adminpmsno"));
                adminPmsVO.setPmsNo(rs.getInt("permissionsno"));
                adminPmsVO.setAdminNo(rs.getInt("adminno"));
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
            con = Util.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()){
                adminPmsVO = new AdminPmsVO();
                adminPmsVO.setAdminPmsNo(rs.getInt("adminpmsno"));
                adminPmsVO.setPmsNo(rs.getInt("permissionsno"));
                adminPmsVO.setAdminNo(rs.getInt("adminno"));
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
