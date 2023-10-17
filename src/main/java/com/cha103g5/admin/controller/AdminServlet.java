package com.cha103g5.admin.controller;

import com.cha103g5.admin.model.AdminService;
import com.cha103g5.admin.model.AdminVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;

public class AdminServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");


        if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
            String str = req.getParameter("adminNo");
            if (str == null || (str.trim()).length() == 0) {
                errorMsgs.put("adminNo", "請輸入員工編號");
            }
            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/admin/selectPage.jsp");
                failureView.forward(req, res);
                return;//程式中斷
            }

            Integer adminNo = null;
            try {
                adminNo = Integer.valueOf(str);
            } catch (Exception e) {
                errorMsgs.put("adminNo", "員工編號格式不正確");
            }
            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/admin/selectPage.jsp");
                failureView.forward(req, res);
                return;//程式中斷
            }

            /***************************2.開始查詢資料*****************************************/
            AdminService adminSvc = new AdminService();
            AdminVO adminVO = adminSvc.getOneAdmin(adminNo);
            if (adminVO == null) {
                errorMsgs.put("adminNo", "查無資料");
            }
            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/admin/selectPage.jsp");
                failureView.forward(req, res);
                return;//程式中斷
            }

            /***************************3.查詢完成,準備轉交(Send the Success view)*************/
            req.setAttribute("AdminVO", adminVO); // 資料庫取出的AdminVO物件,存入req
            String url = "/admin/listOneAdmin.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneAdmin.jsp
            successView.forward(req, res);
        }


        if ("getOne_For_Update".equals(action)) { // 來自listAllAdmin.jsp的請求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數****************************************/
            Integer adminNo = Integer.valueOf(req.getParameter("adminNo"));

            /***************************2.開始查詢資料****************************************/
            AdminService adminSvc = new AdminService();
            AdminVO adminVO = adminSvc.getOneAdmin(adminNo);

            /***************************3.查詢完成,準備轉交(Send the Success view)************/
            String param = "?adminNo=" + adminVO.getAdminNo() +
                    "&adminAccount=" + adminVO.getAdminAccount() +
                    "&adminPassword=" + adminVO.getAdminPassword() +
                    "&adminName=" + adminVO.getAdminName() +
                    "&createDate=" + adminVO.getCreateDate() +
                    "&adminStat=" + adminVO.getAdminStat() +
                    "&adminEmail=" + adminVO.getAdminEmail() +
                    "&adminPhone=" + adminVO.getAdminPhone();

            String url = "/admin/updateAdmin.jsp" + param;
            RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 updateAdmin.jsp
            successView.forward(req, res);
        }


        if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
            String adminName = req.getParameter("adminName");
            String adminNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
            if (adminName == null || adminName.trim().length() == 0) {
                errorMsgs.put("adminName", "員工姓名: 請勿空白");
            } else if (!adminName.trim().matches(adminNameReg)) { //以下練習正則(規)表示式(regular-expression)
                errorMsgs.put("adminName", "員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
            }

            Integer adminNo = null;
            try {
                adminNo = Integer.valueOf(req.getParameter("adminNo").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("adminNo", "員工編號請填數字");
            }

            String adminAccount = req.getParameter("adminAccount").trim();
            if (adminAccount == null || adminAccount.trim().length() == 0) {
                errorMsgs.put("adminAccount", "帳號請勿空白");
            }

            String adminPassword = req.getParameter("adminPassword").trim();
            if (adminPassword == null || adminPassword.trim().length() == 0) {
                errorMsgs.put("adminPassword", "密碼請勿空白");
            }

            Timestamp createDate = null;
            try {
                createDate = Timestamp.valueOf(req.getParameter("createDate").trim());
            } catch (IllegalArgumentException e) {
                errorMsgs.put("createDate", "請輸入日期");
            }

            Integer adminStat = null;
            try {
                adminStat = Integer.valueOf(req.getParameter("adminStat").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("adminStat", "狀態請填數字");
            }

            String adminEmail = req.getParameter("adminEmail").trim();
            if (adminEmail == null || adminEmail.trim().length() == 0) {
                errorMsgs.put("adminEmail", "信箱請勿空白");
            }

            String adminPhone = req.getParameter("adminPhone").trim();
            if (adminPhone == null || adminPhone.trim().length() == 0) {
                errorMsgs.put("adminPhone", "電話請勿空白");
            }


            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/admin/updateAdmin.jsp");
                failureView.forward(req, res);
                return; //程式中斷
            }

            /***************************2.開始修改資料*****************************************/
            AdminService adminSvc = new AdminService();
            AdminVO adminVO = adminSvc.updateAdmin(adminNo,adminAccount,adminPassword,adminName,createDate,adminStat, adminEmail,adminPhone);

            /***************************3.修改完成,準備轉交(Send the Success view)*************/
            req.setAttribute("AdminVO", adminVO); // 資料庫update成功後,正確的的AdminVO物件,存入req
            String url = "/admin/listOneAdmin.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneAdmin.jsp
            successView.forward(req, res);
        }

        if ("insert".equals(action)) { // 來自addAdmin.jsp的請求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
            String adminName = req.getParameter("adminName");
            String adminNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
            if (adminName == null || adminName.trim().length() == 0) {
                errorMsgs.put("adminName", "員工姓名: 請勿空白");
            } else if (!adminName.trim().matches(adminNameReg)) { //以下練習正則(規)表示式(regular-expression)
                errorMsgs.put("adminName", "員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
            }

            Integer adminNo = null;
            try {
                adminNo = Integer.valueOf(req.getParameter("adminNo").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("adminNo", "員工編號請填數字");
            }

            String adminAccount = req.getParameter("adminAccount").trim();
            if (adminAccount == null || adminAccount.trim().length() == 0) {
                errorMsgs.put("adminAccount", "帳號請勿空白");
            }

            String adminPassword = req.getParameter("adminPassword").trim();
            if (adminPassword == null || adminPassword.trim().length() == 0) {
                errorMsgs.put("adminPassword", "密碼請勿空白");
            }

            Timestamp createDate = null;
            try {
                createDate = Timestamp.valueOf(req.getParameter("createDate").trim());
            } catch (IllegalArgumentException e) {
                errorMsgs.put("createDate", "請輸入日期");
            }

            Integer adminStat = null;
            try {
                adminStat = Integer.valueOf(req.getParameter("adminStat").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("adminStat", "狀態請填數字");
            }

            String adminEmail = req.getParameter("adminEmail").trim();
            if (adminEmail == null || adminEmail.trim().length() == 0) {
                errorMsgs.put("adminEmail", "信箱請勿空白");
            }

            String adminPhone = req.getParameter("adminPhone").trim();
            if (adminPhone == null || adminPhone.trim().length() == 0) {
                errorMsgs.put("adminPhone", "電話請勿空白");
            }


            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/admin/addAdmin.jsp");
                failureView.forward(req, res);
                return;
            }

            /***************************2.開始新增資料***************************************/
            AdminService adminSvc = new AdminService();
            adminSvc.addAdmin(adminNo,adminAccount, adminPassword, adminName, createDate, adminStat, adminEmail, adminPhone);

            /***************************3.新增完成,準備轉交(Send the Success view)***********/
            String url = "/admin/listAllAdmin.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllAdmin.jsp
            successView.forward(req, res);
        }


        if ("delete".equals(action)) { // 來自listAllAdmin.jsp

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數***************************************/
            Integer adminNo = Integer.valueOf(req.getParameter("adminNo"));

            /***************************2.開始刪除資料***************************************/
            AdminService adminSvc = new AdminService();
            adminSvc.deleteAdmin(adminNo);

            /***************************3.刪除完成,準備轉交(Send the Success view)***********/
            String url = "/admin/listAllAdmin.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
            successView.forward(req, res);
        }
    }
}