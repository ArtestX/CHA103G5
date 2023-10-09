package com.cha103g5.csimg.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CSImgJDBCDAO implements CSImgDAO_interface {

    private static final String INSERT_STMT =
            "INSERT INTO customer_service_image (picture_no, record_no, picture) VALUES (?, ?, ?)";
    private static final String GET_ALL_STMT =
            "SELECT picture_no, record_no, picture FROM customer_service_image order by picture_no";
    private static final String GET_ONE_STMT =
            "SELECT picture_no, record_no, picture FROM customer_service_image where picture_no = ?";


    static {
        try {
            Class.forName(Util.DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver."
                    + e.getMessage());
        }
    }
    @Override
    public void insert(CSImgVO CSImgVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
            pstmt = con.prepareStatement(INSERT_STMT);


            pstmt.setInt(1, CSImgVO.getPictureNo());
            pstmt.setInt(2, CSImgVO.getRecordNo());
            pstmt.setBytes(3, CSImgVO.getPicture());


            pstmt.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("Database error occurred."
                    + se.getMessage());
        } finally {
            Util.closeResources(con, pstmt, null);
        }
    }


    @Override
    public CSImgVO findByPrimaryKey(Integer pictureNo) {

        CSImgVO csImgVO = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
            pstmt = con.prepareStatement(GET_ONE_STMT);

            pstmt.setInt(1, pictureNo);
            rs = pstmt.executeQuery();

            while (rs.next()){
                csImgVO = new CSImgVO();
                csImgVO.setPictureNo(rs.getInt("picture_no"));
                csImgVO.setRecordNo(rs.getInt("record_no"));
                csImgVO.setPicture(rs.getBytes("picture"));
            }

        } catch (SQLException se) {
            throw new RuntimeException("Database error occurred."
                    + se.getMessage());
        } finally {
            Util.closeResources(con, pstmt, rs);
        }
        return csImgVO;
    }

    @Override
    public List<CSImgVO> getAll() {
        List<CSImgVO> list = new ArrayList<CSImgVO>();
        CSImgVO csImgVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()){
                csImgVO = new CSImgVO();
                csImgVO.setPictureNo(rs.getInt("picture_no"));
                csImgVO.setRecordNo(rs.getInt("record_no"));
                csImgVO.setPicture(rs.getBytes("picture"));
                list.add(csImgVO);
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
