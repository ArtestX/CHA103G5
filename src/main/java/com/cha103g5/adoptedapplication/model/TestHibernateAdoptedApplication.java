package com.cha103g5.adoptedapplication.model;

import java.sql.Date;
import java.util.List;

public class TestHibernateAdoptedApplication {
	
	public static void main(String[] args) {
		HibernateAdoptedApplicationDAO dao = new HibernateAdoptedApplicationDAOImpl();
		
//	    // 第一筆假資料
//	    HibernateAdoptedApplicationVO adopt01 = new HibernateAdoptedApplicationVO();
//	    adopt01.setAdminno(101);
//	    adopt01.setMemberno(201);
//	    adopt01.setPetid(301);
//	    adopt01.setInteractiondate(Date.valueOf("2023-01-01"));
//	    adopt01.setLotteryresult(1);
//	    adopt01.setLotterydate(Date.valueOf("2023-01-02"));
//	    adopt01.setApplicationstat(0);
//	    adopt01.setApplicantnotes("第一筆備註");
//	    adopt01.setAgreement("第一筆協議書".getBytes());
//	    adopt01.setApplicationdate(Date.valueOf("2023-01-03"));
//	    dao.addApplication(adopt01);
//
//	    // 第二筆假資料
//	    HibernateAdoptedApplicationVO adopt02 = new HibernateAdoptedApplicationVO();
//	    adopt02.setAdminno(102);
//	    adopt02.setMemberno(202);
//	    adopt02.setPetid(302);
//	    adopt02.setInteractiondate(Date.valueOf("2023-01-04"));
//	    adopt02.setLotteryresult(0);
//	    adopt02.setLotterydate(Date.valueOf("2023-01-05"));
//	    adopt02.setApplicationstat(1);
//	    adopt02.setApplicantnotes("第二筆備註");
//	    adopt02.setAgreement("第二筆協議書".getBytes());
//	    adopt02.setApplicationdate(Date.valueOf("2023-01-06"));
//	    dao.addApplication(adopt02);
//
//	    // 第三筆假資料
//	    HibernateAdoptedApplicationVO adopt03 = new HibernateAdoptedApplicationVO();
//	    adopt03.setAdminno(103);
//	    adopt03.setMemberno(203);
//	    adopt03.setPetid(303);
//	    adopt03.setInteractiondate(Date.valueOf("2023-01-07"));
//	    adopt03.setLotteryresult(1);
//	    adopt03.setLotterydate(Date.valueOf("2023-01-08"));
//	    adopt03.setApplicationstat(0);
//	    adopt03.setApplicantnotes("第三筆備註");
//	    adopt03.setAgreement("第三筆協議書".getBytes());
//	    adopt03.setApplicationdate(Date.valueOf("2023-01-09"));
//	    dao.addApplication(adopt03);

//	    HibernateAdoptedApplicationVO adopt04 = new HibernateAdoptedApplicationVO();
//	    adopt04.setApplicationno(200002);
//	    adopt04.setAdminno(101);
//	    adopt04.setMemberno(201);
//	    adopt04.setPetid(301);
//	    adopt04.setInteractiondate(Date.valueOf("2023-02-01"));
//	    adopt04.setLotteryresult(2);
//	    adopt04.setLotterydate(Date.valueOf("2023-02-02"));
//	    adopt04.setApplicationstat(1);
//	    adopt04.setApplicantnotes("更新後的備註");
//	    adopt04.setAgreement("更新後的協議書".getBytes());
//	    adopt04.setApplicationdate(Date.valueOf("2023-02-03"));
//	    dao.updateApplication(adopt04);
//		
		List<HibernateAdoptedApplicationVO> result = dao.findByPetidAndLotterydate(301, Date.valueOf("2023-02-02"));
		for (HibernateAdoptedApplicationVO vo : result) {
		    System.out.println(vo.toString());
		}
		
//		List<HibernateAdoptedApplicationVO> adoptLists = dao.getAll();
//		for (HibernateAdoptedApplicationVO adoptList : adoptLists) {
//			System.out.println(adoptList);
//		}
	}
}
