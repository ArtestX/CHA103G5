package com.cha103g5.adoptedapplication.model;

import java.sql.Date;
import java.util.List;

public class AdoptedapplicationTest {
	public static void main(String[] args) {
		
		AdoptedapplicationDAO dao = new AdoptedapplicationDAOImpl();

//	    // 第一筆假資料
//	    AdoptedapplicationVO adoptedapplicationVO1 = new AdoptedapplicationVO();
//	    adoptedapplicationVO1.setAdminno(101);
//	    adoptedapplicationVO1.setMemberno(201);
//	    adoptedapplicationVO1.setPetid(301);
//	    adoptedapplicationVO1.setInteractiondate(Date.valueOf("2023-01-01"));
//	    adoptedapplicationVO1.setLotteryresult(1);
//	    adoptedapplicationVO1.setLotterydate(Date.valueOf("2023-01-02"));
//	    adoptedapplicationVO1.setApplicationstat(0);
//	    adoptedapplicationVO1.setApplicantnotes("第一筆備註");
//	    adoptedapplicationVO1.setAgreement("第一筆協議書".getBytes());
//	    adoptedapplicationVO1.setApplicationdate(Date.valueOf("2023-01-03"));
//	    dao.insert(adoptedapplicationVO1);
//
//	    // 第二筆假資料
//	    AdoptedapplicationVO adoptedapplicationVO2 = new AdoptedapplicationVO();
//	    adoptedapplicationVO2.setAdminno(102);
//	    adoptedapplicationVO2.setMemberno(202);
//	    adoptedapplicationVO2.setPetid(302);
//	    adoptedapplicationVO2.setInteractiondate(Date.valueOf("2023-01-04"));
//	    adoptedapplicationVO2.setLotteryresult(0);
//	    adoptedapplicationVO2.setLotterydate(Date.valueOf("2023-01-05"));
//	    adoptedapplicationVO2.setApplicationstat(1);
//	    adoptedapplicationVO2.setApplicantnotes("第二筆備註");
//	    adoptedapplicationVO2.setAgreement("第二筆協議書".getBytes());
//	    adoptedapplicationVO2.setApplicationdate(Date.valueOf("2023-01-06"));
//	    dao.insert(adoptedapplicationVO2);
//
//	    // 第三筆假資料
//	    AdoptedapplicationVO adoptedapplicationVO3 = new AdoptedapplicationVO();
//	    adoptedapplicationVO3.setAdminno(103);
//	    adoptedapplicationVO3.setMemberno(203);
//	    adoptedapplicationVO3.setPetid(303);
//	    adoptedapplicationVO3.setInteractiondate(Date.valueOf("2023-01-07"));
//	    adoptedapplicationVO3.setLotteryresult(1);
//	    adoptedapplicationVO3.setLotterydate(Date.valueOf("2023-01-08"));
//	    adoptedapplicationVO3.setApplicationstat(0);
//	    adoptedapplicationVO3.setApplicantnotes("第三筆備註");
//	    adoptedapplicationVO3.setAgreement("第三筆協議書".getBytes());
//	    adoptedapplicationVO3.setApplicationdate(Date.valueOf("2023-01-09"));
//	    dao.insert(adoptedapplicationVO3);

//	    AdoptedapplicationVO adoptedapplicationVO = new AdoptedapplicationVO();
//	    adoptedapplicationVO.setApplicationno(200002);
//	    adoptedapplicationVO.setAdminno(101);
//	    adoptedapplicationVO.setMemberno(201);
//	    adoptedapplicationVO.setPetid(301);
//	    adoptedapplicationVO.setInteractiondate(Date.valueOf("2023-02-01"));
//	    adoptedapplicationVO.setLotteryresult(2);
//	    adoptedapplicationVO.setLotterydate(Date.valueOf("2023-02-02"));
//	    adoptedapplicationVO.setApplicationstat(1);
//	    adoptedapplicationVO.setApplicantnotes("更新後的備註");
//	    adoptedapplicationVO.setAgreement("更新後的協議書".getBytes());
//	    adoptedapplicationVO.setApplicationdate(Date.valueOf("2023-02-03"));
//
//	    dao.update(adoptedapplicationVO);
		
//		List<AdoptedapplicationVO> result = dao.findByPetidAndLotterydate(301, Date.valueOf("2023-02-02"));
//		for (AdoptedapplicationVO vo : result) {
//		    System.out.println(vo.toString());
//		}
//		
//		List<AdoptedapplicationVO> adoptedapplicationList = dao.getAll();
//		for (AdoptedapplicationVO adoptedapplicationVO : adoptedapplicationList) {
//			System.out.println(adoptedapplicationVO);
//		}
	}
}
