package com.cha103g5.permissionfunc.model;

import java.util.List;

public class TestPmsFuncJDBCDAO {
    public static void main(String[] args) {
        PmsFuncDAOInterface dao = new PmsFuncJDBCDAO();

        // 新增
//        PmsFuncVO pmsFuncVO = new PmsFuncVO();
//        pmsFuncVO.setPmsNo(11);
//        pmsFuncVO.setPmsName("XXX");
//        pmsFuncVO.setPmsDes("XXX");
//        dao.insert(pmsFuncVO);

		// 修改
//        PmsFuncVO pmsFuncVO1 = new PmsFuncVO();
//        pmsFuncVO1.setPmsNo(11);
//        pmsFuncVO1.setPmsName("ZZZ");
//        pmsFuncVO1.setPmsDes("ZZZ");
//        dao.update(pmsFuncVO1);

		// 刪除
//		dao.delete(11);

		// 查詢單筆
//		PmsFuncVO pmsFuncVO3 = dao.findByPrimaryKey(11);
//		System.out.print(pmsFuncVO3.getPmsNo() + ",");
//		System.out.print(pmsFuncVO3.getPmsName() + ",");
//		System.out.print(pmsFuncVO3.getPmsDes() + ",");


		// 查詢多筆
        List<PmsFuncVO> list = dao.getAll();
    	for (PmsFuncVO pmsFuncVOALL : list) {
            System.out.print(pmsFuncVOALL.getPmsNo() + ",");
            System.out.print(pmsFuncVOALL.getPmsName() + ",");
            System.out.print(pmsFuncVOALL.getPmsDes() + ",");
            System.out.println();
        }
    }
}
