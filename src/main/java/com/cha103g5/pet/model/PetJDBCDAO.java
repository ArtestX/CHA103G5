package com.cha103g5.pet.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetJDBCDAO implements PetDAOinterface {
	private static final String INSERT_STMT = "INSERT INTO pet (petid,pettype,memberno,petname,petsex,petage,petnote,stat,applicationdeadline) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT petid,pettype,memberno,petname,petsex,petage,petnote,stat,applicationdeadline FROM pet order by petid";
	private static final String GET_ONE_STMT = "SELECT petid,pettype,memberno,petname,petsex,petage,petnote,stat,applicationdeadline FROM pet where petid = ?";
	private static final String DELETE = "DELETE FROM pet where petid = ?";
	private static final String UPDATE = "UPDATE pet set petid=?, pettype=?, memberno=?, petname=?, petsex=?, petage=?, petnote=?, stat=?, applicationdeadline=? where petid = ?";

	static {
		try {
			Class.forName(util.DRIVER);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver." + e.getMessage());
		}
	}

	@Override
	public void insert(PetVO petVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(util.URL, util.USER, util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			
			pstmt.setInt(1, petVO.getPetid());
			pstmt.setInt(2, petVO.getPettype());
			pstmt.setInt(3, petVO.getMemberno());
			pstmt.setString(4, petVO.getPetname());
			pstmt.setString(5, petVO.getPetsex());
			pstmt.setString(6, petVO.getPetage());
			pstmt.setString(7, petVO.getPetnote());
			pstmt.setByte(8, petVO.getStat());
			pstmt.setDate(9, petVO.getApplicationdeadline());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("Database error occurred." + se.getMessage());
		} finally {
			util.closeResources(con, pstmt, null);
		}
	}

	@Override
    public void update(PetVO petVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DriverManager.getConnection(util.URL, util.USER, util.PASSWORD);
            pstmt = con.prepareStatement(UPDATE);

            pstmt.setInt(1, petVO.getPettype());
            pstmt.setInt(2, petVO.getMemberno());
            pstmt.setString(3, petVO.getPetname());
            pstmt.setString(4, petVO.getPetsex());
            pstmt.setString(5, petVO.getPetage());
            pstmt.setString(6, petVO.getPetnote());
            pstmt.setByte(7, petVO.getStat());

            // 轉換 java.util.Date 為 java.sql.Date
            java.util.Date utilDate = petVO.getApplicationdeadline();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            pstmt.setDate(8, sqlDate);

            pstmt.setInt(9, petVO.getPetid());

            pstmt.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("Database error occurred: " + se.getMessage());
        } finally {
            util.closeResources(con, pstmt, null);
        }
    }

    @Override
    public void delete(PetVO petVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DriverManager.getConnection(util.URL, util.USER, util.PASSWORD);
            pstmt = con.prepareStatement(DELETE);

            pstmt.setInt(1, petVO.getPetid());

            pstmt.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("Database error occurred: " + se.getMessage());
        } finally {
            util.closeResources(con, pstmt, null);
        }
    }

    @Override
    public PetVO findByPrimaryKey(Integer petid) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PetVO petVO = null;

        try {
            con = DriverManager.getConnection(util.URL, util.USER, util.PASSWORD);
            pstmt = con.prepareStatement(GET_ONE_STMT);
            pstmt.setInt(1, petid);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                petVO = new PetVO();
                petVO.setPetid(rs.getInt("petid"));
                petVO.setPettype(rs.getInt("pettype"));
                petVO.setMemberno(rs.getInt("memberno"));
                petVO.setPetname(rs.getString("petname"));
                petVO.setPetsex(rs.getString("petsex"));
                petVO.setPetage(rs.getString("petage"));
                petVO.setPetnote(rs.getString("petnote"));
                petVO.setStat(rs.getByte("stat"));
                petVO.setApplicationdeadline(rs.getDate("applicationdeadline"));
            }
        } catch (SQLException se) {
            throw new RuntimeException("Database error occurred: " + se.getMessage());
        } finally {
            util.closeResources(con, pstmt, rs);
        }

        return petVO;
    }

    @Override
    public List<PetVO> getALL() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<PetVO> petList = new ArrayList<>();

        try {
            con = DriverManager.getConnection(util.URL, util.USER, util.PASSWORD);
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                PetVO petVO = new PetVO();
                petVO.setPetid(rs.getInt("petid"));
                petVO.setPettype(rs.getInt("pettype"));
                petVO.setMemberno(rs.getInt("memberno"));
                petVO.setPetname(rs.getString("petname"));
                petVO.setPetsex(rs.getString("petsex"));
                petVO.setPetage(rs.getString("petage"));
                petVO.setPetnote(rs.getString("petnote"));
                petVO.setStat(rs.getByte("stat"));
                petVO.setApplicationdeadline(rs.getDate("applicationdeadline"));
                petList.add(petVO);
            }
        } catch (SQLException se) {
            throw new RuntimeException("Database error occurred: " + se.getMessage());
        } finally {
            util.closeResources(con, pstmt, rs);
        }

        return petList;
    }

}
