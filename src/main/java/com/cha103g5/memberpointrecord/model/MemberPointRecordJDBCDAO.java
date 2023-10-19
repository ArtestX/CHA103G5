package com.cha103g5.memberpointrecord.model;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import com.cha103g5.util.Util;

public class MemberPointRecordJDBCDAO implements MemberPointRecordDAOinterface{
	public static final String INSERT_STMT = 
			"INSERT into memberpointrecord(memberno, getpointtime, getpoint, getpointreason) VALUES(?, ?, ?, ?)";
	public static final String UPDATE_STMT = 
			"UPDATE memberpointrecord SET memberno = ?, getpointtime = ?, getpoint = ?, getpointreason = ? WHERE memberpointno = ?";
	public static final String FIND_BY_MBRNO= 
			"SELECT memberno, getpointtime, getpoint, getpointreason FROM memberpointrecord WHERE memberno = ?";
//	public static final String FIND_BY_MBRNAME= 
//			"SELECT mpr.member_no, mpr.getpoint_time, mpr.getpoint, mpr.getpoint_reason"
//			+ "FROM member_point_record mpr"
//			+ "JOIN member m ON mpr.member_no = m.member_no"
//			+ "WHERE m.member_name = ?;";
//	public static final String FIND_BY_GETPOINTTIME= 
//			"SELECT member_no, getpoint_time, getpoint, getpoint_reason"
//			+ "FROM member_point_record"
//			+ "WHERE getpoint_time BETWEEN ? AND ?";
	public static final String GET_ALL = "SELECT * from memberpointrecord";
	
	Util util = new Util();

	@Override
	public void insert(MemberPointRecordVO MbrPointRecordVO) {
		Connection con = null ;
		PreparedStatement pstmt = null;
		
		try {
			con = Util.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, MbrPointRecordVO.getMemberno());
			pstmt.setTimestamp(2, MbrPointRecordVO.getGetpointtime());
			pstmt.setInt(3, MbrPointRecordVO.getGetpoint());
			pstmt.setString(4, MbrPointRecordVO.getGetpointreason());
			
			pstmt.executeUpdate();
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			Util.closeResources(con, pstmt, null);
		}
		
	}

	@Override
	public void update(MemberPointRecordVO MbrPointRecordVO) {
		Connection con = null ;
		PreparedStatement pstmt = null;
		
		try {
			con = Util.getConnection();
			pstmt = con.prepareStatement(UPDATE_STMT);
			
			pstmt.setInt(1, MbrPointRecordVO.getMemberno());
			pstmt.setTimestamp(2, MbrPointRecordVO.getGetpointtime());
			pstmt.setInt(3, MbrPointRecordVO.getGetpoint());
			pstmt.setString(4, MbrPointRecordVO.getGetpointreason());
			pstmt.setInt(5, MbrPointRecordVO.getMemberpointno());
			
			pstmt.executeUpdate();
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			Util.closeResources(con, pstmt, null);
		}
		
	}

	@Override
	public List<MemberPointRecordVO> findBymemberNo(Integer memberno) {
		List<MemberPointRecordVO> list = new ArrayList<MemberPointRecordVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberPointRecordVO MbrPointRecordVO = null;
		
		try {
			con = Util.getConnection();
			pstmt = con.prepareStatement(FIND_BY_MBRNO);
			pstmt.setInt(1, memberno);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MbrPointRecordVO = new MemberPointRecordVO();
				MbrPointRecordVO.setMemberno(rs.getInt("memberno"));
				MbrPointRecordVO.setGetpointtime(rs.getTimestamp("getpointtime"));
				MbrPointRecordVO.setGetpoint(rs.getInt("getpoint"));
				MbrPointRecordVO.setGetpointreason(rs.getString("getpointreason"));
				list.add(MbrPointRecordVO); // Store the row in the list
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			Util.closeResources(con, pstmt, null);
		}
		
		return list;
	}
	
	@Override
	public List<MemberPointRecordVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberPointRecordVO> MbrPointRecordVOList = new ArrayList<>();
		
		try {
			con = Util.getConnection();
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				//利用MbrPointRecordVO Bean，包裝著查詢的資料回傳給呼叫端
				MemberPointRecordVO MbrPointRecordVO =new MemberPointRecordVO();
				MbrPointRecordVO .setMemberpointno(rs.getInt("member_point_no"));
				MbrPointRecordVO .setMemberno(rs.getInt("member_no"));
				MbrPointRecordVO .setGetpointtime(rs.getTimestamp("getpoint_time"));
				MbrPointRecordVO .setGetpoint(rs.getInt("getpoint"));
				MbrPointRecordVO .setGetpointreason(rs.getString("getpoint_reason"));
				//用集合收集著包裝好的部門物件
				MbrPointRecordVOList.add(MbrPointRecordVO);
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			Util.closeResources(con, pstmt, rs);
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
