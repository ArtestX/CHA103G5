package com.cha103g5.product.model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cha103g5.util.Util;

public class ProductJDBCDAO implements ProductDAOInterface {

	private static final String INSERT_STMT = "INSERT INTO product (product_cat_no,product_name,product_price,product_info,product_stat,product_eval,product_eval_total,product_sale_num) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT product_no,product_cat_no,product_name,product_price,product_info,product_stat,product_eval,product_eval_total,product_sale_num FROM product order by product_no";
	private static final String GET_ONE_STMT = "SELECT product_no,product_cat_no,product_name,product_price,product_info,product_stat,product_eval,product_eval_total,product_sale_num FROM product where product_no = ?";
	private static final String DELETE = "DELETE FROM product where product_no = ?";
	private static final String UPDATE = "UPDATE product set product_cat_no=?,product_name=?,product_price=?,product_info=?,product_stat=?,product_eval=?,product_eval_total=?,product_sale_num=? where product_no = ?";

	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver." + e.getMessage());
		}
	}

	@Override
	public void insert(ProductVO product) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = Util.getConnection();
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
			throw new RuntimeException("A database error occured. " + se.getMessage());

		} finally {
			Util.closeResources(con, pstmt, null);
		}
	}

	@Override
	public void update(ProductVO product) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = Util.getConnection();
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
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			Util.closeResources(con, pstmt, null);
		}
	}

	@Override
	public void delete(Integer productno) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = Util.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, productno);

			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			Util.closeResources(con, pstmt, null);
		}
	}

	public ProductVO findByPrimaryKey(Integer productno) {

		ProductVO product = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = Util.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, productno);

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

			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			Util.closeResources(con, pstmt, rs);
		}
		return product;
	}

	@Override
	public List<ProductVO> getAll() {
		List<ProductVO> list = new ArrayList<ProductVO>();
		ProductVO product = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = Util.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
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
				list.add(product); // 將行存儲在列表中

			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			Util.closeResources(con, pstmt, rs);
		}
		return list;
	}

}
