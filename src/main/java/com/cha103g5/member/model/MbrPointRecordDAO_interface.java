package com.cha103g5.member.model;

//import java.sql.Timestamp;
import java.util.List;

public interface MbrPointRecordDAO_interface {
	void insert(MbrPointRecordVO MbrPointRecordVO);
	void update(MbrPointRecordVO MbrPointRecordVO);
	

	List<MbrPointRecordVO> findBymemberNo(Integer memberNo);
//	List<MbrPointRecordVO> findBygetPointTime(Timestamp startDate, Timestamp endDate);
//	List<MbrPointRecordVO> findBymemberName(String MemberName);
	List<MbrPointRecordVO> getAll();
	
	
}
