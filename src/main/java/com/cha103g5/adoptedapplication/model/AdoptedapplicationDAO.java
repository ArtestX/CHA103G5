package com.cha103g5.adoptedapplication.model;

import java.sql.Date;
import java.util.List;

public interface AdoptedapplicationDAO {

	void insert(AdoptedapplicationVO adoptedapplicationVO);
	void update(AdoptedapplicationVO adoptedapplicationVO);
//	void delete(Integer applicationno);
	
	List<AdoptedapplicationVO> findByPetidAndLotterydate(Integer petid, Date lotterydate);
	List<AdoptedapplicationVO> getAll();
	
}
