package com.cha103g5.member.model;

import java.sql.Timestamp;
import java.util.Date;


public class TestMemberJDBCDAO {
	
	public static void main(String[] args) {

		MemberJDBCDAO dao = new MemberJDBCDAO();
		
		Date currentTime = new Date();
		Timestamp currentTimestamp = new Timestamp(currentTime.getTime());
	
		// 新增
		MemberVO mbrVO = new MemberVO();
		mbrVO.setMemberaccount("abcde");
		mbrVO.setMembername("Peter Wu");
		mbrVO.setMembergender(1);
		mbrVO.setMemberpassword("123");
		mbrVO.setMemberphone("0912345678");
		mbrVO.setMemberemail("1234567@gmail.com");
		mbrVO.setMemberaddress("桃園市中壢區復興路46號8F");
		mbrVO.setMemberjointime(currentTimestamp);
		mbrVO.setMemberbirthday(java.sql.Date.valueOf("2023-10-11"));
		mbrVO.setMembernation("桃園");
		mbrVO.setMemberpic(null);
		mbrVO.setMembercard("1234-2345-3456-4567");
		mbrVO.setMemberpoints(0);
		mbrVO.setMemberstat(0);
		mbrVO.setMemberid("A123456789");
		mbrVO.setMemberjob("manager");
		mbrVO.setMembersal(1);
		dao.insert(mbrVO);
		
	}
}
