package com.cha103g5.product.model;

import java.util.*;

import com.cha103g5.product.model.Util;

import java.sql.*;

public class ProductJDBCDAO implements ProductDAO {

	private static final String INSERT_STMT = "INSERT INTO product (product_cat_no,product_cat_det_no,product_name,product_price,product_info,product_stat,product_eval,product_eval_total,product_sale_num) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT product_no,product_cat_no,product_cat_det_no,product_name,product_price,product_info,product_stat,product_eval,product_eval_total,product_sale_num FROM product order by product_no";
	private static final String GET_ONE_STMT = "SELECT product_no,product_cat_no,product_cat_det_no,product_name,product_price,product_info,product_stat,product_eval,product_eval_total,product_sale_num FROM product where product_no = ?";
	private static final String DELETE = "DELETE FROM product where product_no = ?";
	private static final String UPDATE = "UPDATE product set product_cat_no=?,product_cat_det_no=?,product_name=?,product_price=?,product_info=?,product_stat=?,product_eval=?,product_eval_total=?,product_sale_num=? where product_no = ?";

	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver." + e.getMessage());
		}
	}

	@Override
	public int insert(Product product) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, product.getProductCatNo());
			pstmt.setInt(2, product.getProductCatDetNo());
			pstmt.setString(3, product.getProductName());
			pstmt.setDouble(4, product.getProductPrice());
			pstmt.setString(5, product.getProductInfo());
			pstmt.setInt(6, product.getProductStat());
			pstmt.setInt(7, product.getProductEval());
			pstmt.setInt(8, product.getProductEvalTotal());
			pstmt.setInt(9, product.getProductSaleNum());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());

		} finally {
			Util.closeResources(con, pstmt, null);
		}
		return 0;
	}

	@Override
	public int update(Product product) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, product.getProductCatNo());
			pstmt.setInt(2, product.getProductCatDetNo());
			pstmt.setString(3, product.getProductName());
			pstmt.setDouble(4, product.getProductPrice());
			pstmt.setString(5, product.getProductInfo());
			pstmt.setInt(6, product.getProductStat());
			pstmt.setInt(7, product.getProductEval());
			pstmt.setInt(8, product.getProductEvalTotal());
			pstmt.setInt(9, product.getProductSaleNum());
			pstmt.setInt(10, product.getProductNo());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			Util.closeResources(con, pstmt, null);
		}
		return 0;
	}

	@Override
	public int delete(Integer productno) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, productno);

			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			Util.closeResources(con, pstmt, null);
		}
		return productno;
	}

	public Product findByPrimaryKey(Integer productno) {

		Product product = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, productno);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				product = new Product();
				product.setProductNo(rs.getInt("product_no"));
				product.setProductCatNo(rs.getInt("product_cat_no"));
				product.setProductCatDetNo(rs.getInt("product_cat_det_no"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getDouble("product_price"));
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
	public List<Product> getAll() {
		List<Product> list = new ArrayList<Product>();
		Product product = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				product = new Product();
				product.setProductNo(rs.getInt("product_no"));
				product.setProductCatNo(rs.getInt("product_cat_no"));
				product.setProductCatDetNo(rs.getInt("product_cat_det_no"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getDouble("product_price"));
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

	public static void main(String[] args) {

		ProductJDBCDAO dao = new ProductJDBCDAO();

		// 新增
		Product productVO1 = new Product();
		productVO1.setProductCatNo(1);
		productVO1.setProductCatDetNo(101);
		productVO1.setProductName("商品1");
		productVO1.setProductPrice(19.99);
		productVO1.setProductInfo("這是商品1的描述");
		productVO1.setProductStat(1);
		productVO1.setProductEval(4);
		productVO1.setProductEvalTotal(10);
		productVO1.setProductSaleNum(50);
		dao.insert(productVO1);

		// 修改
//		EmpVO empVO2 = new EmpVO();
//		empVO2.setEmpno(7001);
//		empVO2.setEname("吳永志2");
//		empVO2.setJob("MANAGER2");
//		empVO2.setHiredate(java.sql.Date.valueOf("2002-01-01"));
//		empVO2.setSal(new Double(20000));
//		empVO2.setComm(new Double(200));
//		empVO2.setDeptno(20);
//		dao.update(empVO2);

		// 刪除
//		dao.delete(7014);

		// 查詢
//		EmpVO empVO3 = dao.findByPrimaryKey(7001);
//		System.out.print(empVO3.getEmpno() + ",");
//		System.out.print(empVO3.getEname() + ",");
//		System.out.print(empVO3.getJob() + ",");
//		System.out.print(empVO3.getHiredate() + ",");
//		System.out.print(empVO3.getSal() + ",");
//		System.out.print(empVO3.getComm() + ",");
//		System.out.println(empVO3.getDeptno());
//		System.out.println("---------------------");

		// 查詢
		List<Product> list = dao.getAll();
		for (Product product : list) {
			System.out.print(product.getProductNo() + ",");
			System.out.print(product.getProductCatNo() + ",");
			System.out.print(product.getProductCatDetNo() + ",");
			System.out.print(product.getProductName() + ",");
			System.out.print(product.getProductPrice() + ",");
			System.out.print(product.getProductInfo() + ",");
			System.out.print(product.getProductStat() + ",");
			System.out.print(product.getProductEval() + ",");
			System.out.print(product.getProductEvalTotal() + ",");
			System.out.print(product.getProductSaleNum());
			System.out.println();
		}

	}

	@Override
	public Product getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByCompositeQuery(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAll(int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}
}
