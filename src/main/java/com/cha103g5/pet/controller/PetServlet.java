package com.cha103g5.pet.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cha103g5.pet.model.PetService;
import com.cha103g5.pet.model.*;

@WebServlet("/pet/pet.do")
public class PetServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("petid");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.put("petid", "請輸入寵物編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/pet/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer petid = null;
			try {
				petid = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.put("petid", "寵物編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/pet/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			PetService petSvc = new PetService();
			PetVO petVO = petSvc.getOnePet(petid);
			if (petVO == null) {
				errorMsgs.put("petid", "查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/pet/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("PetVO", petVO); // 資料庫取出的PetVO物件,存入req
			String url = "/pet/listOnePet.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOnePet.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllPet.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer petid = Integer.valueOf(req.getParameter("petid"));

			/*************************** 2.開始查詢資料 ****************************************/
			PetService petSvc = new PetService();
			PetVO petVO = petSvc.getOnePet(petid);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			String param = "?petid=" + petVO.getPetid() + "&animaltypeno=" + petVO.getAnimaltypeno() + "&memberno="
					+ petVO.getMemberno() + "&petname=" + petVO.getPetname() + "&petsex=" + petVO.getPetsex()
					+ "&petage=" + petVO.getPetage() + "&petnote=" + petVO.getPetnote() + "&stat=" + petVO.getStat()
					+ "&applicationdeadline" + petVO.getApplicationdeadline();

			String url = "/pet/updatePet.jsp" + param;
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 updatePet.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自updatePet.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer petid = Integer.valueOf(req.getParameter("petid").trim());

			Integer animaltypeno = Integer.valueOf(req.getParameter("animaltypeno").trim());

			Integer memberno = null;
			try {
				memberno = Integer.valueOf(req.getParameter("memberno").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("member", "會員編號請填數字.");
			}
			String petname = req.getParameter("petname");
			String petnameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (petname == null || petname.trim().length() == 0) {
				errorMsgs.put("petname", "寵物名稱: 請勿空白");
			} else if (!petname.trim().matches(petnameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.put("petname", "寵物名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

			String petsex = String.valueOf(req.getParameter("petsex"));

			String petage = req.getParameter("petage");
			String petageReg = "^[(0-9)]{1,2}$";
			if (petage == null || petage.trim().length() == 0) {
				errorMsgs.put("petage", "寵物年齡: 請勿空白");
			} else if (!petage.trim().matches(petageReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.put("petage", "寵物年齡: 只能是數字,且長度必需在1到2之間");
			}

			String petnote = req.getParameter("petnote");

			Byte stat = Byte.valueOf(req.getParameter("stat"));

			java.sql.Date applicationdeadline = null;
			try {
				applicationdeadline = java.sql.Date.valueOf(req.getParameter("applicationdeadline").trim());
			} catch (IllegalArgumentException e) {
				applicationdeadline = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.put("applicationdeadline", "請輸入日期!");
			}

			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/pet/updatePet.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			PetService petSvc = new PetService();
			PetVO petVO = petSvc.updatePet(petid, animaltypeno, memberno, petname, petsex, petage, petnote, stat,
					applicationdeadline);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("PetVO", petVO); // 資料庫update成功後,正確的的PetVO物件,存入req
			String url = "/pet/listOnePet.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOnePet.jsp
			successView.forward(req, res);
		}
//
		if ("insert".equals(action)) { // 來自addPet.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			Integer animaltypeno = Integer.valueOf(req.getParameter("animaltypeno").trim());

			Integer memberno = null;
			try {
				memberno = Integer.valueOf(req.getParameter("memberno").trim());
			} catch (NumberFormatException e) {
				memberno = 1;
				errorMsgs.put("memberno", "會員編號請填數字.");
			}

			String petname = req.getParameter("petname");
			String petnameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (petname == null || petname.trim().length() == 0) {
				errorMsgs.put("petname", "寵物名稱: 請勿空白");
			} else if (!petname.trim().matches(petnameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.put("petname", "寵物名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

			String petsex = String.valueOf(req.getParameter("petsex"));

			String petage = req.getParameter("petage");
			String petageReg = "^[(0-9)]{1,2}$";
			if (petage == null || petage.trim().length() == 0) {
				errorMsgs.put("petage", "寵物年齡: 請勿空白");
			} else if (!petage.trim().matches(petageReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.put("petage", "寵物年齡: 只能是數字,且長度必需在1到2之間");
			}

			String petnote = req.getParameter("petnote");

			Byte stat = Byte.valueOf(req.getParameter("stat"));

			java.sql.Date applicationdeadline = null;
			try {
				applicationdeadline = java.sql.Date.valueOf(req.getParameter("applicationdeadline").trim());
			} catch (IllegalArgumentException e) {
				applicationdeadline = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.put("applicationdeadline", "請輸入日期!");
			}

			PetVO petVO = new PetVO();
			petVO.setAnimaltypeno(animaltypeno);
			petVO.setMemberno(memberno);
			petVO.setPetname(petname);
			petVO.setPetsex(petsex);
			petVO.setPetage(petage);
			petVO.setPetnote(petnote);
			petVO.setStat(stat);
			petVO.setApplicationdeadline(applicationdeadline);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("petVO", petVO); // 含有輸入格式錯誤的petVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/pet/addPet.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			PetService petSvc = new PetService();
			petVO = petSvc.addPet(animaltypeno, memberno, petname, petsex, petage, petnote, stat, applicationdeadline);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/pet/listAllPet.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllPet.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllPet.jsp

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer petid = Integer.valueOf(req.getParameter("petid"));

			/*************************** 2.開始刪除資料 ***************************************/
			PetService petSvc = new PetService();
			petSvc.deletePet(petid);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/pet/listAllPet.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}
}