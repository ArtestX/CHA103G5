package com.cha103g5.pmsfunc.model;

import com.cha103g5.csrec.model.Util;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PmsFuncJDBCDAO implements PmsFuncDAO_interface {

    private static final String INSERT_STMT =
            "INSERT INTO permission (permissions_no, permissions_name, permissions_des) VALUES (?, ?, ?)";
    private static final String GET_ALL_STMT =
            "SELECT permissions_no, permissions_name, permissions_des FROM permission order by permissions_no";
    private static final String GET_ONE_STMT =
            "SELECT permissions_no, permissions_name, permissions_des FROM permission where permissions_no = ?";
    private static final String DELETE =
            "DELETE FROM permission where permissions_no = ?";
    private static final String UPDATE =
            "UPDATE permission set permissions_name=?, permissions_des=? where permissions_no = ?";

    static {
        try {
            Class.forName(Util.DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver."
                    + e.getMessage());
        }
    }
    @Override
    public void insert(PmsFuncVO pmsFuncVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
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
            con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
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
            con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
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
            con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
            pstmt = con.prepareStatement(GET_ONE_STMT);

            pstmt.setInt(1, pmsNo);
            rs = pstmt.executeQuery();

            while (rs.next()){
                pmsFuncVO = new PmsFuncVO();
                pmsFuncVO.setPmsNo(rs.getInt("permissions_no"));
                pmsFuncVO.setPmsName(rs.getString("permissions_name"));
                pmsFuncVO.setPmsDes(rs.getString("permissions_des"));

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
            con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()){
                pmsFuncVO = new PmsFuncVO();
                pmsFuncVO.setPmsNo(rs.getInt("permissions_no"));
                pmsFuncVO.setPmsName(rs.getString("permissions_name"));
                pmsFuncVO.setPmsDes(rs.getString("permissions_des"));
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
