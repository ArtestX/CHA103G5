package com.cha103g5.member.model;

import java.util.List;
import java.util.Map;

public interface MemberDAOinterface {
	int insert(MemberVO memberVO);
	
	int update(MemberVO memberVO);
	
	void delete(Integer memberno);
	
	MemberVO findByPrimaryKey(Integer memberno);
	
	List<MemberVO> getAll();
	
	List<MemberVO> getByCompositeQuery(Map<String, String> map);
	
}
