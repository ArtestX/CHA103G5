package com.cha103g5.member.model;

import java.util.*;
import java.sql.*;


public class MbrJDBCDAO implements MbrDAO_interface{
	private static final String INSERT_STMT = 
			"INSERT INTO member(member_account, member_name, member_gender, member_password, member_phone, member_email, member_address, member_join_time, member_birthday, member_nation, member_pic, member_card, member_points, member_stat, member_id, member_job, member_sal) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_STMT = 
			"UPDATE member SET member_name = ?, member_password = ?, member_phone = ?, member_email = ?, member_address = ?, member_birthday = ?, member_nation = ?, member_pic = ?, member_card = ?, member_id = ?, member_job = ?, member_sal = ? WHERE member_no = ?";
	private static final String FIND_BY_PK = 
			"SELECT * FROM member WHERE member_no = ?";
	private static final String FIND_BY_BMRNAME = 
			"SELECT * FROM member WHERE member_name = ?";
	private static final String GET_ALL = "SELECT * FROM member";
	
	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void insert(MbrVO mbrVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, mbrVO.getMemberAccount());
			pstmt.setString(2, mbrVO.getMemberName());
			pstmt.setInt(3, mbrVO.getMemberGender());
			pstmt.setString(4, mbrVO.getMemberPassword());
			pstmt.setString(5, mbrVO.getMemberPhone());
			pstmt.setString(6, mbrVO.getMemberEmail());
			pstmt.setString(7, mbrVO.getMemberAddress());
			pstmt.setTimestamp(8, mbrVO.getMemberJoinTime());
			pstmt.setTimestamp(9, mbrVO.getMemberBirthday());
			pstmt.setString(10, mbrVO.getMemberNation());
			pstmt.setObject(11, mbrVO.getMemberPic());
			pstmt.setString(12, mbrVO.getMemberCard());
			pstmt.setInt(13, mbrVO.getMemberPoints());
			pstmt.setInt(14, mbrVO.getMemberStat());
			pstmt.setString (15, mbrVO.getMemberId());
			pstmt.setString (16, mbrVO.getMemberJob());
			pstmt.setInt(17, mbrVO.getMemberSal());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Util.closeResource(con, pstmt, null);
		}
		
		
	}

	@Override
	public void update(MbrVO mbrVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MbrVO findByPrimaryKey(Integer memberNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MbrVO> findByMbrName(String memberName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<MbrVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
