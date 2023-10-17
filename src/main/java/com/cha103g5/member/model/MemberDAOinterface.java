package com.cha103g5.member.model;

import java.util.List;
import java.util.Map;

public interface MemberDAOinterface {
	int insert(MemberVO memberVO);
	
	int update(MemberVO memberVO);
	
	MemberVO findByPrimaryKey(Integer memberno);
	
	List<MemberVO> getAll();
	
	List<MemberVO> getByCompositeQuery(Map<String, String> map);
	
	List<MemberVO> getAll(int currentPage);
	
	long getTotal();
}
