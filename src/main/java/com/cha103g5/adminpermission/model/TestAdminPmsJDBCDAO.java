package com.cha103g5.adminpermission.model;

import java.util.List;


public class TestAdminPmsJDBCDAO {
    public static void main(String[] args) {
        AdminPmsDAOInterface dao = new AdminPmsJDBCDAO();

        // 新增
//        AdminPmsVO adminPmsVO = new AdminPmsVO();
//        adminPmsVO.setAdminPmsNo(11);
//        adminPmsVO.setPmsNo(222);
//        adminPmsVO.setAdminNo(333);
//        dao.insert(adminPmsVO);


		// 查詢單筆
//		AdminPmsVO adminPmsVO3 = dao.findByPrimaryKey(11);
//		System.out.print(adminPmsVO3.getAdminPmsNo() + ",");
//		System.out.print(adminPmsVO3.getPmsNo() + ",");
//		System.out.print(adminPmsVO3.getAdminNo() + ",");

		// 查詢多筆
        List<AdminPmsVO> list = dao.getAll();
    	for (AdminPmsVO adminPmsVOALL : list) {
            System.out.print(adminPmsVOALL.getAdminPmsNo() + ",");
            System.out.print(adminPmsVOALL.getPmsNo() + ",");
            System.out.print(adminPmsVOALL.getAdminNo() + ",");
            System.out.println();
        }
    }
}
