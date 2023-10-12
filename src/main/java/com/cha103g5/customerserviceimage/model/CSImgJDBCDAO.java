package com.cha103g5.customerserviceimage.model;

import com.cha103g5.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CSImgJDBCDAO implements CSImgDAOInterface {

    private static final String INSERT_STMT =
            "INSERT INTO customerserviceimage (pictureno, recordno, picture) VALUES (?, ?, ?)";
    private static final String GET_ALL_STMT =
            "SELECT pictureno, recordno, picture FROM customerserviceimage order by pictureno";
    private static final String GET_ONE_STMT =
            "SELECT pictureno, recordno, picture FROM customerserviceimage where pictureno = ?";


    @Override
    public void insert(CSImgVO CSImgVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = Util.getConnection();
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
            con = Util.getConnection();
            pstmt = con.prepareStatement(GET_ONE_STMT);

            pstmt.setInt(1, pictureNo);
            rs = pstmt.executeQuery();

            while (rs.next()){
                csImgVO = new CSImgVO();
                csImgVO.setPictureNo(rs.getInt("pictureno"));
                csImgVO.setRecordNo(rs.getInt("recordno"));
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
            con = Util.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()){
                csImgVO = new CSImgVO();
                csImgVO.setPictureNo(rs.getInt("pictureno"));
                csImgVO.setRecordNo(rs.getInt("recordno"));
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
