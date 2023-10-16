package com.cha103g5.member.controller;

import java.io.*;
import java.sql.*;
import java.text.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.commons.io.IOUtils;

import com.cha103g5.member.service.MemberService;
import java.util.*;

public class MemberServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
			
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				String memberaccount = req.getParameter("memberaccount").trim();
				String maccountReg = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d_-]{6,20}$";
				if (memberaccount == null || memberaccount.trim().length() == 0) {
					errorMsgs.put("memberaccount","會員帳號: 請勿空白");
				} else if(!memberaccount.trim().matches(maccountReg)) {
					errorMsgs.put("memberaccount","會員帳號: 只能是英文字母、數字、_(下底線)和-(連字符) , 且長度必需在6到20之間");
	            } 
				
				String membername = req.getParameter("membername").trim();
				String mnameReg = "^[\\u4e00-\\u9fa5a-zA-Z0-9_\\s]{2,20}$"; // \s是包含空格的意思
				if (membername == null || membername.trim().length() == 0) {
					errorMsgs.put("membername","會員姓名: 請勿空白");
				} else if(!membername.trim().matches(mnameReg)) { 
					errorMsgs.put("membername","會員姓名: 只能是中、英文字母和_(可含空格) , 且長度必需在2到20之間");
	            }

				Integer membergender = Integer.valueOf(req.getParameter("membergender").trim());
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/emp/addEmp.jsp");
					failureView.forward(req, res);
					return;
				}
				
				String memberpassword = req.getParameter("memberpassword");
				String mpasswordReg = "^(?![\\s])(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,20}$";
				if (memberpassword == null || memberpassword.trim().length() == 0) {
					errorMsgs.put("memberpassword","會員密碼: 請勿空白");
				} else if(!memberpassword.trim().matches(mpasswordReg)) { 
					errorMsgs.put("memberpassword","會員密碼: 只能是英文字母(沒區分大小寫)、數字和不能有空格 , 且長度必需在8到20之間");
	            }
				
				String memberphone = req.getParameter("memberphone");
				String mphoneReg = "^09[0-9]{8}$";
				if(!memberphone.trim().matches(mphoneReg)) { 
					errorMsgs.put("memberphone","不符合手機號碼格式");
	            }
				
				String memberemail = req.getParameter("memberemail");
				String memailReg = "^[A-Za-z0-9+_.-]+@(.+)$";
				if(!memberemail.trim().matches(memailReg)) { 
					errorMsgs.put("memberemail","不符合信箱格式");
	            }
				
				String memberaddress = req.getParameter("memberaddress").trim();
				
				Timestamp memberjointime = null;
				try {
				    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				    java.util.Date parsedDate = dateFormat.parse(req.getParameter("memberjointime"));
				    memberjointime = new Timestamp(parsedDate.getTime());
				} catch (ParseException e) {
				    errorMsgs.put("memberjointime", "日期格式無效");
				}
				
				java.sql.Date memberbirthday = null;
				try {
					memberbirthday = java.sql.Date.valueOf(req.getParameter("memberbirthday").trim());
				} catch (IllegalArgumentException e) {
					errorMsgs.put("memberbirthday","請輸入日期");
				}
				
				String membernation = req.getParameter("membernation").trim();
			
				Part part = req.getPart("memberpic");
				var inputstream = part.getInputStream();
				byte[] memberpic = IOUtils.toByteArray(inputstream);
		 
				
				String membercard = req.getParameter("membercard").trim();
				String mcardReg = "^[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}$";
				if(!membercard.trim().matches(mcardReg)) { 
					errorMsgs.put("membercard","不符合信用卡格式");
	            }
				
				Integer memberpoints = Integer.valueOf(req.getParameter("memberpoints").trim());
				
				Integer memberstat = Integer.valueOf( req.getParameter("memberstat").trim());
				
				String memberid = req.getParameter("memberid").trim();
				String midReg= "^[A-Za-z][1-2]\\d{8}$";
				if(!memberid.trim().matches(midReg)) { 
					errorMsgs.put("memberid","不符合身分證格式");
				}
				
				String memberjob = req.getParameter("memberjob").trim();
				if (memberjob == null || memberjob.trim().length() == 0) {
					errorMsgs.put("memberjob","職位請勿空白");
				}
//				
				Integer membersal = Integer.valueOf(req.getParameter("membersal").trim());
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/emp/addEmp.jsp");
					failureView.forward(req, res);
					return;
				}
				
//				/***************************2.開始新增資料***************************************/
			
					MemberService MemberService = new MemberService();
					MemberService.addMember(memberaccount, membername, membergender, memberpassword,
							memberphone, memberemail, memberaddress, memberjointime,
							memberbirthday, membernation, memberpic, membercard, memberpoints,
							memberstat, memberid, memberjob, membersal);
		
//				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/emp/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
		 
		}
	}
}

