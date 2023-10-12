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
		mbrVO.setMemberaccount("abcd");
		mbrVO.setMembername("David Wu");
		mbrVO.setMembergender(1);
		mbrVO.setMemberpassword("123");
		mbrVO.setMemberphone("0912345678");
		mbrVO.setMemberemail("123456@gmail.com");
		mbrVO.setMemberaddress("桃園市中壢區復興路46號8F");
		mbrVO.setMemberjointime(currentTimestamp);
		mbrVO.setMemberbirthday(java.sql.Timestamp.valueOf("2023-10-11 00:00:00"));
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
