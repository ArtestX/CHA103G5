package com.cha103g5.member.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.cha103g5.util.Util;

public class MemberJNDIDAO implements MemberDAOinterface{
	
	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
		private static DataSource ds = null;
		static {
			try {
				Context ctx = new InitialContext();
				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB2");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
	
	private static final String INSERT_STMT = 
			"INSERT INTO member(memberaccount, membername, membergender, memberpassword, memberphone, memberemail, memberaddress, memberjointime, memberbirthday, membernation, memberpic, membercard, memberpoints, memberstat, memberid, memberjob, membersal) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//	private static final String UPDATE_STMT = 
//			"UPDATE member SET membername = ?, memberpassword = ?, memberphone = ?, memberemail = ?, memberaddress = ?, memberbirthday = ?, membernation = ?, memberpic = ?, membercard = ?, memberid = ?, memberjob = ?, membersal = ? WHERE memberno = ?";
//	private static final String FIND_BY_PK = 
//			"SELECT * FROM member WHERE memberno = ?";
//	private static final String FIND_BY_BMRNAME = 
//			"SELECT * FROM member WHERE membername = ?";
//	private static final String GET_ALL = "SELECT * FROM member";
	
	@Override
	public void insert(MemberVO mbrVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, mbrVO.getMemberaccount());
			pstmt.setString(2, mbrVO.getMembername());
			pstmt.setInt(3, mbrVO.getMembergender());
			pstmt.setString(4, mbrVO.getMemberpassword());
			pstmt.setString(5, mbrVO.getMemberphone());
			pstmt.setString(6, mbrVO.getMemberemail());
			pstmt.setString(7, mbrVO.getMemberaddress());
			pstmt.setTimestamp(8, mbrVO.getMemberjointime());
			pstmt.setDate(9, mbrVO.getMemberbirthday());
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
		}finally {
			Util.closeResources(con, pstmt, null);
		} 
		return;
		
		
	}

	@Override
	public int update(MemberVO mbrVO) {
		return 0;		
	}

	@Override
	public MemberVO findByPrimaryKey(Integer memberNo) {
		
		return null;
	}

	@Override
	public List<MemberVO> findByMemberName(String memberName) {
	
		return null;
	}

	@Override
	public List<MemberVO> getAll() {
		
		return null;
	}
	
}
