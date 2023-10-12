package com.cha103g5.memberpointrecord.model;

//import java.sql.Timestamp;
import java.util.List;

public interface MemberPointRecordDAOinterface {
	void insert(MemberPointRecordVO MbrPointRecordVO);
	void update(MemberPointRecordVO MbrPointRecordVO);
	

	List<MemberPointRecordVO> findBymemberNo(Integer memberno);
//	List<MbrPointRecordVO> findBygetPointTime(Timestamp startDate, Timestamp endDate);
//	List<MbrPointRecordVO> findBymemberName(String MemberName);
	List<MemberPointRecordVO> getAll();
	
	
}
