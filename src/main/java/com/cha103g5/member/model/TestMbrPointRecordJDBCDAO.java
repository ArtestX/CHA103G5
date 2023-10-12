package com.cha103g5.member.model;

import java.util.List;

public class TestMbrPointRecordJDBCDAO {

	public static void main(String[] args) {
		
		MbrPointRecordJDBCDAO dao = new MbrPointRecordJDBCDAO();

		// 新增
//		MbrPointRecordVO MbrPointRecordVO1 = new MbrPointRecordVO();
//		MbrPointRecordVO1.setMemberNo(7);
//		MbrPointRecordVO1.setGetPointTime(java.sql.Timestamp.valueOf("2023-11-9 12:39:23"));
//		MbrPointRecordVO1.setGetPoint(100);
//		MbrPointRecordVO1.setGetPointReason("會員註冊獲得");
//		dao.insert(MbrPointRecordVO1);
//
//		// 修改
//		MbrPointRecordVO MbrPointRecordVO2 = new MbrPointRecordVO();
//		MbrPointRecordVO2.setMemberPointNo(11);
//		MbrPointRecordVO2.setMemberNo(4);
//		MbrPointRecordVO2.setGetPointTime(java.sql.Timestamp.valueOf("2023-11-9 12:39:23"));
//		MbrPointRecordVO2.setGetPoint(50);
//		MbrPointRecordVO2.setGetPointReason("會員註冊獲得");
//		dao.update(MbrPointRecordVO2);

//		// 用會員編號查詢該會員的所有點數獲得紀錄
//		List<MbrPointRecordVO> list = dao.findBymemberNo(4);
//		for (MbrPointRecordVO  MbrPointRecord : list) {
//			System.out.print(MbrPointRecord.getMemberNo() + ",");
//			System.out.println(MbrPointRecord.getGetPointTime());
//			System.out.println("獲得點數:"+ MbrPointRecord.getGetPoint());
//			System.out.println("獲得原因:"+ MbrPointRecord.getGetPointReason());
//			System.out.println();
//		}

		// 用會員名字查詢該會員的所有點數獲得紀錄
//		List<MbrPointRecordVO> list2 = dao.findBymemberName("Daniel Kim");
//		for (MbrPointRecordVO  MbrPointRecord : list2) {
//			System.out.print(MbrPointRecord.getMemberNo() + ",");
//			System.out.println(MbrPointRecord.getGetPointTime());
//			System.out.println("獲得點數:"+ MbrPointRecord.getGetPoint());
//			System.out.println("獲得原因:"+ MbrPointRecord.getGetPointReason());
//			System.out.println();
//		}
		
		// 用時間查詢點數獲得紀錄
//		List<MbrPointRecordVO> list3 = dao.findBygetPointTime(java.sql.Timestamp.valueOf("2023-10-07 00:00:00"), java.sql.Timestamp.valueOf("2023-10-09 00:00:00"));
//		for (MbrPointRecordVO  MbrPointRecord : list3) {
//			System.out.print(MbrPointRecord.getMemberNo() + ",");
//			System.out.println(MbrPointRecord.getGetPointTime());
//			System.out.println("獲得點數:"+ MbrPointRecord.getGetPoint());
//			System.out.println("獲得原因:"+ MbrPointRecord.getGetPointReason());
//			System.out.println();
//		}
		
		
//		// 查詢多筆
		List<MbrPointRecordVO> list = dao.getAll();
		for (MbrPointRecordVO MbrPointRecord : list) {
			System.out.print(MbrPointRecord.getMemberPointNo() + ",");
			System.out.print(MbrPointRecord.getMemberNo() + ",");
			System.out.print(MbrPointRecord.getGetPointTime() + ",");
			System.out.print(MbrPointRecord.getGetPoint() + ",");
			System.out.print(MbrPointRecord.getGetPointReason() + ",");
			System.out.println();
		}
	}

}
