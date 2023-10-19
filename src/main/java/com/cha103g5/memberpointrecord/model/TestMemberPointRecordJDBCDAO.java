package com.cha103g5.memberpointrecord.model;

import java.util.List;

public class TestMemberPointRecordJDBCDAO {

	public static void main(String[] args) {
		
		MemberPointRecordJDBCDAO dao = new MemberPointRecordJDBCDAO();

		// 新增
//		MbrPointRecordVO MbrPointRecordVO1 = new MbrPointRecordVO();
//		MbrPointRecordVO1.setMemberno(7);
//		MbrPointRecordVO1.setGetpointtime(java.sql.Timestamp.valueOf("2023-11-9 12:39:23"));
//		MbrPointRecordVO1.setGetpoint(100);
//		MbrPointRecordVO1.setGetpointreason("會員註冊獲得");
//		dao.insert(MbrPointRecordVO1);
//
//		// 修改
//		MbrPointRecordVO MbrPointRecordVO2 = new MbrPointRecordVO();
//		MbrPointRecordVO2.setMemberpointno(11);
//		MbrPointRecordVO2.setMemberno(4);
//		MbrPointRecordVO2.setGetpointtime(java.sql.Timestamp.valueOf("2023-11-9 12:39:23"));
//		MbrPointRecordVO2.setGetpoint(50);
//		MbrPointRecordVO2.setGetpointreason("會員註冊獲得");
//		dao.update(MbrPointRecordVO2);

//		// 用會員編號查詢該會員的所有點數獲得紀錄
//		List<MbrPointRecordVO> list = dao.findBymemberNo(4);
//		for (MbrPointRecordVO  MbrPointRecord : list) {
//			System.out.print(MbrPointRecord.getMemberno() + ",");
//			System.out.println(MbrPointRecord.getGetpointtime());
//			System.out.println("獲得點數:"+ MbrPointRecord.getGetpoint());
//			System.out.println("獲得原因:"+ MbrPointRecord.getGetpointreason());
//			System.out.println();
//		}

		// 用會員名字查詢該會員的所有點數獲得紀錄
//		List<MbrPointRecordVO> list2 = dao.findBymemberName("Daniel Kim");
//		for (MbrPointRecordVO  MbrPointRecord : list2) {
//			System.out.print(MbrPointRecord.getMemberno() + ",");
//			System.out.println(MbrPointRecord.getGetpointtime());
//			System.out.println("獲得點數:"+ MbrPointRecord.getGetpoint());
//			System.out.println("獲得原因:"+ MbrPointRecord.getGetpointreason());
//			System.out.println();
//		}
		
		// 用時間查詢點數獲得紀錄
//		List<MbrPointRecordVO> list3 = dao.findBygetPointTime(java.sql.Timestamp.valueOf("2023-10-07 00:00:00"), java.sql.Timestamp.valueOf("2023-10-09 00:00:00"));
//		for (MbrPointRecordVO  MbrPointRecord : list3) {
//			System.out.print(MbrPointRecord.getMemberno() + ",");
//			System.out.println(MbrPointRecord.getGetpointtime());
//			System.out.println("獲得點數:"+ MbrPointRecord.getGetpoint());
//			System.out.println("獲得原因:"+ MbrPointRecord.getGetpointreason());
//			System.out.println();
//		}
		
		
//		// 查詢多筆
		List<MemberPointRecordVO> list = dao.getAll();
		for (MemberPointRecordVO MbrPointRecord : list) {
			System.out.print(MbrPointRecord.getMemberpointno() + ",");
			System.out.print(MbrPointRecord.getMemberno() + ",");
			System.out.print(MbrPointRecord.getGetpointtime() + ",");
			System.out.print(MbrPointRecord.getGetpoint() + ",");
			System.out.print(MbrPointRecord.getGetpointreason() + ",");
			System.out.println();
		}
	}

}
