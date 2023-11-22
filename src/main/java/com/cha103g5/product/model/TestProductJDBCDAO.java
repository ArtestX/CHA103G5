package com.cha103g5.product.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class TestProductJDBCDAO {
	public static void main(String[] args) {

		ProductDAOInterface dao = new ProductJDBCDAO();

		// 新增
//		Product product1 = new Product();
//		product1.setProductCatNo(18);
//		product1.setProductName("棒球");
//		product1.setProductPrice(new BigDecimal("199.99"));
//		product1.setProductInfo("這是棒球的描述");
//		product1.setProductStat(1);
//		product1.setProductEval(4);
//		product1.setProductEvalTotal(10);
//		product1.setProductSaleNum(50);
//		dao.insert(product1);

		// 修改
//		Product product2 = new Product();
//		product2.setProductCatNo(18);
//		product2.setProductName("棒球");
//		product2.setProductPrice(new BigDecimal("199.99"));
//		product2.setProductInfo("這是棒球的描述");
//		product2.setProductStat(1);
//		product2.setProductEval(4);
//		product2.setProductEvalTotal(10);
//		product2.setProductSaleNum(50);
//		dao.update(product2);

		// 刪除
//		dao.delete(10);

		// 查詢單筆
		ProductVO product3 = dao.findByPrimaryKey(1);
		System.out.print(product3.getProductNo() + ",");
		System.out.print(product3.getProductCatNo() + ",");
		System.out.print(product3.getProductName() + ",");
		System.out.print(product3.getProductPrice() + ",");
		System.out.print(product3.getProductInfo() + ",");
		System.out.print(product3.getProductStat() + ",");
		System.out.println(product3.getProductEval()+",");
		System.out.println(product3.getProductEvalTotal()+",");
		System.out.println(product3.getProductSaleNum());
		System.out.println("---------------------");

		// 查詢
		List<ProductVO> list = dao.getAll();
		for (ProductVO productALL : list) {
			System.out.print(productALL.getProductNo() + ",");
			System.out.print(productALL.getProductCatNo() + ",");
			System.out.print(productALL.getProductName() + ",");
			System.out.print(productALL.getProductPrice() + ",");
			System.out.print(productALL.getProductInfo() + ",");
			System.out.print(productALL.getProductStat() + ",");
			System.out.print(productALL.getProductEval() + ",");
			System.out.print(productALL.getProductEvalTotal() + ",");
			System.out.print(productALL.getProductSaleNum());
			System.out.println();
		}

	}
}
