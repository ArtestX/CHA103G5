package com.cha103g5.member.model;

import java.sql.Timestamp;
import java.util.Date;


public class TestMbrJDBCDAO {
	
	public static void main(String[] args) {

		MbrJDBCDAO dao = new MbrJDBCDAO();
		
		Date currentTime = new Date();
		Timestamp currentTimestamp = new Timestamp(currentTime.getTime());
	
		// 新增
		MbrVO mbrVO = new MbrVO();
		mbrVO.setMemberAccount("abcd");
		mbrVO.setMemberName("David Wu");
		mbrVO.setMemberGender(1);
		mbrVO.setMemberPassword("123");
		mbrVO.setMemberPhone("0912345678");
		mbrVO.setMemberEmail("123456@gmail.com");
		mbrVO.setMemberAddress("桃園市中壢區復興路46號8F");
		mbrVO.setMemberJoinTime(currentTimestamp);
		mbrVO.setMemberBirthday(java.sql.Timestamp.valueOf("2023-10-11 00:00:00"));
		mbrVO.setMemberNation("桃園");
		mbrVO.setMemberPic(null);
		mbrVO.setMemberCard("1234-2345-3456-4567");
		mbrVO.setMemberPoints(0);
		mbrVO.setMemberStat(0);
		mbrVO.setMemberId("A123456789");
		mbrVO.setMemberJob("manager");
		mbrVO.setMemberSal(1);
		dao.insert(mbrVO);
		
	}
}
