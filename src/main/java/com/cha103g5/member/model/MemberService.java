package com.cha103g5.member.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cha103g5.admin.model.AdminVO;
import com.cha103g5.util.HibernateUtil;

public class MemberService {
	
	private MemberDAOinterface dao;
	
	public MemberService() {
		dao = new MemberHibernateDAO(HibernateUtil.getSessionFactory());
	}

	public MemberVO signUpMember(String memberemail, String membername, Integer membergender, 
			String memberpassword, String memberphone, String memberaddress, 
			Timestamp memberjointime, Date memberbirthday, String membernation, 
			byte[] memberpic, String membercard, Integer memberpoints, Integer memberstat, 
			String memberid, String memberjob, Integer membersal) {
		
		MemberVO memberVO1 = new MemberVO();
		memberVO1.setMemberemail(memberemail);
		memberVO1.setMembername(membername);
		memberVO1.setMembergender(membergender);
		memberVO1.setMemberpassword(memberpassword);
		memberVO1.setMemberphone(memberphone);
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

	public MemberVO updateMember(Integer memberno, String membername, Integer membergender, String memberpassword,
			String memberphone, String memberaddress, Date memberbirthday, String membernation, byte[] memberpic, 
			String membercard, String memberid, String memberjob, Integer membersal) {
		
		MemberVO memberVO = dao.findByPrimaryKey(memberno); // 先獲取現有的 MemberVO 物件
		if (memberVO != null) {		    	
				memberVO.setMembername(membername);
				memberVO.setMembergender(membergender);
				memberVO.setMemberpassword(memberpassword);
				memberVO.setMemberphone(memberphone);
				memberVO.setMemberaddress(memberaddress);
				memberVO.setMemberbirthday(memberbirthday);
				memberVO.setMembernation(membernation);
				memberVO.setMemberpic(memberpic);
				memberVO.setMembercard(membercard);
				memberVO.setMemberid(memberid);
				memberVO.setMemberjob(memberjob);
				memberVO.setMembersal(membersal);
		        dao.update(memberVO); // 使用現有物件進行更新
		}
		return memberVO; // 返回已更新的 MemberVO 物件
	}
	
	public MemberVO deleteMember(Integer memberno) {
		MemberVO memberVO = dao.findByPrimaryKey(memberno); // 先獲取現有的 MemberVO 物件
		if (memberVO != null) 
			dao.delete(memberno);
		return null;
	}

	public MemberVO getMemberByMemberno(Integer memberno) {
		return dao.findByPrimaryKey(memberno);
	}

	public List<MemberVO> getAllMembers() {
		return dao.getAll();
	}

	public List<MemberVO> getMembersByCompositeQuery(Map<String, String[]> map) {
		Map<String, String> query = new HashMap<>();
		// Map.Entry即代表一組key-value
		Set<Map.Entry<String, String[]>> entry = map.entrySet();
		
		for (Map.Entry<String, String[]> row : entry) {
			String key = row.getKey();
			// 因為請求參數裡包含了action，做個去除動作
			if ("action".equals(key)) {
				continue;
			}
			// 若是value為空即代表沒有查詢條件，做個去除動作
			String value = row.getValue()[0];
			if (value.isEmpty() || value == null) {
				continue;
			}
			query.put(key, value);
		}
		
		System.out.println(query);
		
		return dao.getByCompositeQuery(query);
	}
	

	
}
