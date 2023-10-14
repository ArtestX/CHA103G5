package com.cha103g5.member.model;

import java.sql.*;
import java.util.*; 


public class TestMemberHibernateDAO {
	
	public static void main(String[] args) throws Exception {
		MemberDAOinterface dao = new MemberHibernateDAO();

		// 新增
//		MemberVO memberVO1 = new MemberVO();
//		memberVO1.setMemberaccount("abcde");
//		memberVO1.setMembername("David");
//		memberVO1.setMembergender(1);
//		memberVO1.setMemberpassword("123456");
//		memberVO1.setMemberphone("0912345678");
//		memberVO1.setMemberemail("123456@gmail.com");
//		memberVO1.setMemberaddress("桃園市中壢區復興路46號");
//		memberVO1.setMemberjointime(new Timestamp(new java.util.Date().getTime()));
//		memberVO1.setMemberbirthday(java.sql.Date.valueOf("1998-03-11"));
//		memberVO1.setMembernation("桃園");
//		memberVO1.setMemberpic(null);
//		memberVO1.setMembercard("1234-2345-3456-4567");
//		memberVO1.setMemberpoints(0);
//		memberVO1.setMemberstat(0);
//		memberVO1.setMemberid("A123456789");
//		memberVO1.setMemberjob("manager");
//		memberVO1.setMembersal(2);		
//		dao.insert(memberVO1);

//		// 修改
//		MemberVO memberVO2 = new MemberVO();
//		memberVO2.setMemberno(10010);
//		memberVO2.setMemberaccount("account10");
//		memberVO2.setMembername("David");
//		memberVO2.setMembergender(1);
//		memberVO2.setMemberpassword("1111111");
//		memberVO2.setMemberphone("0912345678");
//		memberVO2.setMemberemail("email10@example.com");
//		memberVO2.setMemberaddress("桃園市中壢區復興路46號");
//		memberVO2.setMemberjointime(new Timestamp(new java.util.Date().getTime()));
//		memberVO2.setMemberbirthday(java.sql.Date.valueOf("1990-10-11"));
//		memberVO2.setMembernation("台南");
//		memberVO2.setMemberpic(null);
//		memberVO2.setMembercard("1234-2345-3456-4567");
//		memberVO2.setMemberpoints(100);
//		memberVO2.setMemberstat(1);
//		memberVO2.setMemberid("B123456789");
//		memberVO2.setMemberjob("sales");
//		memberVO2.setMembersal(1);
//		dao.update(memberVO2);

//
//		// 查詢單筆
//		MemberVO memberVO3 = dao.findByPrimaryKey(10011);
//		System.out.println(memberVO3);
//		System.out.println("---------------------");
		
		
		// 用會員姓名查詢資料
		List<MemberVO> memberVO4 = dao.findByMemberName("David");
		for (MemberVO member : memberVO4) {
			System.out.println(member);
			System.out.println("---------------------");
		}
		// 查詢多筆
//		List<MemberVO> list = dao.getAll();
//		for (MemberVO MbrVO : list) {
//			System.out.print(MbrVO.getMemberno() + ",");
//			System.out.print(MbrVO.getMemberaccount() + ",");
//			System.out.print(MbrVO.getMembername() + ",");
//			System.out.print(MbrVO.getMembergender() + ",");
//			System.out.print(MbrVO.getMemberpassword() + ",");
//			System.out.print(MbrVO.getMemberphone() + ",");
//			System.out.print(MbrVO.getMemberemail());
//			System.out.print(MbrVO.getMemberaddress() + ",");
//			System.out.print(MbrVO.getMemberjointime() + ",");
//			System.out.print(MbrVO.getMemberbirthday() + ",");
//			System.out.print(MbrVO.getMembernation() + ",");
//			System.out.print(MbrVO.getMemberpic() + ",");
//			System.out.print(MbrVO.getMembercard() + ",");
//			System.out.print(MbrVO.getMemberpoints());
//			System.out.print(MbrVO.getMemberstat() + ",");
//			System.out.print(MbrVO.getMemberid() + ",");
//			System.out.print(MbrVO.getMemberjob() + ",");
//			System.out.print(MbrVO.getMembersal() + ",");
//			System.out.println();
//		}
	}
}
