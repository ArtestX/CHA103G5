package com.cha103g5.member.model.old;

import java.util.List;
import java.util.Map;

import com.cha103g5.member.model.MemberVO;


public interface MemberDAOinterface {
	int insert(MemberVO memberVO);
	
	int update(MemberVO memberVO);
	
	void delete(Integer memberno);
	
	MemberVO findByPrimaryKey(Integer memberno);
	
	MemberVO findByMemberEmail(String memberemail);
	
	List<MemberVO> getAll();
	
	
		  
	
}
