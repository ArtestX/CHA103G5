package com.cha103g5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import util.Util;

public class PetJDBCDAO implements PetDAO_interface {
	private static final String INSERT_STMT = "INSERT INTO pet (petid,pettype,memberno,petname,petsex,petage,petnote,stat,applicationdeadline) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT petid,pettype,memberno,petname,petsex,petage,petnote,stat,applicationdeadline FROM admin order by admin_no";
	private static final String GET_ONE_STMT = "SELECT petid,pettype,memberno,petname,petsex,petage,petnote,stat,applicationdeadline FROM admin where admin_no = ?";
	private static final String DELETE = "DELETE FROM pet where petid = ?";
	private static final String UPDATE = "UPDATE admin set petid=?, pettype=?, memberno=?, petname=? petsex=? petage=? petnote=? stat=? applicationdeadline=? where petid = ?";

	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver." + e.getMessage());
		}
	}

	@Override
	public void insert(PetVO petVO) {
		Connection con = null;
        PreparedStatement pstmt = null;
		
        try {
            con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
            pstmt = con.prepareStatement(INSERT_STMT);

            

            pstmt.executeUpdate();

        } catch (SQLException se) {
            throw new RuntimeException("Database error occurred."
                    + se.getMessage());
        } finally {
            Util.closeResources(con, pstmt, null);
        }
	}

	@Override
	public void update(PetVO petVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(PetVO petVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PetVO findByPrimaryKey(Integer petid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PetVO> getALL() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
