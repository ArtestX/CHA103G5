package com.cha103g5.member.model;

import java.util.List;
import java.util.Set;

public interface MemberDAOinterface {
	public void insert(MemberVO memberVO);
	public int update(MemberVO memberVO);
	public MemberVO findByPrimaryKey(Integer memberno);
	public List<MemberVO> findByMemberName(String membername);
	public List<MemberVO> getAll();
	
}
