package com.cha103g5.member.model;

import java.util.*;
import java.sql.*;


public class MemberJDBCDAO implements MemberDAOinterface{
	private static final String INSERT_STMT = 
			"INSERT INTO member(memberaccount, membername, membergender, memberpassword, memberphone, memberemail, memberaddress, memberjointime, memberbirthday, membernation, memberpic, membercard, memberpoints, memberstat, memberid, memberjob, membersal) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_STMT = 
			"UPDATE member SET membername = ?, memberpassword = ?, memberphone = ?, memberemail = ?, memberaddress = ?, memberbirthday = ?, membernation = ?, memberpic = ?, membercard = ?, memberid = ?, memberjob = ?, membersal = ? WHERE memberno = ?";
	private static final String FIND_BY_PK = 
			"SELECT * FROM member WHERE memberno = ?";
	private static final String FIND_BY_BMRNAME = 
			"SELECT * FROM member WHERE membername = ?";
	private static final String GET_ALL = "SELECT * FROM member";
	
	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public int insert(MemberVO mbrVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, mbrVO.getMemberaccount());
			pstmt.setString(2, mbrVO.getMembername());
			pstmt.setInt(3, mbrVO.getMembergender());
			pstmt.setString(4, mbrVO.getMemberpassword());
			pstmt.setString(5, mbrVO.getMemberphone());
			pstmt.setString(6, mbrVO.getMemberemail());
			pstmt.setString(7, mbrVO.getMemberaddress());
			pstmt.setTimestamp(8, mbrVO.getMemberjointime());
			pstmt.setTimestamp(9, mbrVO.getMemberbirthday());
			pstmt.setString(10, mbrVO.getMembernation());
			pstmt.setObject(11, mbrVO.getMemberpic());
			pstmt.setString(12, mbrVO.getMembercard());
			pstmt.setInt(13, mbrVO.getMemberpoints());
			pstmt.setInt(14, mbrVO.getMemberstat());
			pstmt.setString (15, mbrVO.getMemberid());
			pstmt.setString (16, mbrVO.getMemberjob());
			pstmt.setInt(17, mbrVO.getMembersal());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Util.closeResource(con, pstmt, null);
		}
		return 0;
		
		
	}

	@Override
	public int update(MemberVO mbrVO) {
		return 0;		
	}

	@Override
	public MemberVO findByPrimaryKey(Integer memberNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVO> findByMbrName(String memberName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<MemberVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
