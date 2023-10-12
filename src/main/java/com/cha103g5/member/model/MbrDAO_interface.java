package com.cha103g5.member.model;

import java.util.List;
import java.util.Set;

public interface MbrDAO_interface {
	void insert(MbrVO mbrVO);
	void update(MbrVO mbrVO);
	public MbrVO findByPrimaryKey(Integer memberno);
	public List<MbrVO> findByMbrName(String membername);
//	public Set<MbrPointRecordVO> getPointRecordByMbrName(String memberName);
	public List<MbrVO> getAll();
	
}
