package com.cha103g5.member.service;

import java.util.List;
import java.util.Map;

import com.cha103g5.member.model.MemberVO;

public interface MemberServiceInterface {
	MemberVO addMember(MemberVO memberVO);
	
	MemberVO updateMember(MemberVO memberVO);
	
	MemberVO getMemberByMemberno(Integer memberno);
	
	List<MemberVO> getAllMembers(int currentPage);
	
	int getPageTotal();
	
	List<MemberVO> getMembersByCompositeQuery(Map<String, String[]> map);
}
