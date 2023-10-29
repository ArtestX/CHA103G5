package com.cha103g5.product.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cha103g5.product.model.ProductVO;
import com.cha103g5.product.model.ProductService;

public class ProductServlet extends HttpServlet {
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
			String str = req.getParameter("productNo");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.put("productNo", "請輸入商品編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/product/selectPage.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer productNo = null;
			try {
				productNo = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.put("productNo", "編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/product/selectPage.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			ProductService productSvc = new ProductService();
			ProductVO product = productSvc.getOneProduct(productNo);
			if (product == null) {
				errorMsgs.put("productNo", "查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/product/selectPage.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("ProductVO", product); // 資料庫取出的productVO物件,存入req
			String url = "/product/listOneProduct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneProduct.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllProduct.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer productNo = Integer.valueOf(req.getParameter("productNo"));

			/*************************** 2.開始查詢資料 ****************************************/
			ProductService productSvc = new ProductService();
			ProductVO product = productSvc.getOneProduct(productNo);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			String param = "?productNo=" + product.getProductNo() + "&productCatNo=" + product.getProductCatNo()
	        + "&productName=" + product.getProductName() + "&productPrice=" + product.getProductPrice()
	        + "&productInfo=" + product.getProductInfo() + "&productStat=" + product.getProductStat()
	        + "&productEval=" + product.getProductEval() + "&productEvalTotal=" + product.getProductEvalTotal()
	        + "&productSaleNum=" + product.getProductSaleNum();

			String url = "/product/updateProduct.jsp" + param;
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 updateproduct.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String productName = req.getParameter("productName");
			String productNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (productName == null || productName.trim().length() == 0) {
				errorMsgs.put("productName", "商品名稱: 請勿空白");
			} else if (!productName.trim().matches(productNameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.put("productName", "商品名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

			Integer productNo = null;
			try {
				productNo = Integer.valueOf(req.getParameter("productNo").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("productNo", "商品編號請填數字");
			}

			Integer productCatNo = null;
			try {
				productCatNo = Integer.valueOf(req.getParameter("productCatNo").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("productCatNo", "類別編號請填數字");
			}

			BigDecimal productPrice = null;
			try {
			    String productPriceStr = req.getParameter("productPrice");
			    if (productPriceStr != null && !productPriceStr.trim().isEmpty()) {
			        productPrice = new BigDecimal(productPriceStr);
			    } else {
			        errorMsgs.put("productPrice", "商品單價不能為空");
			    }
			} catch (NumberFormatException e) {
			    errorMsgs.put("productPrice", "商品單價請填數字");
			}


			String productInfo = req.getParameter("productInfo").trim();
			if (productInfo == null || productInfo.trim().length() == 0) {
				errorMsgs.put("productInfo", "商品資訊請勿空白");
			}

			Integer productStat = null;
			try {
			    String productStatParam = req.getParameter("productStat").trim();
			    if (!productStatParam.isEmpty()) {
			        if (productStatParam.equals("0") || productStatParam.equals("1")) {
			            productStat = Integer.valueOf(productStatParam);
			        } else {
			            errorMsgs.put("productStat", "狀態只能輸入0:下架或1:上架");
			        }
			    } else {
			        errorMsgs.put("productStat", "請輸入狀態");
			    }
			} catch (NumberFormatException e) {
			    errorMsgs.put("productStat", "狀態請填數字");
			}

			Integer productEval = null;
			try {
				productEval = Integer.valueOf(req.getParameter("productEval").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("productEval", "商品總評價數");
			}

			Integer productEvalTotal = null;
			try {
				productEvalTotal = Integer.valueOf(req.getParameter("productEvalTotal").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("productEvalTotal", "商品評價總人數");
			}

			Integer productSaleNum = null;
			try {
				productSaleNum = Integer.valueOf(req.getParameter("productSaleNum").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("productSaleNum", "商品已售出數量");
			}

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/product/updateProduct.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			ProductService productSvc = new ProductService();
			ProductVO product = productSvc.updateProduct(productNo,productCatNo, productName, productPrice, productInfo, productStat,
					productEval, productEvalTotal, productSaleNum);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("Product", product); // 資料庫update成功後,正確的的product物件,存入req
			String url = "/product/listOneProduct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneproduct.jsp
			successView.forward(req, res);
		}

		if ("insert".equals(action)) { // 來自addProduct.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			String productName = req.getParameter("productName");
			String productNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (productName == null || productName.trim().length() == 0) {
				errorMsgs.put("productName", "商品名稱: 請勿空白");
			} else if (!productName.trim().matches(productNameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.put("productName", "商品名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

			Integer productNo = null;
			try {
				productNo = Integer.valueOf(req.getParameter("productNo").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("productNo", "商品編號請填數字");
			}

			Integer productCatNo = null;
			try {
				productCatNo = Integer.valueOf(req.getParameter("productCatNo"));
			} catch (NumberFormatException e) {
				errorMsgs.put("productCatNo", "類別編號請填數字");
			}

			BigDecimal productPrice = null;
			try {
			    String productPriceStr = req.getParameter("productPrice");
			    if (productPriceStr != null && !productPriceStr.trim().isEmpty()) {
			        productPrice = new BigDecimal(productPriceStr);
			    } else {
			        errorMsgs.put("productPrice", "商品單價不能為空");
			    }
			} catch (NumberFormatException e) {
			    errorMsgs.put("productPrice", "商品單價請填數字");
			}



			String productInfo = req.getParameter("productInfo").trim();
			if (productInfo == null || productInfo.trim().length() == 0) {
				errorMsgs.put("productInfo", "商品資訊請勿空白");
			}

			Integer productStat = null;
			try {
			    String productStatParam = req.getParameter("productStat").trim();
			    if (!productStatParam.isEmpty()) {
			        if (productStatParam.equals("0") || productStatParam.equals("1")) {
			            productStat = Integer.valueOf(productStatParam);
			        } else {
			            errorMsgs.put("productStat", "狀態只能輸入0:下架或1:上架");
			        }
			    } else {
			        errorMsgs.put("productStat", "請輸入狀態");
			    }
			} catch (NumberFormatException e) {
			    errorMsgs.put("productStat", "狀態請填數字");
			}

			Integer productEval = null;
			try {
				productEval = Integer.valueOf(req.getParameter("productEval").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("productEval", "商品總評價數");
			}

			Integer productEvalTotal = null;
			try {
				productEvalTotal = Integer.valueOf(req.getParameter("productEvalTotal").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("productEvalTotal", "商品評價總人數");
			}

			Integer productSaleNum = null;
			try {
				productSaleNum = Integer.valueOf(req.getParameter("productSaleNum").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("productSaleNum", "商品已售出數量");
			}

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/product/addProduct.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			ProductService productSvc = new ProductService();
			productSvc.addProduct(productNo,productCatNo, productName, productPrice, productInfo, productStat, productEval,
					productEvalTotal, productSaleNum);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/product/listAllProduct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllproduct.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllproduct.jsp

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer productNo = Integer.valueOf(req.getParameter("productNo"));

			/*************************** 2.開始刪除資料 ***************************************/
			ProductService productSvc = new ProductService();
			productSvc.deleteProduct(productNo);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/product/listAllProduct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}
}
