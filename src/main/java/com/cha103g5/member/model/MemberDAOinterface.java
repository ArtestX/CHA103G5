package com.cha103g5.member.model;

import java.util.List;
import java.util.Set;

public interface MemberDAOinterface {
	int insert(MemberVO mbrVO);
	int update(MemberVO mbrVO);
	public MemberVO findByPrimaryKey(Integer memberno);
	public List<MemberVO> findByMbrName(String membername);
	public List<MemberVO> getAll();
	
}
