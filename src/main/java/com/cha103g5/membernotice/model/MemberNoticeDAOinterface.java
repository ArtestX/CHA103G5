package com.cha103g5.membernotice.model;

import java.util.List;

public interface MemberNoticeDAOinterface{
	
	  public void insert(MemberNoticeVO memberNoticeVO, Integer memberno);
	  
	  public List<MemberNoticeVO> getAllByMemberno(Integer memberno);
	  
	  public List<MemberNoticeVO> getNoticesByMembernoAndRead(Integer memberno, Integer readstat) ;
	  
	  public int getUnreadCountByMemberno(Integer memberno);
	  
	  public void markNoticesAsRead(Integer membernoticeno);
	  
//	   public void deleteNotices(Integer memberno, Integer... membernoticeno);
	   
//	   boolean isAlreadyRead(Integer readstat);
}
