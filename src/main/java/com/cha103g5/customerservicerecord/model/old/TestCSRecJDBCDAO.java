//package com.cha103g5.customerservicerecord.model.old;
//
//
//import java.util.List;
//import lombok.Data;
//
//public class TestCSRecJDBCDAO {
//    public static void main(String[] args) {
//        CSRecDAOInterface dao = new CSRecJDBCDAO();
//
//        // 新增
////        CSRecVO csRecVO = new CSRecVO();
////        csRecVO.setRecordNo(11);
////        csRecVO.setMemberNo(12);
////        csRecVO.setAdminNo(17);
////        csRecVO.setRecordTime(java.sql.Date.valueOf("2023-10-08"));
////        csRecVO.setInteractionContent("GGYY");
//////        csRecVO.setAttachments(byte[]);
////        csRecVO.setTalkDirection(1);
////        dao.insert(csRecVO);
//
//
//		// 查詢單筆
////		CSRecVO csRecVO3 = dao.findByPrimaryKey(10);
////		System.out.print(csRecVO3.getRecordNo() + ",");
////		System.out.print(csRecVO3.getMemberNo() + ",");
////		System.out.print(csRecVO3.getAdminNo() + ",");
////		System.out.print(csRecVO3.getRecordTime() + ",");
////		System.out.print(csRecVO3.getInteractionContent() + ",");
////		System.out.print(csRecVO3.getAttachments() + ",");
////		System.out.print(csRecVO3.getTalkDirection() + ",");
////		System.out.println("---------------------");
//
//		// 查詢多筆
//        List<CSRecVO> list = dao.getAll();
//    	for (CSRecVO csRecVOALL : list) {
////            System.out.print(csRecVOALL.getRecordNo() + ",");
////            System.out.print(csRecVOALL.getMemberNo() + ",");
////            System.out.print(csRecVOALL.getAdminNo() + ",");;
////            System.out.print(csRecVOALL.getRecordTime() + ",");
////            System.out.print(csRecVOALL.getInteractionContent() + ",");
////            System.out.print(csRecVOALL.getTalkDirection() + ",");
////            System.out.println();
//        }
//    }
//}
