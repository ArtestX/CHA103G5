package com.cha103g5.admin.controller;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.http.*;

import com.cha103g5.admin.model.AdminVO;
import com.cha103g5.admin.service.AdminService;

import javax.servlet.annotation.WebServlet;


public class AdminLoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	   //【檢查使用者輸入的帳號(account) 密碼(password)是否有效】
	   //【實際上應至資料庫搜尋比對】
	protected boolean allowUser(String adminAccount, String adminPassword) {
	    AdminService adminService = new AdminService();
	    AdminVO adminVO = adminService.userAuth(adminAccount, adminPassword);

	    if (adminVO != null) {
	        return true; // 找到匹配的管理员记录
	    } else {
	        return false; // 未找到匹配的管理员记录
	    }
	}

	  public void doPost(HttpServletRequest req, HttpServletResponse res)
	                                throws ServletException, IOException {
	    req.setCharacterEncoding("UTF-8");
	    res.setContentType("text/html; charset=UTF-8");
	    
	    
	    // 【取得使用者 帳號(account) 密碼(password)】
	    String adminAccount = req.getParameter("adminAccount").trim();
	    String adminPassword = req.getParameter("adminPassword").trim();
	    
	    Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
        req.setAttribute("errorMsgs", errorMsgs);
        
	    /***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
        String adminAccountReg = "[a-zA-Z0-9_]+";
        String adminAccoutReg2 = "^[(a-zA-Z0-9_)]{6,12}$";
        if (adminAccount == null || adminAccount.trim().length() == 0) {
            errorMsgs.put("adminAccount", "帳號請勿空白");
        } else if (!adminAccount.trim().matches(adminAccountReg)) {
            errorMsgs.put("adminAccount", "只能是英文、數字和_");
        } else if (!adminAccount.trim().matches(adminAccoutReg2)) {
            errorMsgs.put("adminAccount", "長度需在6到12之間");
        }

        String adminPasswordReg = "^[a-zA-Z0-9!@]+$";
        String adminPasswordReg2 = "^[a-zA-Z0-9!@]{8,16}$";
        if (adminPassword == null || adminPassword.length() == 0) {
            errorMsgs.put("adminPassword", "密碼請勿空白");
        } else if (!adminPassword.matches(adminPasswordReg)) {
            errorMsgs.put("adminPassword", "只能是英文、數字、@、!");
        } else if (!adminPassword.matches(adminPasswordReg2)) {
            errorMsgs.put("adminPassword", "長度需在8到16之間");
        }

        // Send the use back to the form, if there were errors
        if (!errorMsgs.isEmpty()) {
            RequestDispatcher failureView = req
                    .getRequestDispatcher("/admin/adminLogin.jsp");
            failureView.forward(req, res);
            return;
        }
        
	    // 【檢查該帳號 , 密碼是否有效】
	    if (!allowUser(adminAccount, adminPassword)) {          //【帳號 , 密碼無效時】
	    	  errorMsgs.put("adminAccount", "查無資料");
	          errorMsgs.put("adminPassword", "密碼錯誤");
	    }
	    
	    // Send the use back to the form, if there were errors
        if (!errorMsgs.isEmpty()) {
            RequestDispatcher failureView = req
                    .getRequestDispatcher("/admin/adminLogin.jsp"); // admin/selectPage.jsp
            failureView.forward(req, res);
            return;//程式中斷
        }
	    
        /***************************3.查詢完成,準備轉交(Send the Success view)*************/
	      HttpSession session = req.getSession();  //【帳號 , 密碼有效時, 才做以下工作】
	      session.setAttribute("adminAccount", adminAccount);   //*工作1: 才在session內做已經登入過的標識
	      
	       try {                                                        
	         String location = (String) session.getAttribute("location");
	         if (location != null) {
	           session.removeAttribute("location");   //*工作2: 看看有無來源網頁 (-->如有來源網頁:則重導至來源網頁)
	           res.sendRedirect(location);            
	           return;
	         }
	       }catch (Exception ignored) { }
	       System.out.println("OK");
	       res.sendRedirect(req.getContextPath()+"/admin/backendMain.jsp");  //*工作3: (-->如無來源網頁:則重導至login_success.jsp)
	    }
	    
}