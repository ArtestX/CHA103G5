package com.cha103g5.infoann.model;

import java.sql.*;
import java.util.*;
import java.util.Date;


public class InfoAnnJDBCDAO implements InfoAnnDAO_interface{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/g5?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "123456";
	
	private static final String INSERT_STMT= 
			"INSERT INTO informationannouncement(adminno, infocontent, infotitle, infotime) VALUES (?, ?, ?, ?)";
	private static final String UPDATE_STMT = 
			"UPDATE informationannouncement SET adminno = ?, infocontent = ?, infotitle = ?, infotime = ? WHERE infono = ?";
	private static final String DELETE_STMT = 
			"DELETE FROM informationannouncement WHERE infono = ?";
	private static final String FIND_BY_PK = 
			"SELECT * FROM informationannouncement WHERE infono = ?";
	private static final String GET_ALL = 
			"SELECT * FROM informationannouncement";
	
	@Override
	public void insert(InfoAnnVO InfoAnnVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, InfoAnnVO.getAdminno());
			pstmt.setString(2, InfoAnnVO.getInfocontent());
			pstmt.setString(3, InfoAnnVO.getInfotitle());
			pstmt.setTimestamp(4, InfoAnnVO.getInfotime());

			pstmt.executeUpdate();//執行動態指令，不需要參數，已預先交給資料庫

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public void update(InfoAnnVO InfoAnnVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, InfoAnnVO.getAdminno());
			pstmt.setString(2, InfoAnnVO.getInfocontent());
			pstmt.setString(3, InfoAnnVO.getInfotitle());
			pstmt.setTimestamp(4, InfoAnnVO.getInfotime());
			pstmt.setInt(5, InfoAnnVO.getInfono());
			

			pstmt.executeUpdate();//執行動態指令，不需要參數，已預先交給資料庫

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public void delete(Integer infono) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);

			// 1●設定於 pstm.executeUpdate()之前
			con.setAutoCommit(false);

			// 刪除公告
			pstmt = con.prepareStatement(DELETE_STMT);
			pstmt.setInt(1, infono);
			pstmt.executeUpdate();
			
			// 2●設定於 pstm.executeUpdate()之後
			con.commit();
			con.setAutoCommit(true);
			
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			if (con != null) {
				try {
					// 3●設定於當有exception發生時之catch區塊內
					con.rollback();
				} catch (SQLException excep) {
					throw new RuntimeException("rollback error occured. "
							+ excep.getMessage());
				}
			}
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public InfoAnnVO findByPrimaryKey(Integer infono) {
		InfoAnnVO InfoAnnVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(FIND_BY_PK);

			pstmt.setInt(1, infono);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// InfoAnnVO 也稱為 Domain objects
				InfoAnnVO = new InfoAnnVO();
				InfoAnnVO.setInfono(rs.getInt("info_no"));
				InfoAnnVO.setAdminno(rs.getInt("admin_no"));
				InfoAnnVO.setInfocontent(rs.getString("info_content"));
				InfoAnnVO.setInfotitle(rs.getString("info_title"));
				InfoAnnVO.setInfotime(rs.getTimestamp("info_time"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
		return InfoAnnVO;
	}

	@Override
	public List<InfoAnnVO> getAll() {
		List<InfoAnnVO> list = new ArrayList<InfoAnnVO>();
		InfoAnnVO InfoAnnVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				InfoAnnVO = new InfoAnnVO();
				InfoAnnVO.setInfono(rs.getInt("info_no"));
				InfoAnnVO.setAdminno(rs.getInt("admin_no"));
				InfoAnnVO.setInfocontent(rs.getString("info_content"));
				InfoAnnVO.setInfotitle(rs.getString("info_title"));
				InfoAnnVO.setInfotime(rs.getTimestamp("info_time"));
				list.add(InfoAnnVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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

		InfoAnnJDBCDAO dao = new InfoAnnJDBCDAO();
		Date currentTime = new Date();
		Timestamp currentTimestamp = new Timestamp(currentTime.getTime());

		// 新增
//	    InfoAnnVO infoAnnVO1 = new InfoAnnVO();
//	    infoAnnVO1.setAdminNo(8);
//	    infoAnnVO1.setInfoContent("第12筆資料的內容");
//	    infoAnnVO1.setInfoTitle("第12筆資料的標題");
//	    infoAnnVO1.setInfoTime(currentTimestamp);
//		dao.insert(infoAnnVO1);
		
		// 修改
		InfoAnnVO infoAnnVO2= new InfoAnnVO();
		infoAnnVO2.setInfono(12);
	    infoAnnVO2.setAdminno(7);
	    infoAnnVO2.setInfocontent("第12筆資料的內容");
	    infoAnnVO2.setInfotitle("第12筆資料的標題");
	    infoAnnVO2.setInfotime(currentTimestamp);
		dao.update(infoAnnVO2);

		// 刪除
//		dao.delete(11);

		// 查詢單筆公告資訊
		InfoAnnVO infoann3 = dao.findByPrimaryKey(11);
		System.out.print(infoann3.getInfono() + ",");
		System.out.print(infoann3.getAdminno() + ",");
		System.out.println(infoann3.getInfocontent());
		System.out.println(infoann3.getInfotitle());
		System.out.println(infoann3.getInfotime());
		System.out.println("---------------------");

		// 查詢公告資訊總明細
		List<InfoAnnVO> list = dao.getAll();
		for (InfoAnnVO infoann : list) {
			System.out.print(infoann.getInfono() + ",");
			System.out.print(infoann.getAdminno() + ",");
			System.out.println(infoann.getInfocontent());
			System.out.println(infoann.getInfotitle());
			System.out.println(infoann.getInfotime());
			System.out.println();
		}
		
	}
}
