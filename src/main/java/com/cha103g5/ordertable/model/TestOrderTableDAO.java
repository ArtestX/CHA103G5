//package com.cha103g5.ordertable.model;
//
//import java.math.BigDecimal;
//import java.sql.Timestamp;
//import java.util.List;
//
//public class TestOrderTableDAO {
//	public static void main(String[] args) {
//		OrderTableDAO ordertableDAO = new OrderTableDAOImpl();
//
//		// 新增
////		OrderTable order1 = new OrderTable();
////		order1.setMemberNo(1);
////		order1.setOrderTime(new Timestamp(System.currentTimeMillis()));
////		order1.setOrderTotal(new BigDecimal("19.99"));
////		order1.setOrderPointsTotal(0);
////		order1.setOrderSalePrice(new BigDecimal("1.00"));
////		order1.setOrderStat(4);
////		order1.setShipStat(20);
////		order1.setPaymentStat(1);
////		order1.setPaymentMethod("Credit Card");
////		order1.setCreditCard("1234-5678-9012-3456");
////		order1.setRemitAccount("9876-5432-1098-7654");
////		order1.setPointUsedOrder(0);
////		order1.setShipMethod("Express");
////		order1.setOrderAddress("123 Main St, City");
////		order1.setShipName("John Doe");
////		int newOrderId = ordertableDAO.insert(order1);
////		System.out.println("新增的訂單ID：" + newOrderId);
//
//		// 修改
////		OrderTable order2 = ordertableDAO.getById(1); // 使用新建的訂單ID
////		if (order2 != null) {
////			order2.setOrderTime(new Timestamp(System.currentTimeMillis()));
////			order2.setOrderTotal(new BigDecimal("29.99"));
////			order2.setOrderPointsTotal(5);
////			order2.setOrderSalePrice(new BigDecimal("2.00"));
////			order2.setOrderStat(5);
////			order2.setShipStat(25);
////			order2.setPaymentStat(2);
////			order2.setPaymentMethod("Remit");
////			order2.setCreditCard("");
////			order2.setRemitAccount("1234-5678-9012-3456");
////			order2.setPointUsedOrder(10);
////			order2.setShipMethod("Standard");
////			order2.setShipName("Jane Smith");
////			ordertableDAO.update(order2);
////			System.out.println("已更新訂單：" + order2);
////		}
//
//		// 刪除
////		int ordertableIdToDelete = 2; // Replace 2 with the ID of the product you want to delete
////		ordertableDAO.delete(ordertableIdToDelete);
////
////		// 查詢單筆
////		int ordertableIdToQuery = 3; // Replace 3 with the ID of the product you want to retrieve
////		OrderTable retrievedProduct = ordertableDAO.getById(ordertableIdToQuery);
////		if (retrievedProduct != null) {
////			System.out.println(retrievedProduct);
////		} else {
////			System.out.println("Product not found.");
////		}
//
//		// 查詢多筆
//		List<OrderTable> ordertables = ordertableDAO.getAll();
//		for (OrderTable ordertable : ordertables) {
//			System.out.println(ordertable);
//		}
//	}
//}
