package com.cha103g5.admin.model.original;

import java.sql.Timestamp;
import java.util.List;

//public class TestAdminHibernateDAO {
//    public static void main(String[] args) {
//        AdminHibernateDAOInterface dao = new AdminHibernateDAO_Original();
//
//        // 新增
//        AdminVO adminVO = new AdminVO();
//        adminVO.setAdminAccount("TTT");
//        adminVO.setAdminPassword("TTT");
//        adminVO.setAdminName("GGYY");
//        adminVO.setCreateDate(Timestamp.valueOf("2023-10-12 14:30:45"));
//        adminVO.setAdminStat(1);
//        adminVO.setAdminEmail("ggyy@gmail.com");
//        adminVO.setAdminPhone("098759487");
//        dao.insert(adminVO);
//
//		// 修改
////        AdminVO adminVO2 = new AdminVO();
////        adminVO2.setAdminNo(40032);
////        adminVO2.setAdminAccount("ABCD");
////        adminVO2.setAdminPassword("23456");
////        adminVO2.setAdminName("59487");
////        adminVO2.setCreateDate(Timestamp.valueOf("2023-10-12 14:30:45"));
////        adminVO2.setAdminEmail("OOOOOMG@gmail.com");
////        adminVO2.setAdminPhone("666887936");
////        adminVO2.setAdminStat(2);
////        dao.update(adminVO2);
//
//		// 刪除
////		dao.delete(12);
//
//		// 查詢單筆
////		AdminVO adminVO3 = dao.findByPrimaryKey(40011);
////		System.out.print(adminVO3.getAdminNo() + ",");
////		System.out.print(adminVO3.getAdminAccount() + ",");
////		System.out.print(adminVO3.getAdminPassword() + ",");
////		System.out.print(adminVO3.getAdminName() + ",");
////		System.out.print(adminVO3.getCreateDate() + ",");
////		System.out.print(adminVO3.getAdminStat() + ",");
////		System.out.print(adminVO3.getAdminEmail()+ ",");
////		System.out.print(adminVO3.getAdminPhone());
////		System.out.println("---------------------");
//
//		// 查詢多筆
//        List<AdminVO> list = dao.getAll();
//    	for (AdminVO adminVOALL : list) {
//            System.out.print(adminVOALL.getAdminNo() + ",");
//            System.out.print(adminVOALL.getAdminAccount() + ",");
//            System.out.print(adminVOALL.getAdminPassword() + ",");
//            System.out.print(adminVOALL.getAdminName() + ",");
//            System.out.print(adminVOALL.getCreateDate() + ",");
//            System.out.print(adminVOALL.getAdminStat() + ",");
//            System.out.print(adminVOALL.getAdminEmail() + ",");
//            System.out.print(adminVOALL.getAdminPhone());
//            System.out.println();
//        }
//    }
//}
