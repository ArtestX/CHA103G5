package com.cha103g5.pet.model;

import java.sql.Date;
import java.util.List;




public class TestPetHibernateDAO {

	public static void main(String[] args) {
		PetHibernateDAOinterface dao = new PetHibernateDAO(null);

		// 新增
//		PetVO petVO = new PetVO();
//		petVO.setPettype(1); // 設定寵物類型
//		petVO.setMemberno(2); // 設定會員編號
//		petVO.setPetname("Fluffy"); // 設定寵物名稱
//		petVO.setPetsex("公"); // 設定寵物性別
//		petVO.setPetage("3"); // 設定寵物年齡
//		petVO.setPetnote("A cute pet"); // 設定寵物備註
//		petVO.setStat((byte) 1); // 設定寵物狀態
//		petVO.setApplicationdeadline(new Date(System.currentTimeMillis())); // 設定申請截止日期
//		dao.insert(petVO);

//        //修改
//        PetVO petVO2 = new PetVO();
//        petVO2.setPetid(11);
//        petVO2.setPettype(2);
//        petVO2.setMemberno(1);
//        petVO2.setPetname("David");
//        petVO2.setPetsex("母");
//        petVO2.setPetage("2");
//        petVO2.setPetnote("已接種三合一");
//        petVO2.setStat((byte)3);
//        petVO2.setApplicationdeadline(new Date(System.currentTimeMillis()));
//        dao.update(petVO2);

//        //刪除
//        dao.delete(11);

		// 單筆查詢
//		PetVO petVO3 = dao.findByPrimaryKey(12);
//		System.out.print(petVO3.getPetid() + ",");
//		System.out.print(petVO3.getPettype() + ",");
//		System.out.print(petVO3.getMemberno() + ",");
//		System.out.print(petVO3.getPetname() + ",");
//		System.out.print(petVO3.getPetsex() + ",");
//		System.out.print(petVO3.getPetage() + ",");
//		System.out.print(petVO3.getPetnote() + ",");
//		System.out.print(petVO3.getStat());
//		System.out.print(petVO3.getApplicationdeadline());
//		System.out.println("---------------------");
		
		// 多筆查詢
		List<PetVO> list = dao.getAll();
		for (PetVO petVOALL : list) {
			System.out.print(petVOALL.getPetid() + ",");
			System.out.print(petVOALL.getPettype() + ",");
			System.out.print(petVOALL.getMemberno() + ",");
			System.out.print(petVOALL.getPetname() + ",");
			System.out.print(petVOALL.getPetsex() + ",");
			System.out.print(petVOALL.getPetage() + ",");
			System.out.print(petVOALL.getPetnote() + ",");
			System.out.print(petVOALL.getStat() + ",");
			System.out.print(petVOALL.getApplicationdeadline() + ",");
			System.out.println();
		}

	}

}
