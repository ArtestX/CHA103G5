package com.product;

import java.util.*;
import java.sql.*;

public class ProductJDBCDAO implements ProductDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/yourdatabasename?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "0616";

	private static final String INSERT_STMT = "INSERT INTO product (product_cat_no,product_cat_det_no,product_name,product_price,product_info,product_stat,product_eval,product_eval_total,product_sale_num) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT product_no,product_cat_no,product_cat_det_no,product_name,product_price,product_info,product_stat,product_eval,product_eval_total,product_sale_num FROM product order by product_no";
	private static final String GET_ONE_STMT = "SELECT product_no,product_cat_no,product_cat_det_no,product_name,product_price,product_info,product_stat,product_eval,product_eval_total,product_sale_num FROM product where product_no = ?";
	private static final String DELETE = "DELETE FROM product where product_no = ?";
	private static final String UPDATE = "UPDATE product set product_cat_no=?,product_cat_det_no=?,product_name=?,product_price=?,product_info=?,product_stat=?,product_eval=?,product_eval_total=?,product_sale_num=? where product_no = ?";

	@Override
	public void insert(ProductVO productVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, productVO.getProductCatNo());
			pstmt.setInt(2, productVO.getProductCatDetNo());
			pstmt.setString(3, productVO.getProductName());
			pstmt.setDouble(4, productVO.getProductPrice());
			pstmt.setString(5, productVO.getProductInfo());
			pstmt.setInt(6, productVO.getProductStat());
			pstmt.setInt(7, productVO.getProductEval());
			pstmt.setInt(8, productVO.getProductEvalTotal());
			pstmt.setInt(9, productVO.getProductSaleNum());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(ProductVO productVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, productVO.getProductCatNo());
			pstmt.setInt(2, productVO.getProductCatDetNo());
			pstmt.setString(3, productVO.getProductName());
			pstmt.setDouble(4, productVO.getProductPrice());
			pstmt.setString(5, productVO.getProductInfo());
			pstmt.setInt(6, productVO.getProductStat());
			pstmt.setInt(7, productVO.getProductEval());
			pstmt.setInt(8, productVO.getProductEvalTotal());
			pstmt.setInt(9, productVO.getProductSaleNum());
			pstmt.setInt(10, productVO.getProductNo());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(Integer productno) { 

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, productno);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public ProductVO findByPrimaryKey(Integer productno) {

		ProductVO productVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, productno);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				productVO = new ProductVO();
				productVO.setProductNo(rs.getInt("product_no"));
				productVO.setProductCatNo(rs.getInt("product_cat_no"));
				productVO.setProductCatDetNo(rs.getInt("product_cat_det_no"));
				productVO.setProductName(rs.getString("product_name"));
				productVO.setProductPrice(rs.getDouble("product_price"));
				productVO.setProductInfo(rs.getString("product_info"));
				productVO.setProductStat(rs.getInt("product_stat"));
				productVO.setProductEval(rs.getInt("product_eval"));
				productVO.setProductEvalTotal(rs.getInt("product_eval_total"));
				productVO.setProductSaleNum(rs.getInt("product_sale_num"));

			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return productVO;
	}

	@Override
	public List<ProductVO> getAll() {
		List<ProductVO> list = new ArrayList<ProductVO>();
		ProductVO productVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				productVO  = new ProductVO();
				productVO.setProductNo(rs.getInt("product_no"));
				productVO.setProductCatNo(rs.getInt("product_cat_no"));
				productVO.setProductCatDetNo(rs.getInt("product_cat_det_no"));
				productVO.setProductName(rs.getString("product_name"));
				productVO.setProductPrice(rs.getDouble("product_price"));
				productVO.setProductInfo(rs.getString("product_info"));
				productVO.setProductStat(rs.getInt("product_stat"));
				productVO.setProductEval(rs.getInt("product_eval"));
				productVO.setProductEvalTotal(rs.getInt("product_eval_total"));
				productVO.setProductSaleNum(rs.getInt("product_sale_num"));
				list.add(productVO); // 將行存儲在列表中

			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {

		ProductJDBCDAO dao = new ProductJDBCDAO();

		// 新增
		ProductVO productVO1 = new ProductVO();
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
		List<ProductVO> list = dao.getAll();
		for (ProductVO productVO : list) {
			System.out.print(productVO.getProductNo() + ",");
			System.out.print(productVO.getProductCatNo() + ",");
			System.out.print(productVO.getProductCatDetNo() + ",");
			System.out.print(productVO.getProductName() + ",");
			System.out.print(productVO.getProductPrice() + ",");
			System.out.print(productVO.getProductInfo() + ",");
			System.out.print(productVO.getProductStat() + ",");
			System.out.print(productVO.getProductEval() + ",");
			System.out.print(productVO.getProductEvalTotal() + ",");
			System.out.print(productVO.getProductSaleNum());
			System.out.println();
		}

	}
}
