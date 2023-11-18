package com.cha103g5.member.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.cha103g5.util.HibernateUtil;

public class MemberService {
	
	private MemberDAOinterface dao;
	
	public MemberService() {
		dao = new MemberHibernateDAO(HibernateUtil.getSessionFactory());
	}

	public MemberVO signUpMember(String memberemail, String membername, Integer membergender, 
			String memberpassword, String memberphone, Timestamp memberjointime, Date memberbirthday, 
			Integer memberpoints, Integer memberstat) {
		
		MemberVO memberVO1 = new MemberVO();
		memberVO1.setMemberemail(memberemail);
		memberVO1.setMembername(membername);
		memberVO1.setMembergender(membergender);
		memberVO1.setMemberpassword(memberpassword);
		memberVO1.setMemberphone(memberphone);
		memberVO1.setMemberjointime(memberjointime);
		memberVO1.setMemberbirthday(memberbirthday);
		memberVO1.setMemberpoints(memberpoints);
		memberVO1.setMemberstat(memberstat);
		dao.insert(memberVO1);
			
		return memberVO1;
	}
	
	// 檢查使用者名稱是否存在的方法
    public boolean existsUsername(String memberemail) {
        // 這裡使用了假設的 UserRepository 方法 isUsernameExists()，您應根據實際情況修改它
        boolean exists = dao.isUsernameExists(memberemail);
        return exists;
    }

	public MemberVO updateMember(Integer memberno, String membername, Integer membergender, String memberpassword,
			String memberphone, String memberaddress, Date memberbirthday, byte[] memberpic, 
			String membercard, String memberid, String memberjob, Integer membersal) {
		
		MemberVO memberVO = dao.findByPrimaryKey(memberno); // 先獲取現有的 MemberVO 物件
		if (memberVO != null) {		    	
				memberVO.setMembername(membername);
				memberVO.setMembergender(membergender);
				memberVO.setMemberpassword(memberpassword);
				memberVO.setMemberphone(memberphone);
				memberVO.setMemberaddress(memberaddress);
				memberVO.setMemberbirthday(memberbirthday);
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
	
	public MemberVO getMemberByMemberemail(String memberemail) {
		return dao.findByMemberEmail(memberemail);
	}

	 public MemberVO updateMembers(MemberVO memberVO) {
	     int updateResult = dao.update(memberVO);
	     
	     if (updateResult == 1) {
	         // 更新成功
	         return memberVO;
	     } else {
	         return null;
	     }
	 }
}
