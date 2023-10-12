package com.cha103g5.member.model;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class MbrPointRecordJDBCDAO implements MbrPointRecordDAO_interface{
	public static final String INSERT_STMT = 
			"INSERT into member_point_record(member_no, getpoint_time, getpoint, getpoint_reason) VALUES(?, ?, ?, ?)";
	public static final String UPDATE_STMT = 
			"UPDATE member_point_record SET member_no = ?, getpoint_time = ?, getpoint = ?, getpoint_reason = ? WHERE member_point_no = ?";
	public static final String FIND_BY_MBRNO= 
			"SELECT member_no, getpoint_time, getpoint, getpoint_reason FROM member_point_record WHERE member_no = ?";
//	public static final String FIND_BY_MBRNAME= 
//			"SELECT mpr.member_no, mpr.getpoint_time, mpr.getpoint, mpr.getpoint_reason"
//			+ "FROM member_point_record mpr"
//			+ "JOIN member m ON mpr.member_no = m.member_no"
//			+ "WHERE m.member_name = ?;";
//	public static final String FIND_BY_GETPOINTTIME= 
//			"SELECT member_no, getpoint_time, getpoint, getpoint_reason"
//			+ "FROM member_point_record"
//			+ "WHERE getpoint_time BETWEEN ? AND ?";
	public static final String GET_ALL = "SELECT * from member_point_record";
	
	static {
		try {
			Class.forName(Util.DRIVER);
		}catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
		
	}

	@Override
	public void insert(MbrPointRecordVO MbrPointRecordVO) {
		Connection con = null ;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, MbrPointRecordVO.getMemberNo());
			pstmt.setTimestamp(2, MbrPointRecordVO.getGetPointTime());
			pstmt.setInt(3, MbrPointRecordVO.getGetPoint());
			pstmt.setString(4, MbrPointRecordVO.getGetPointReason());
			
			pstmt.executeUpdate();
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			Util.closeResource(con, pstmt, null);
		}
		
	}

	@Override
	public void update(MbrPointRecordVO MbrPointRecordVO) {
		Connection con = null ;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);
			
			pstmt.setInt(1, MbrPointRecordVO.getMemberNo());
			pstmt.setTimestamp(2, MbrPointRecordVO.getGetPointTime());
			pstmt.setInt(3, MbrPointRecordVO.getGetPoint());
			pstmt.setString(4, MbrPointRecordVO.getGetPointReason());
			pstmt.setInt(5, MbrPointRecordVO.getMemberPointNo());
			
			pstmt.executeUpdate();
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			Util.closeResource(con, pstmt, null);
		}
		
	}

	@Override
	public List<MbrPointRecordVO> findBymemberNo(Integer memberNo) {
		List<MbrPointRecordVO> list = new ArrayList<MbrPointRecordVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MbrPointRecordVO MbrPointRecordVO = null;
		
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_MBRNO);
			pstmt.setInt(1, memberNo);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MbrPointRecordVO = new MbrPointRecordVO();
				MbrPointRecordVO.setMemberNo(rs.getInt("member_no"));
				MbrPointRecordVO.setGetPointTime(rs.getTimestamp("getpoint_time"));
				MbrPointRecordVO.setGetPoint(rs.getInt("getpoint"));
				MbrPointRecordVO.setGetPointReason(rs.getString("getpoint_reason"));
				list.add(MbrPointRecordVO); // Store the row in the list
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			Util.closeResource(con, pstmt, rs);
		}
		
		return list;
	}
	
	@Override
	public List<MbrPointRecordVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MbrPointRecordVO> MbrPointRecordVOList = new ArrayList<>();
		
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				//利用MbrPointRecordVO Bean，包裝著查詢的資料回傳給呼叫端
				MbrPointRecordVO MbrPointRecordVO =new MbrPointRecordVO();
				MbrPointRecordVO .setMemberPointNo(rs.getInt("member_point_no"));
				MbrPointRecordVO .setMemberNo(rs.getInt("member_no"));
				MbrPointRecordVO .setGetPointTime(rs.getTimestamp("getpoint_time"));
				MbrPointRecordVO .setGetPoint(rs.getInt("getpoint"));
				MbrPointRecordVO .setGetPointReason(rs.getString("getpoint_reason"));
				//用集合收集著包裝好的部門物件
				MbrPointRecordVOList.add(MbrPointRecordVO);
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			Util.closeResource(con, pstmt, rs);
		}
		return MbrPointRecordVOList;
	
	}
	
//	@Override
//	public List<MbrPointRecordVO> findBygetPointTime(Timestamp startDate, Timestamp endDate) {
//		List<MbrPointRecordVO> list3 = new ArrayList<MbrPointRecordVO>();
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		MbrPointRecordVO MbrPointRecordVO = null;
//		
//		try {
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(FIND_BY_GETPOINTTIME);
//			pstmt.setTimestamp(1, startDate);
//			pstmt.setTimestamp(2, endDate);
//			rs = pstmt.executeQuery();
//			
//			
//			while (rs.next()) {
//				MbrPointRecordVO = new MbrPointRecordVO();
//				MbrPointRecordVO.setMemberNo(rs.getInt("member_no"));
//				MbrPointRecordVO.setGetPointTime(rs.getTimestamp("getpoint_time"));
//				MbrPointRecordVO.setGetPoint(rs.getInt("getpoint"));
//				MbrPointRecordVO.setGetPointReason(rs.getString("getpoint_reason"));
//				list3.add(MbrPointRecordVO); // Store the row in the list
//			}
//			
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}finally {
//			Util.closeResource(con, pstmt, rs);
//		}
//		
//		return list3;
//	}
	

//	@Override
//	public List<MbrPointRecordVO> findBymemberName(String MemberName){
//		List<MbrPointRecordVO> list2 = new ArrayList<>();
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		MbrPointRecordVO MbrPointRecordVO = null;
//		MbrVO MbrVO=null;
//
//		try {
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(FIND_BY_MBRNAME);
//			pstmt.setString(1, MemberName);
//			rs = pstmt.executeQuery();
//			
//			
//			while (rs.next()) {
//				MbrPointRecordVO = new MbrPointRecordVO();
//				MbrPointRecordVO.setMemberNo(rs.getInt("member_no"));
//				MbrPointRecordVO.setGetPointTime(rs.getTimestamp("getpoint_time"));
//				MbrPointRecordVO.setGetPoint(rs.getInt("getpoint"));
//				MbrPointRecordVO.setGetPointReason(rs.getString("getpoint_reason"));
//				list2.add(MbrPointRecordVO); // Store the row in the list
//			}
//			
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}finally {
//			Util.closeResource(con, pstmt, rs);
//		}
//		
//		return list2;
//	}

	
	
}
