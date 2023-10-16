package com.cha103g5.csrec.model;

import com.cha103g5.util.Util;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CSRecJDBCDAO implements CSRecDAO_interface {

    private static final String INSERT_STMT =
            "INSERT INTO customerservicerecord (recordno,memberno,adminno,recordtime,interactioncontent,talkdirection) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String GET_ALL_STMT =
            "SELECT recordno,memberno,adminno,recordtime,interactioncontent,talkdirection FROM customerservicerecord order by recordno";
    private static final String GET_ONE_STMT =
            "SELECT recordno,memberno,adminno,recordtime,interactioncontent,talkdirection FROM customerservicerecord where recordno = ?";


    @Override
    public void insert(CSRecVO CSRecVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = Util.getConnection();
            pstmt = con.prepareStatement(INSERT_STMT);

            pstmt.setInt(1, CSRecVO.getRecordNo());
            pstmt.setInt(2, CSRecVO.getMemberNo());
            pstmt.setInt(3, CSRecVO.getAdminNo());
            pstmt.setDate(4, CSRecVO.getRecordTime());
            pstmt.setString(5, CSRecVO.getInteractionContent());
            pstmt.setInt(6, CSRecVO.getTalkDirection());

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
            con = Util.getConnection();
            pstmt = con.prepareStatement(GET_ONE_STMT);

            pstmt.setInt(1, recordNo);
            rs = pstmt.executeQuery();

            while (rs.next()){
                csRecVO = new CSRecVO();
                csRecVO.setRecordNo(rs.getInt("recordno"));
                csRecVO.setMemberNo(rs.getInt("memberno"));
                csRecVO.setAdminNo(rs.getInt("adminno"));
                csRecVO.setRecordTime(rs.getDate("recordtime"));
                csRecVO.setInteractionContent(rs.getString("interactioncontent"));
                csRecVO.setTalkDirection(rs.getInt("talkdirection"));
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
            con = Util.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()){
                csRecVO = new CSRecVO();
                csRecVO.setRecordNo(rs.getInt("recordno"));
                csRecVO.setMemberNo(rs.getInt("memberno"));
                csRecVO.setAdminNo(rs.getInt("adminno"));
                csRecVO.setRecordTime(rs.getDate("recordtime"));
                csRecVO.setInteractionContent(rs.getString("interactioncontent"));
                csRecVO.setTalkDirection(rs.getInt("talkdirection"));
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
