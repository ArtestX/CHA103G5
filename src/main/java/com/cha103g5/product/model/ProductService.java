package com.cha103g5.product.model;

import java.math.BigDecimal;
import java.util.List;

public class ProductService {

	private ProductDAOInterface dao;

	public ProductService() {

		dao = new ProductJNDIDAO();
	}

	public ProductVO updateProduct(
			Integer productNo, 
			String productName, 
			BigDecimal productPrice, 
			String productInfo,
			Integer productStat, 
			Integer productEval, 
			Integer productEvalTotal, 
			Integer productSaleNum) {

		ProductVO product = new ProductVO();
		product.setProductNo(productNo);
		product.setProductName(productName);
		product.setProductPrice(productPrice);
		product.setProductInfo(productInfo);
		product.setProductStat(productStat);
		product.setProductEval(productEval);
		product.setProductEvalTotal(productEvalTotal);
		product.setProductSaleNum(productSaleNum);
		dao.update(product);
		return dao.findByPrimaryKey(productNo);
	}
	
	// 預留給 Struts 2 用的
//	    public void updateProduct(Product product) {
//	        dao.update(product);
//	    }

	public ProductVO addProduct(
			Integer productNo, 
			String productName, 
			BigDecimal productPrice, 
			String productInfo,
			Integer productStat, 
			Integer productEval, 
			Integer productEvalTotal, 
			Integer productSaleNum){

		ProductVO product = new ProductVO();
		product.setProductNo(productNo);
		product.setProductName(productName);
		product.setProductPrice(productPrice);
		product.setProductInfo(productInfo);
		product.setProductStat(productStat);
		product.setProductEval(productEval);
		product.setProductEvalTotal(productEvalTotal);
		product.setProductSaleNum(productSaleNum);
		dao.insert(product);
		return product;
	}
	
    //預留給 Struts 2 用的
//  public void updateAdmin(AdminVO adminVO) {
//      dao.update(adminVO);
//  }

	public void deleteProduct(Integer productNo) {
		 dao.delete(productNo);
	}

	public ProductVO getOneProduct(Integer productNo) {
		return dao.findByPrimaryKey(productNo);
	}
	
	public List<ProductVO> getAll(){
		return dao.getAll();
	}

}
