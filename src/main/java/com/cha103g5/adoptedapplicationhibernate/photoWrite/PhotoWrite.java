package com.cha103g5.adoptedapplicationhibernate.photoWrite;

import java.sql.*;
import java.io.*;

class PhotoWrite {

	public static void main(String args[]) {
		Connection con = null;
		PreparedStatement pstmt = null;
		InputStream fin = null;
		String url = "jdbc:mysql://localhost:3306/g5?serverTimezone=Asia/Taipei";
		String userid = "root";
		String passwd = "123456";
		String photos = "src/main/webapp/adoptedapplicationhibernate/images/DB_photos";
		String update = "UPDATE adoptedapplication SET signaturephoto =? WHERE applicationno=?";

		int count = 1;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(update);
			File[] photoFiles = new File(photos).listFiles();
			for (File f : photoFiles) {
				fin = new FileInputStream(f);
				pstmt = con.prepareStatement(update);
				pstmt.setInt(2, count);
				pstmt.setBinaryStream(1, fin);
				pstmt.executeUpdate();
				count++;
				System.out.print(" update the database...");
				System.out.println(f.toString());
			}

			fin.close();
			pstmt.close();
			System.out.println("加入圖片-更新成功.........");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
