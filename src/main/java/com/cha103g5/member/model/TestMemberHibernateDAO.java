package com.cha103g5.member.model;

import java.util.List;

public class TestMemberHibernateDAO {
	
	public static void main(String[] args) throws Exception {
		MemberDAOinterface dao = new MemberHibernateDAO();

//		// 新增
//		Emp emp1 = new Emp();
//		emp1.setEname("David");
//		emp1.setJob("MANAGER");
//		emp1.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse("2016-08-07"));
//		emp1.setSal(new BigDecimal(50000));
//		emp1.setComm(new BigDecimal(500));
//		emp1.setEmpdeptno(10);
//		dao.add(emp1);
//
//		// 修改
//		Emp emp2 = new Emp();
//		emp2.setEmpno(7001);
//		emp2.setEname("David Jr.");
//		emp2.setJob("MANAGER2");
//		emp2.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse("2016-08-07"));
//		emp2.setSal(new BigDecimal(20000));
//		emp2.setComm(new BigDecimal(200));
//		emp2.setEmpdeptno(20);
//		dao.update(emp2);
//
//		// 刪除
//		dao.delete(7015);
//
//		// 查詢單筆
//		Emp emp3 = dao.findByPK(7001);
//		System.out.print(emp3.getEmpno() + ",");
//		System.out.print(emp3.getEname() + ",");
//		System.out.print(emp3.getJob() + ",");
//		System.out.print(emp3.getHiredate() + ",");
//		System.out.print(emp3.getSal() + ",");
//		System.out.print(emp3.getComm() + ",");
//		System.out.println(emp3.getEmpdeptno());
//		System.out.println("---------------------");

		// 查詢多筆
		List<MemberVO> list = dao.getAll();
		for (MemberVO MbrVO : list) {
			System.out.print(MbrVO.getMemberno() + ",");
			System.out.print(MbrVO.getMemberaccount() + ",");
			System.out.print(MbrVO.getMembername() + ",");
			System.out.print(MbrVO.getMembergender() + ",");
			System.out.print(MbrVO.getMemberpassword() + ",");
			System.out.print(MbrVO.getMemberphone() + ",");
			System.out.print(MbrVO.getMemberemail());
			System.out.print(MbrVO.getMemberaddress() + ",");
			System.out.print(MbrVO.getMemberjointime() + ",");
			System.out.print(MbrVO.getMemberbirthday() + ",");
			System.out.print(MbrVO.getMembernation() + ",");
			System.out.print(MbrVO.getMemberpic() + ",");
			System.out.print(MbrVO.getMembercard() + ",");
			System.out.print(MbrVO.getMemberpoints());
			System.out.print(MbrVO.getMemberstat() + ",");
			System.out.print(MbrVO.getMemberid() + ",");
			System.out.print(MbrVO.getMemberjob() + ",");
			System.out.print(MbrVO.getMembersal() + ",");
			System.out.println();
		}
	}
}
