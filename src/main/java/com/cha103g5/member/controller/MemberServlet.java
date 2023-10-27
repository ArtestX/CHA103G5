package com.cha103g5.member.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import com.cha103g5.member.model.MemberService;
import com.cha103g5.member.model.MemberVO;
import com.google.gson.JsonObject;

@MultipartConfig
public class MemberServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
/**********************登出**********************/
/**********************登出**********************/
/**********************登出**********************/				
		if("logout".equals(action)) {
			
		    HttpSession  session = req.getSession();
		    
		    session.removeAttribute("user");
		    res.sendRedirect(req.getContextPath() + "/index.jsp");
		    
		   
		    System.out.println(session.getId() +"刪除");
            String user = (String) session.getAttribute("user");
            if (user == null) {
                System.out.println("User is not in session.");
            }    
           
		}
/**********************登入**********************/
/**********************登入**********************/
/**********************登入**********************/		
		if ("memberlogin".equals(action)) { // 來自memberLogin.jsp的請求	
				Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			   	req.setAttribute("errorMsgs", errorMsgs);
			   	/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			   	String memberemail = req.getParameter("memberemail");
				
				if (memberemail == null || (memberemail.trim()).length() == 0) {
					errorMsgs.put("memberemail","會員帳號:請勿空白");
				}
				
				String memberpassword = req.getParameter("memberpassword");
				
				if (memberpassword == null || (memberpassword.trim()).length() == 0) {
					errorMsgs.put("memberpassword","會員密碼:請勿空白");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/member/memberLogin.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				MemberService mbrSvc = new MemberService();
				MemberVO memberVO = mbrSvc.getMemberByMemberemail(memberemail);
				
				
				if (memberVO != null && memberpassword.equals(memberVO.getMemberpassword())) {
		            // 登入成功，將訊息儲存在session中
					HttpSession session = req.getSession();
		            session.setAttribute("user",memberemail);
		           
		  
		            System.out.println(session.getId());//印出session確認
		            	            
//		            if (memberemail != null && memberpassword != null) {
//		              	JsonObject jsonResponse = new JsonObject();
//		                jsonResponse.addProperty("success", true);
//		                res.setContentType("application/json");
//		                PrintWriter out = res.getWriter();
//		                out.print(jsonResponse.toString());
//		                out.flush();
//		            }
		            // 重導頁面
//		            String location = (String) session.getAttribute("location");// 看看有無來源網頁。有可設定重導回去原本網頁
			        String url = req.getContextPath() + "/index.jsp";
					res.sendRedirect(url);
		            
		        } else {
		        	errorMsgs.put("memberlogin","帳號 或 密碼 不正確");
		        	
		        	// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
						RequestDispatcher failureView = req
								.getRequestDispatcher("/member/memberLogin.jsp");
						failureView.forward(req, res);
						return;//程式中斷
					}	
					 
		        }

		}
		
/**********************查詢**********************/
/**********************查詢**********************/
/**********************查詢**********************/	
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求	
			
			   	Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			   	req.setAttribute("errorMsgs", errorMsgs);

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("memberno");
				
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.put("memberno","請輸入員工編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/member/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer memberno = null;
				try {
					memberno = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.put("memberno","員工編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/member/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
						
				/***************************2.開始查詢資料*****************************************/
				MemberService mbrSvc = new MemberService();
				MemberVO memberVO = mbrSvc.getMemberByMemberno(memberno);
				if (memberVO == null) {
					errorMsgs.put("memberno","查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/member/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("MemberVO", memberVO); // 資料庫取出的MemberVO物件,存入req
				String url = "/member/listOneMbr.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneMbr.jsp
				successView.forward(req, res);
		 }
		
/**********************查詢單筆**********************/
/**********************查詢單筆**********************/
/**********************查詢單筆**********************/	
		 	
		 if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求	
			
				Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
				req.setAttribute("errorMsgs", errorMsgs);
				
				//【從 session 判斷此user是否登入過】//
				HttpSession session = req.getSession();
				Object account = session.getAttribute("account");
				if (account == null) {
					session.setAttribute("location", req.getRequestURI());
					res.sendRedirect(req.getContextPath() + "/index.jsp");
					return;
				}
			
				/***************************1.接收請求參數****************************************/
				Integer memberno = Integer.valueOf(req.getParameter("memberno"));
				
				/***************************2.開始查詢資料****************************************/
				MemberService mbrSvc = new MemberService();
				MemberVO MemberVO = mbrSvc.getMemberByMemberno(memberno);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				String param = "?memberno="       +MemberVO.getMemberno()+
						       "&memberemail="    +MemberVO.getMemberemail()+
						       "&membername="     +MemberVO.getMembername()+
						       "&membergender="   +MemberVO.getMembergender()+
						       "&memberpassword=" +MemberVO.getMemberpassword()+
						       "&memberphone="    +MemberVO.getMemberphone()+
						       "&memberaddress="  +MemberVO.getMemberaddress()+
							   "&memberjointime=" +MemberVO.getMemberjointime()+
						       "&memberbirthday=" +MemberVO.getMemberbirthday()+
						       "&membernation="   +MemberVO.getMembernation()+
						       "&memberpic="      +MemberVO.getMemberpic()+
						       "&membercard="     +MemberVO.getMembercard()+
						       "&memberpoints="   +MemberVO.getMemberpoints()+
							   "&memberstat="     +MemberVO.getMemberstat()+
						       "&memberid="       +MemberVO.getMemberid()+
						       "&memberjob="      +MemberVO.getMemberjob()+
						       "&membersal="      +MemberVO.getMembersal();
				String url = "/member/update_Mbr_input.jsp"+param;
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_Mbr_input.jsp
				successView.forward(req, res);
		 }
		
/**********************修改**********************/
/**********************修改**********************/
/**********************修改**********************/	
		 if ("update".equals(action)) {// 來自update_Mbr_input.jsp的請求
			
				Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
				req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer memberno = Integer.valueOf(req.getParameter("memberno").trim());		
				
				String membername = req.getParameter("membername").trim();
				String mnameReg = "^[\u4e00-\u9fa5a-zA-Z0-9_\\s]{2,20}$"; // \s是包含空格的意思
				if (membername == null || membername.trim().length() == 0) {
					errorMsgs.put("membername","會員姓名: 請勿空白");
				} else if(!membername.trim().matches(mnameReg)) { 
					errorMsgs.put("membername","會員姓名: 只能是中、英文字母和_(可含空格) , 且長度必需在2到20之間");
	            }

				Integer membergender = Integer.valueOf(req.getParameter("membergender"));
				
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
				
				String memberaddress = req.getParameter("memberaddress").trim();
				
				Date memberbirthday = null;
				try {
					memberbirthday = java.sql.Date.valueOf(req.getParameter("memberbirthday").trim());
				} catch (IllegalArgumentException e) {
					errorMsgs.put("memberbirthday","日期格式無效");
				}
				
				String membernation = req.getParameter("membernation").trim();
				
				byte[] memberpic = null;
				MemberService mbrSvc = new MemberService();
		    	try {	
			    		Part part = req.getPart("memberpic"); //part 不能直接設定成O，要設定part的長度
			    		int lenth = part.getInputStream().available(); //part的長度值(用available)
			    		if (lenth != 0) {
				    		var inputstream = part.getInputStream();//長度不等於0，有圖片所以修改
			    			memberpic = IOUtils.toByteArray(inputstream);
			    		}else {
			    			memberpic = mbrSvc.getMemberByMemberno(memberno).getMemberpic();//沒有圖片所以維持原樣
			    		}
				} catch (IOException e) {
				    e.printStackTrace();
				}
		    	
				String membercard = req.getParameter("membercard").trim();
				String mcardReg = "^[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}$";
				if(!membercard.trim().matches(mcardReg)) { 
					errorMsgs.put("membercard","不符合信用卡格式");
	            }
				
				String memberid = req.getParameter("memberid").trim();
				String midReg= "^[A-Za-z][1-2]\\d{8}$";
				if(!memberid.trim().matches(midReg)) { 
					errorMsgs.put("membercard","不符合身分證格式");
				}
				
				String memberjob = req.getParameter("memberjob").trim();
							
				Integer membersal = Integer.valueOf(req.getParameter("membersal").trim());
				
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/member/update_Mbr_input.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				
				MemberVO memberVO = mbrSvc.updateMember(memberno, membername, membergender, 
						memberpassword, memberphone, memberaddress, memberbirthday, membernation,
						memberpic, membercard, memberid, memberjob, membersal);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("memberVO", memberVO); // 資料庫update成功後,正確的的memberVO物件,存入req
				String url = "/member/listAllMbr.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneMbr.jsp
				successView.forward(req, res);
		 }
		 
/**********************新增**********************/
/**********************新增**********************/
/**********************新增**********************/				

		 if ("insert".equals(action)) { // 來自signUpMbr.jsp的請求  
			    Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
				req.setAttribute("errorMsgs", errorMsgs);

			  /***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
			 
			 	String memberemail = req.getParameter("memberemail");
				String memailReg = "^[A-Za-z0-9+_.-]+@(.+)$";
				if(!memberemail.trim().matches(memailReg)) { 
					errorMsgs.put("memberemail","不符合信箱格式");
		        }
					
				String membername = req.getParameter("membername").trim();
				String mnameReg = "^[\u4e00-\u9fa5a-zA-Z0-9_\\s]{2,20}$"; // \s是包含空格的意思
				if (membername == null || membername.trim().length() == 0) {
					errorMsgs.put("membername","會員姓名: 請勿空白");
				} else if(!membername.trim().matches(mnameReg)) { 
					errorMsgs.put("membername","會員姓名: 只能是中、英文字母和_(可含空格) , 且長度必需在2到20之間");
		        }
					

				Integer membergender = Integer.valueOf(req.getParameter("membergender"));
					
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
						
				String memberaddress = req.getParameter("memberaddress").trim();
					
				Timestamp memberjointime = null;
				try {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					java.util.Date parsedDate = dateFormat.parse(req.getParameter("memberjointime"));
					memberjointime = new Timestamp(parsedDate.getTime());
				} catch (ParseException e) {
					errorMsgs.put("memberjointime","日期格式無效");
				}
					
				java.sql.Date memberbirthday = null;
				try {
					memberbirthday = java.sql.Date.valueOf(req.getParameter("memberbirthday").trim());
				} catch (IllegalArgumentException e) {
					errorMsgs.put("memberbirthday","日期格式無效");
				}
					
				String membernation = req.getParameter("membernation").trim();
					
				Part image = null;
	            try {
	                Collection<Part> parts = req.getParts();
	                for (Part part : parts) {
	                    if ("image".equals(part.getName())) {
	                    	image = part;
	                    }
	                }
	            } catch (IllegalArgumentException e){
	                e.printStackTrace();
	            }
	            
	            byte[] memberpic = null;
	            if(image != null){
	                try (InputStream inputStream = image.getInputStream()){
	                	memberpic = inputStream.readAllBytes();
	                    inputStream.close();
	                } catch (IOException e){
	              	    e.printStackTrace();
	                }
	            }
			    	
				String membercard = req.getParameter("membercard").trim();
				String mcardReg = "^[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}$";
				if(!membercard.trim().matches(mcardReg)) { 
					errorMsgs.put("membercard","不符合信用卡格式");
		        }
					
				Integer memberpoints = Integer.valueOf(req.getParameter("memberpoints"));
					
				Integer memberstat = Integer.valueOf( req.getParameter("memberstat"));
					
				String memberid = req.getParameter("memberid").trim();
				String midReg= "^[A-Za-z][1-2]\\d{8}$";
				if(!memberid.trim().matches(midReg)) { 
					errorMsgs.put("memberid","不符合身分證格式");
				}
					
				String memberjob = req.getParameter("memberjob").trim();
				if (memberjob == null || memberjob.trim().length() == 0) {
					errorMsgs.put("memberjob","職位請勿空白");
				}
					
				Integer membersal = Integer.valueOf(req.getParameter("membersal").trim());
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/member/signUpMbr.jsp");
					failureView.forward(req, res);
					return;
				}
					
			   /***************************2.開始新增資料***************************************/
				
				MemberService memberService = new MemberService();
				memberService.signUpMember(memberemail, membername, membergender, 
				memberpassword, memberphone, memberaddress, memberjointime,
				memberbirthday, membernation, memberpic, membercard, memberpoints,
				memberstat, memberid, memberjob, membersal);
			
			    /***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = req.getContextPath() + "/member/memberLogin.jsp";
				res.sendRedirect(url);
			 			
		 }
		
/**********************刪除**********************/
/**********************刪除**********************/
/**********************刪除**********************/					
		 if ("delete".equals(action)) { // 來自listAllEmp.jsp
		 
				Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
				req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.接收請求參數***************************************/
				Integer memberno = Integer.valueOf(req.getParameter("memberno").trim());
				
				/***************************2.開始刪除資料***************************************/
				MemberService mbrSvc = new MemberService();
				mbrSvc.deleteMember(memberno);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/member/listAllMbr.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		 
		 }
    
		
	}
	 
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}
	
}

