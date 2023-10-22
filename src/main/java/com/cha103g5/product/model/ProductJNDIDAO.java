package com.cha103g5.product.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.cha103g5.util.HibernateUtil;
import com.cha103g5.util.Util;

public class ProductJNDIDAO implements ProductDAOInterface {

	private static DataSource ds = null;

	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB2");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	// 請確保以下 SQL 查詢語句與你的資料庫結構相符
	private static final String INSERT_STMT = "INSERT INTO product (product_cat_no, product_name, product_price, product_info, product_stat, product_eval, product_eval_total, product_sale_num) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT product_no, product_cat_no, product_name, product_price, product_info, product_stat, product_eval, product_eval_total, product_sale_num FROM product order by product_no";
	private static final String GET_ONE_STMT = "SELECT product_no, product_cat_no, product_name, product_price, product_info, product_stat, product_eval, product_eval_total, product_sale_num FROM product where product_no = ?";
	private static final String DELETE = "DELETE FROM product where product_no = ?";
	private static final String UPDATE = "UPDATE product set product_cat_no=?, product_name=?, product_price=?, product_info=?, product_stat=?, product_eval=?, product_eval_total=?, product_sale_num=? where product_no = ?";

	@Override
	public void insert(ProductVO product) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, product.getProductCatNo());
			pstmt.setString(2, product.getProductName());
			pstmt.setBigDecimal(3, product.getProductPrice());
			pstmt.setString(4, product.getProductInfo());
			pstmt.setInt(5, product.getProductStat());
			pstmt.setInt(6, product.getProductEval());
			pstmt.setInt(7, product.getProductEvalTotal());
			pstmt.setInt(8, product.getProductSaleNum());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("Database error occurred: " + se.getMessage());
		} finally {
			Util.closeResources(con, pstmt, null);
		}
	}

	@Override
	public void update(ProductVO product) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setInt(1, product.getProductCatNo());
			pstmt.setString(2, product.getProductName());
			pstmt.setBigDecimal(3, product.getProductPrice());
			pstmt.setString(4, product.getProductInfo());
			pstmt.setInt(5, product.getProductStat());
			pstmt.setInt(6, product.getProductEval());
			pstmt.setInt(7, product.getProductEvalTotal());
			pstmt.setInt(8, product.getProductSaleNum());

			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("Database error occurred: " + se.getMessage());
		} finally {
			Util.closeResources(con, pstmt, null);
		}
	}

	@Override
	public void delete(Integer productNo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, productNo);
			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("Database error occurred: " + se.getMessage());
		} finally {
			Util.closeResources(con, pstmt, null);
		}
	}

	
	@Override
	public ProductVO findByPrimaryKey(Integer productNo) {
		ProductVO product = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, productNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				product = new ProductVO();
				product.setProductNo(rs.getInt("product_no"));
				product.setProductCatNo(rs.getInt("product_cat_no"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getBigDecimal("product_price"));
				product.setProductInfo(rs.getString("product_info"));
				product.setProductStat(rs.getInt("product_stat"));
				product.setProductEval(rs.getInt("product_eval"));
				product.setProductEvalTotal(rs.getInt("product_eval_total"));
				product.setProductSaleNum(rs.getInt("product_sale_num"));
			}

		} catch (SQLException se) {
			throw new RuntimeException("Database error occurred: " + se.getMessage());
		} finally {
			Util.closeResources(con, pstmt, rs);
		}

		return product;
	}
	
	
	@Override
	public List<ProductVO> getAll() {
		List<ProductVO> productList = new ArrayList<ProductVO>();
		ProductVO product = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				product = new ProductVO();
				product.setProductNo(rs.getInt("product_no"));
				product.setProductCatNo(rs.getInt("product_cat_no"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getBigDecimal("product_price"));
				product.setProductInfo(rs.getString("product_info"));
				product.setProductStat(rs.getInt("product_stat"));
				product.setProductEval(rs.getInt("product_eval"));
				product.setProductEvalTotal(rs.getInt("product_eval_total"));
				product.setProductSaleNum(rs.getInt("product_sale_num"));
				productList.add(product);
			}

		} catch (SQLException se) {
			throw new RuntimeException("Database error occurred: " + se.getMessage());
		} finally {
			Util.closeResources(con, pstmt, rs);
		}

		return productList;
	}


}
