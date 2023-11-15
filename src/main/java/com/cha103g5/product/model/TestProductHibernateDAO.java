package com.cha103g5.product.model;

import java.math.BigDecimal;
import java.util.List;

public class TestProductHibernateDAO {
    public static void main(String[] args) {
        ProductHibernateDAO dao = new ProductHibernateDAO();

        // 新增
//        ProductVO productVO = new ProductVO();
//        productVO.setProductCatNo(10);
//        productVO.setProductName("籃球");
//        productVO.setProductPrice(new BigDecimal("878.99"));
//        productVO.setProductInfo("嘎裡籃球");
//        productVO.setProductStat(1);
//        productVO.setProductEval(4);
//        productVO.setProductEvalTotal(20);
//        productVO.setProductSaleNum(100);
//        dao.insert(productVO);

        // 修改
//		ProductVO productVO2 = new ProductVO();
//		productVO2.setProductCatNo(18);
//		productVO2.setProductName("棒球");
//		productVO2.setProductPrice(new BigDecimal("199.99"));
//		productVO2.setProductInfo("這是棒球的描述");
//		productVO2.setProductStat(1);
//		productVO2.setProductEval(4);
//		productVO2.setProductEvalTotal(10);
//		productVO2.setProductSaleNum(50);
//		dao.update(productVO2);
        

        // 刪除
//		dao.delete(10);

        // 查詢單筆
		ProductVO productVO3 = dao.findByPrimaryKey(2);
		System.out.print(productVO3.getProductNo() + ",");
		System.out.print(productVO3.getProductCatNo() + ",");
		System.out.print(productVO3.getProductName() + ",");
		System.out.print(productVO3.getProductPrice() + ",");
		System.out.print(productVO3.getProductInfo() + ",");
		System.out.print(productVO3.getProductStat() + ",");
		System.out.println(productVO3.getProductEval()+",");
		System.out.println(productVO3.getProductEvalTotal()+",");
		System.out.println(productVO3.getProductSaleNum());
		System.out.println("---------------------");

        // 查詢多筆
		List<ProductVO> list = dao.getAll();
		for (ProductVO productVOALL : list) {
			System.out.print(productVOALL.getProductNo() + ",");
			System.out.print(productVOALL.getProductCatNo() + ",");
			System.out.print(productVOALL.getProductName() + ",");
			System.out.print(productVOALL.getProductPrice() + ",");
			System.out.print(productVOALL.getProductInfo() + ",");
			System.out.print(productVOALL.getProductStat() + ",");
			System.out.print(productVOALL.getProductEval() + ",");
			System.out.print(productVOALL.getProductEvalTotal() + ",");
			System.out.print(productVOALL.getProductSaleNum());
			System.out.println();
		}
    }
}
