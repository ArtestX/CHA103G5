package com.cha103g5.adoptedapplication.model;

import com.cha103g5.util.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;


public class AdoptedapplicationDAOImpl implements AdoptedapplicationDAO{
	public static final String INSERT_STMT =
		    "insert into adoptedapplication"
		    + "(adminno, memberno, petid, interactiondate, lotteryresult, lotterydate, applicationstat, applicantnotes, agreement, applicationdate)"
		    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String UPDATE_STMT =
		    "update adoptedapplication set adminno=?, memberno=?, petid=?, interactiondate=?, lotteryresult=?, lotterydate=?, applicationstat=?, applicantnotes=?, agreement=?, applicationdate=?"
		    + "where applicationno=?";
//	public static final String DELETE_STMT = "delete from adoptedapplication where applicationno = ?";
	public static final String SELECT_BY_PETID_AND_LOTTERYDATE = "SELECT * FROM adoptedapplication WHERE petid = ? AND lotterydate = ?";
	public static final String GET_ALL = "select * from adoptedapplication order by petid, lotterydate desc";
	
	@Override
	public void insert(AdoptedapplicationVO adoptedapplicationVO) {
		Connection con= null;
		PreparedStatement pstmt = null;
		
		try {
	        con = Util.getConnection();
	        pstmt = con.prepareStatement(INSERT_STMT);
	        
//	        pstmt.setInt(1, adoptedapplicationVO.getApplicationno());
	        pstmt.setInt(1, adoptedapplicationVO.getAdminno());
	        pstmt.setInt(2, adoptedapplicationVO.getMemberno());
	        pstmt.setInt(3, adoptedapplicationVO.getPetid());
	        pstmt.setDate(4, new java.sql.Date(adoptedapplicationVO.getInteractiondate().getTime()));
	        pstmt.setInt(5, adoptedapplicationVO.getLotteryresult());
	        pstmt.setDate(6, new java.sql.Date(adoptedapplicationVO.getLotterydate().getTime()));
	        pstmt.setInt(7, adoptedapplicationVO.getApplicationstat());
	        pstmt.setString(8, adoptedapplicationVO.getApplicantnotes());
	        pstmt.setBytes(9, adoptedapplicationVO.getAgreement());
	        pstmt.setDate(10, new java.sql.Date(adoptedapplicationVO.getApplicationdate().getTime()));
	        
	        pstmt.executeUpdate();
	        System.out.println("新增資料成功");
	        
		} catch (SQLException se ) {
			se.printStackTrace();
		} finally {
			Util.closeResources(con, pstmt, null);
	    }
	}
	
	@Override
	public void update(AdoptedapplicationVO adoptedapplicationVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
		    con = Util.getConnection();
		    pstmt = con.prepareStatement(UPDATE_STMT);
		    
		    pstmt.setInt(1, adoptedapplicationVO.getAdminno());
		    pstmt.setInt(2, adoptedapplicationVO.getMemberno());
		    pstmt.setInt(3, adoptedapplicationVO.getPetid());
		    pstmt.setDate(4, new java.sql.Date(adoptedapplicationVO.getInteractiondate().getTime()));
		    pstmt.setInt(5, adoptedapplicationVO.getLotteryresult());
		    pstmt.setDate(6, new java.sql.Date(adoptedapplicationVO.getLotterydate().getTime()));
		    pstmt.setInt(7, adoptedapplicationVO.getApplicationstat());
		    pstmt.setString(8, adoptedapplicationVO.getApplicantnotes());
		    pstmt.setBytes(9, adoptedapplicationVO.getAgreement());
		    pstmt.setDate(10, new java.sql.Date(adoptedapplicationVO.getApplicationdate().getTime()));
		    
		    pstmt.setInt(11, adoptedapplicationVO.getApplicationno());

		    pstmt.executeUpdate();
		    System.out.println("更新資料成功");
		    
		} catch (SQLException se) {
		    se.printStackTrace();
		} finally {
		    Util.closeResources(con, pstmt, null);
		}
	}
	
//	@Override
//	public void delete(Integer applicationno) {
//		Connection con = null;
//	    PreparedStatement pstmt = null;
//	    
//	    try {
//	        con = Util.getConnection();
//	        pstmt = con.prepareStatement(DELETE_STMT);
//	        
//	        pstmt.setInt(1, applicationno);
//
//	        pstmt.executeUpdate();
//	        System.out.println("刪除資料成功");
//	        
//	    } catch (SQLException se) {
//	        se.printStackTrace();
//	    } finally {
//	        Util.closeResources(con, pstmt, null);
//	    }
//	}
	
	@Override
	public List<AdoptedapplicationVO> findByPetidAndLotterydate(Integer petid, Date lotterydate) {

		Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    List<AdoptedapplicationVO> list = new ArrayList<>();

		    try {
		        con = Util.getConnection();
		        pstmt = con.prepareStatement(SELECT_BY_PETID_AND_LOTTERYDATE);

		        pstmt.setInt(1, petid);
		        pstmt.setDate(2, new java.sql.Date(lotterydate.getTime()));
		        rs = pstmt.executeQuery();

		        while (rs.next()) {
		            AdoptedapplicationVO adoptedapplicationVO = new AdoptedapplicationVO();
		            adoptedapplicationVO.setApplicationno(rs.getInt("applicationno"));
		            adoptedapplicationVO.setAdminno(rs.getInt("adminno"));
		            adoptedapplicationVO.setMemberno(rs.getInt("memberno"));
		            adoptedapplicationVO.setPetid(rs.getInt("petid"));
		            adoptedapplicationVO.setInteractiondate(rs.getDate("interactiondate"));
		            adoptedapplicationVO.setLotteryresult(rs.getInt("lotteryresult"));
		            adoptedapplicationVO.setLotterydate(rs.getDate("lotterydate"));
		            adoptedapplicationVO.setApplicationstat(rs.getInt("applicationstat"));
		            adoptedapplicationVO.setApplicantnotes(rs.getString("applicantnotes"));
		            adoptedapplicationVO.setAgreement(rs.getBytes("agreement"));
		            adoptedapplicationVO.setApplicationdate(rs.getDate("applicationdate"));
		            list.add(adoptedapplicationVO);
		        }

		        System.out.println("寵物編號 " + petid + " 的抽籤結果查找成功");

		    } catch (SQLException se) {
		        se.printStackTrace();
		    } finally {
		        Util.closeResources(con, pstmt, rs);
		    }

		    return list;
	}
	
	@Override
	public List<AdoptedapplicationVO> getAll() {
		List<AdoptedapplicationVO> list = new ArrayList<AdoptedapplicationVO>();
	    AdoptedapplicationVO adoptedapplicationVO = null;
	    
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	        con = Util.getConnection();
	        pstmt = con.prepareStatement(GET_ALL);
	        rs = pstmt.executeQuery();
	        
	        while (rs.next()) {
	            adoptedapplicationVO = new AdoptedapplicationVO();
	            adoptedapplicationVO.setApplicationno(rs.getInt("applicationno"));
	            adoptedapplicationVO.setAdminno(rs.getInt("adminno"));
	            adoptedapplicationVO.setMemberno(rs.getInt("memberno"));
	            adoptedapplicationVO.setPetid(rs.getInt("petid"));
	            adoptedapplicationVO.setInteractiondate(rs.getDate("interactiondate"));
	            adoptedapplicationVO.setLotteryresult(rs.getInt("lotteryresult"));
	            adoptedapplicationVO.setLotterydate(rs.getDate("lotterydate"));
	            adoptedapplicationVO.setApplicationstat(rs.getInt("applicationstat"));
	            adoptedapplicationVO.setApplicantnotes(rs.getString("applicantnotes"));
	            adoptedapplicationVO.setAgreement(rs.getBytes("agreement"));
	            adoptedapplicationVO.setApplicationdate(rs.getDate("applicationdate"));
	            list.add(adoptedapplicationVO);
	        }
	        
	    } catch (SQLException se) {
	        se.printStackTrace();
	    } finally {
	        Util.closeResources(con, pstmt, rs);
	    }
	    return list;
	}
}
