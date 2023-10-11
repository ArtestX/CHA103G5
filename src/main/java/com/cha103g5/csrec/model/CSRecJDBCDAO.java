package com.cha103g5.csrec.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CSRecJDBCDAO implements CSRecDAO_interface {

    private static final String INSERT_STMT =
            "INSERT INTO customer_service_record (record_no,member_no,admin_no,record_time,interaction_content,attachments,Talk_direction) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_ALL_STMT =
            "SELECT record_no,member_no,admin_no,record_time,interaction_content,attachments,Talk_direction FROM customer_service_record order by record_no";
    private static final String GET_ONE_STMT =
            "SELECT record_no,member_no,admin_no,record_time,interaction_content,attachments,Talk_direction FROM customer_service_record where record_no = ?";


    static {
        try {
            Class.forName(Util.DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver."
                    + e.getMessage());
        }
    }
    @Override
    public void insert(CSRecVO CSRecVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
            pstmt = con.prepareStatement(INSERT_STMT);

            pstmt.setInt(1, CSRecVO.getRecordNo());
            pstmt.setInt(2, CSRecVO.getMemberNo());
            pstmt.setInt(3, CSRecVO.getAdminNo());
            pstmt.setDate(4, CSRecVO.getRecordTime());
            pstmt.setString(5, CSRecVO.getInteractionContent());
            pstmt.setBytes(6, CSRecVO.getAttachments());
            pstmt.setInt(7, CSRecVO.getTalkDirection());

            pstmt.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("Database error occurred."
                    + se.getMessage());
        } finally {
            Util.closeResources(con, pstmt, null);
        }
    }


    @Override
    public CSRecVO findByPrimaryKey(Integer recordNo) {

        CSRecVO csRecVO = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
            pstmt = con.prepareStatement(GET_ONE_STMT);

            pstmt.setInt(1, recordNo);
            rs = pstmt.executeQuery();

            while (rs.next()){
                csRecVO = new CSRecVO();
                csRecVO.setRecordNo(rs.getInt("record_no"));
                csRecVO.setMemberNo(rs.getInt("member_no"));
                csRecVO.setAdminNo(rs.getInt("admin_no"));
                csRecVO.setRecordTime(rs.getDate("record_time"));
                csRecVO.setInteractionContent(rs.getString("interaction_content"));
                csRecVO.setAttachments(rs.getBytes("attachments"));
                csRecVO.setTalkDirection(rs.getInt("talk_direction"));
            }

        } catch (SQLException se) {
            throw new RuntimeException("Database error occurred."
                    + se.getMessage());
        } finally {
            Util.closeResources(con, pstmt, rs);
        }
        return csRecVO;
    }

    @Override
    public List<CSRecVO> getAll() {
        List<CSRecVO> list = new ArrayList<CSRecVO>();
        CSRecVO csRecVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()){
                csRecVO = new CSRecVO();
                csRecVO.setRecordNo(rs.getInt("record_no"));
                csRecVO.setMemberNo(rs.getInt("member_no"));
                csRecVO.setAdminNo(rs.getInt("admin_no"));
                csRecVO.setRecordTime(rs.getDate("record_time"));
                csRecVO.setInteractionContent(rs.getString("interaction_content"));
                csRecVO.setAttachments(rs.getBytes("attachments"));
                csRecVO.setTalkDirection(rs.getInt("talk_direction"));
                list.add(csRecVO);
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
