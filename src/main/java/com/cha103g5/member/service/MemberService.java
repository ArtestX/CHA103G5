package com.cha103g5.member.service;

import java.sql.Date;
import java.sql.Timestamp;

import com.cha103g5.member.model.*;

import com.cha103g5.util.HibernateUtil;

import com.cha103g5.member.model.MemberDAOinterface;

public class MemberService {
	
	private MemberDAOinterface dao;

	public MemberService() {
		dao = new MemberJNDIDAO();
	}
	
	public MemberVO addMember(String memberaccount, String membername, Integer membergender, String memberpassword,
				String memberphone, String memberemail, String memberaddress, Timestamp memberjointime,
				Date memberbirthday, String membernation, byte[] memberpic, String membercard, Integer memberpoints,
				Integer memberstat, String memberid, String memberjob, Integer membersal){
		MemberVO memberVO1 = new MemberVO();
		memberVO1.setMemberaccount(memberaccount);
		memberVO1.setMembername(membername);
		memberVO1.setMembergender(membergender);
		memberVO1.setMemberpassword(memberpassword);
		memberVO1.setMemberphone(memberphone);
		memberVO1.setMemberemail(memberemail);
		memberVO1.setMemberaddress(memberaddress);
		memberVO1.setMemberjointime(memberjointime);
		memberVO1.setMemberbirthday(memberbirthday);
		memberVO1.setMembernation(membernation);
		memberVO1.setMemberpic(memberpic);
		memberVO1.setMembercard(membercard);
		memberVO1.setMemberpoints(memberpoints);
		memberVO1.setMemberstat(memberstat);
		memberVO1.setMemberid(memberid);
		memberVO1.setMemberjob(memberjob);
		memberVO1.setMembersal(membersal);		
		dao.insert(memberVO1);

		return memberVO1;
	}

	//預留給 Struts 2 或 Spring MVC 用
	public void addMember(MemberVO memberVO) {
		dao.insert(memberVO);
	}
}
