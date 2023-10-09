package com.cha103g5.csimg.model;


import java.util.List;

public class TestCSImgJDBCDAO {
    public static void main(String[] args) {
        CSImgDAO_interface dao = new CSImgJDBCDAO();

        // 新增
        CSImgVO csImgVO = new CSImgVO();
        csImgVO.setPictureNo(11);
        csImgVO.setRecordNo(11);
//        csImgVO.setPicture(byte[]);
        dao.insert(csImgVO);


		// 查詢單筆
//		CSImgVO csImgVO3 = dao.findByPrimaryKey(1);
//        System.out.print(csImgVO3.getPictureNo() + ",");
//        System.out.print(csImgVO3.getRecordNo() + ",");
//		System.out.print(csImgVO3.getPicture() + ",");
//		System.out.println("---------------------");

		// 查詢多筆
//        List<CSImgVO> list = dao.getAll();
//    	for (CSImgVO csImgVOALL : list) {
//            System.out.print(csImgVOALL.getPictureNo() + ",");
//            System.out.print(csImgVOALL.getRecordNo() + ",");
//            System.out.print(csImgVOALL.getPicture() + ",");
//            System.out.println();
//        }
    }
}
