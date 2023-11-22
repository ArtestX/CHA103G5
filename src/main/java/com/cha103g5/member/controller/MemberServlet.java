package com.cha103g5.member.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.mindrot.jbcrypt.BCrypt;

import com.cha103g5.member.model.MemberService;
import com.cha103g5.member.model.MemberVO;

@WebServlet("/member/mem.do")
@MultipartConfig
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
					errorMsgs.put("memberemail","帳號請勿空白");
				}
				
				String memberpassword = req.getParameter("memberpassword");
				
				if (memberpassword == null || (memberpassword.trim()).length() == 0) {
					errorMsgs.put("memberpassword","密碼請勿空白");
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
				
				//檢查是否符合資料庫資料
				if (memberVO != null) {
				    	String hashedPassword = memberVO.getMemberpassword();
				    	boolean passwordMatch = BCrypt.checkpw(memberpassword, hashedPassword);
                
		                if (memberVO != null && passwordMatch) {
						            // 登入成功，將訊息儲存在session中
									HttpSession session = req.getSession();
						            session.setAttribute("user",memberVO);
						       
						            System.out.println(session.getId());//印出session確認
						           
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

			 } else {
			    errorMsgs.put("memberlogin", "帳號或密碼不正確");
			    
			    // Send the user back to the form, if there were errors
			    if (!errorMsgs.isEmpty()) {
			        RequestDispatcher failureView = req.getRequestDispatcher("/member/memberLogin.jsp");
			        failureView.forward(req, res);
			        return; // 程式中斷
			    }
			}
		}				
/**********************修改會員狀態**********************/
/**********************修改會員狀態**********************/
/**********************修改會員狀態**********************/	
		 if ("updateStat".equals(action)) {
				 Integer memberstat = Integer.valueOf( req.getParameter("memberstat"));
				 Integer memberno = Integer.valueOf(req.getParameter("memberno").trim());	
				 MemberService mbrSvc = new MemberService();
				 MemberVO memberVO = mbrSvc.getMemberByMemberno(memberno);
				
				memberVO.setMemberstat(memberstat);
				mbrSvc.updateMembers(memberVO);
				req.setAttribute("memberVO", memberVO); // 資料庫update成功後,正確的的memberVO物件,存入req
				res.sendRedirect(req.getContextPath() + "/member/allMembers.jsp");
				return;//程式中斷
			 
		 } 
/**********************修改密碼**********************/
/**********************修改密碼**********************/
/**********************修改密碼**********************/	
		 if ("updatePassword".equals(action)) {// 來自memberCenter.jsp的請求
			  	System.out.println("開始修改密碼");
				Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
				req.setAttribute("errorMsgs", errorMsgs);
				
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String memberpassword = req.getParameter("memberpassword");
				String mpasswordReg = "^(?![\\s])(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@#$%^&+=!]{8,30}$";
				if(!memberpassword.trim().matches(mpasswordReg)) { 
					errorMsgs.put("memberpassword","請設定8碼以上(含字母跟數字)");
	            }
				
				String confirmPass = req.getParameter("confirmPassword");
				if (!confirmPass.equals(memberpassword)) {
				    errorMsgs.put("confirmPassword", "密碼不一致");
				}
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/member/memberCenter.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				String memberemail = req.getParameter("memberemail");
				MemberService mbrSvc = new MemberService();
				System.out.println(memberemail);
				MemberVO memberVO = mbrSvc.getMemberByMemberemail(memberemail);
				
				String hashedPassword = BCrypt.hashpw(memberpassword, BCrypt.gensalt());
				memberVO.setMemberpassword(hashedPassword);
				mbrSvc.updateMembers(memberVO);
				HttpSession session = req.getSession();
				session.removeAttribute("user");
	            session.setAttribute("user",memberVO);
	            
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("memberVO", memberVO); // 資料庫update成功後,正確的的memberVO物件,存入req
				res.sendRedirect(req.getContextPath() + "/member/memberCenter.jsp");
				return;//程式中斷
		 }		 
/**********************修改會員大頭照**********************/
/**********************修改會員大頭照**********************/
/**********************修改會員大頭照**********************/	
		 if ("updatePic".equals(action)) {// 來自memberCenter.jsp的請求
			 	System.out.println("開始修改大頭照");
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/	
			 	String memberemail = req.getParameter("memberemail");
			 	
			 	byte[] memberpic = null;
				MemberService mbrSvc = new MemberService();
		    	try {	
			    		Part part = req.getPart("memberpic"); //part 不能直接設定成O，要設定part的長度
			    		int lenth = part.getInputStream().available(); //part的長度值(用available)
			    		if (lenth != 0) {
				    		var inputstream = part.getInputStream();//長度不等於0，有圖片所以修改
			    			memberpic = IOUtils.toByteArray(inputstream);
			    		}else {
			    			memberpic = mbrSvc.getMemberByMemberemail(memberemail).getMemberpic();//沒有圖片所以維持原樣
			    		}
				} catch (IOException e) {
				    e.printStackTrace();
				}

				/***************************2.開始修改資料*****************************************/
				
				MemberVO memberVO = mbrSvc.getMemberByMemberemail(memberemail);
				memberVO.setMemberpic(memberpic);
				mbrSvc.updateMembers(memberVO);
				HttpSession session = req.getSession();
				session.removeAttribute("user");
	            session.setAttribute("user",memberVO);
	            
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("memberVO", memberVO); // 資料庫update成功後,正確的的memberVO物件,存入req
				res.sendRedirect(req.getContextPath() + "/member/memberCenter.jsp");
				return;//程式中斷
		 }
/**********************修改會員資料**********************/
/**********************修改會員資料**********************/
/**********************修改會員資料**********************/	
		 if ("update".equals(action)) {// 來自memberCenter.jsp的請求
			  	System.out.println("開始修改");
				Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
				req.setAttribute("errorMsgs", errorMsgs);
				String pass = "尚未填寫";
				
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
//				Integer memberno = Integer.valueOf(req.getParameter("memberno"));		
				
				String membername = req.getParameter("membername").trim();
				if (membername == null || membername.trim().length() == 0) {
					errorMsgs.put("membername","會員姓名: 請勿空白");
				}

				String memberGenderString = req.getParameter("membergender");
				Integer membergender = (memberGenderString != null && !memberGenderString.isEmpty()) ? Integer.valueOf(memberGenderString) : null;
				
				String memberphone = req.getParameter("memberphone");
				String mphoneReg = "^09[0-9]{8}$";
				if(!memberphone.trim().matches(mphoneReg) && !memberphone.trim().matches(pass)) { 
					errorMsgs.put("memberphone","不符合手機號碼格式");
	            }
				
				String memberaddress = req.getParameter("memberaddress").trim();
//				 String county = req.getParameter("county");
//			     String district = req.getParameter("district");
//			     String zipcode = req.getParameter("zipcode");
//			     String address = req.getParameter("address");
//			     String  memberaddress =  county.concat(district).concat(zipcode).concat(address);
				
				Date memberbirthday = null;
				String memberBirthdayParameter = req.getParameter("memberbirthday");
				if (memberBirthdayParameter != null && !memberBirthdayParameter.trim().isEmpty()) {
				    try {
				        memberbirthday = java.sql.Date.valueOf(memberBirthdayParameter.trim());
				    } catch (IllegalArgumentException e) {
				        errorMsgs.put("memberbirthday", "日期格式無效");
				    }
				} 
		    	
//				String membercard = req.getParameter("membercard").trim();
//				String mcardReg = "^[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}$";
//				if(!membercard.trim().matches(mcardReg)) { 
//					errorMsgs.put("membercard","不符合信用卡格式");
//	            }
				
				String memberid = req.getParameter("memberid").trim();
				String midReg= "^[A-Za-z][1-2]\\d{8}$";
				if(!memberid.trim().matches(midReg) && !memberid.trim().matches(pass)) { 
					errorMsgs.put("memberid","不符合身分證格式");
				}
				
				String memberjob = req.getParameter("memberjob").trim();
							
				Integer membersal = Integer.valueOf(req.getParameter("membersal").trim());
				
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/member/memberCenter.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				String memberemail = req.getParameter("memberemail");
				MemberService mbrSvc = new MemberService();
				System.out.println(memberemail);
				MemberVO memberVO = mbrSvc.getMemberByMemberemail(memberemail);
				System.out.println(membername);
				
				memberVO.setMembername(membername);
				memberVO.setMembergender(membergender);
				memberVO.setMemberid(memberid);
				memberVO.setMemberbirthday(memberbirthday);
				memberVO.setMemberphone(memberphone);
				memberVO.setMemberjob(memberjob);
				memberVO.setMemberaddress(memberaddress);
				memberVO.setMembersal(membersal);
				mbrSvc.updateMembers(memberVO);
				HttpSession session = req.getSession();
				session.removeAttribute("user");
	            session.setAttribute("user",memberVO);
	            
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("memberVO", memberVO); // 資料庫update成功後,正確的的memberVO物件,存入req
				res.sendRedirect(req.getContextPath() + "/member/memberCenter.jsp");
				return;//程式中斷
		 }
		 
/**********************註冊**********************/
/**********************註冊'**********************/
/**********************註冊**********************/				

		 if ("insert".equals(action)) { // 來自memberSignUp.jsp的請求  
			    Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
				req.setAttribute("errorMsgs", errorMsgs);

			  /***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				System.out.println("進入新增狀態");
			 	String memberemail = req.getParameter("memberemail");
				String memailReg = "^[A-Za-z0-9+_.-]+@(.+)$";
				if (memberemail == null || memberemail.trim().length() == 0) {
					errorMsgs.put("memberemail","帳號請勿空白");
				}else if(!memberemail.trim().matches(memailReg)) { 
					errorMsgs.put("memberemail","不符合信箱格式");
		        }
					
				String membername = req.getParameter("membername").trim();
				String mnameReg = "^[\u4e00-\u9fa5a-zA-Z0-9_\\s]{2,20}$"; // \s是包含空格的意思
				if (membername == null || membername.trim().length() == 0) {
					errorMsgs.put("membername","姓名請勿空白");
				} else if(!membername.trim().matches(mnameReg)) { 
					errorMsgs.put("membername","會員姓名: 只能是中、英文字母和_(可含空格) , 且長度必需在2到20之間");
		        }
	
				Integer membergender = null ;
				try {
			        membergender = Integer.valueOf(req.getParameter("membergender"));
				}catch (Exception e) {
					errorMsgs.put("membergender","請勾選性別");
				}
				
				String memberpassword = req.getParameter("memberpassword");
				String mpasswordReg = "^(?![\\s])(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@#$%^&+=!]{8,30}$";
				if (memberpassword == null || memberpassword.trim().length() == 0) {
					errorMsgs.put("memberpassword","密碼請勿空白");
				} else if(!memberpassword.trim().matches(mpasswordReg)) { 
					errorMsgs.put("memberpassword","設定至少8碼以上(含字母跟數字)");
		        }
			
				String confirmPass = req.getParameter("confirmPassword");
				if (confirmPass == null || confirmPass.trim().length() == 0) {
				    errorMsgs.put("confirmPassword", "確認密碼請勿空白");
				} else if (!confirmPass.equals(memberpassword)) {
				    errorMsgs.put("confirmPassword", "密碼不一致請確認");
				}
			
				String memberphone = req.getParameter("memberphone");
				String mphoneReg = "^09[0-9]{8}$";
				if (memberphone != null && !memberphone.trim().isEmpty()) {
				    if (!memberphone.trim().matches(mphoneReg)) {
				        errorMsgs.put("memberphone", "不符合手機號碼格式");
				    }
				}
					
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
					e.getStackTrace();
//					errorMsgs.put("memberbirthday","請填寫出生日期");
				}
				
				Integer memberpoints = Integer.valueOf(req.getParameter("memberpoints"));
					
				Integer memberstat = Integer.valueOf( req.getParameter("memberstat"));
				
				String verificationCode = req.getParameter("verificationCode");
				String sessionVerificationCode = (String) req.getSession().getAttribute("randStr");

				if (verificationCode == null || verificationCode.trim().length() == 0) {
				    errorMsgs.put("verificationCode", "驗證碼請勿空白");
				} else if (!verificationCode.trim().equals(sessionVerificationCode)) {
				    errorMsgs.put("verificationCode", "驗證碼不正確");
				}
			
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/member/memberSignUp.jsp");
					failureView.forward(req, res);
					return;
				}
					
			   /***************************2.開始新增資料***************************************/
					System.out.println("開始新增");
				
					// Hash the password
					String hashedPassword = BCrypt.hashpw(memberpassword, BCrypt.gensalt());
					
				    MemberService memberService = new MemberService();
					memberService.signUpMember(memberemail, membername, membergender, 
					hashedPassword, memberphone, memberjointime,memberbirthday, memberpoints, memberstat);
					System.out.println("新增完成");
								
			    /***************************3.新增完成,準備轉交(Send the Success view)***********/

					String verificationEmail = "verificationEmail";
					req.setAttribute("VerificationEmail", verificationEmail);

					String url = "/member/sendemail?action=verificationEmail"; 
					RequestDispatcher successView = req.getRequestDispatcher(url);
					successView.forward(req, res);
			 		System.out.println("傳送成功");	
		 }

/**********************查詢**********************/
/**********************查詢**********************/
/**********************查詢**********************/	
		 		if ("getOne_For_Display".equals(action)) { // 來自allMembers.jsp的請求	
		 			
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
		 							.getRequestDispatcher("/member/allMembers.jsp");
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
		 							.getRequestDispatcher("/member/allMembers.jsp");
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
		 							.getRequestDispatcher("/member/allMembers.jsp");
		 					failureView.forward(req, res);
		 					return;//程式中斷
		 				}
		 				
		 				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
		 				req.setAttribute("MemberVO", memberVO); // 資料庫取出的MemberVO物件,存入req
		 				String url = "/member/oneMember.jsp";
		 				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneMbr.jsp
		 				successView.forward(req, res);
		 		 }
		 		
/**********************查詢單筆**********************/
/**********************查詢單筆**********************/
/**********************查詢單筆**********************/	
		 		 	
		 		 if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求	
		 			
		 				Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
		 				req.setAttribute("errorMsgs", errorMsgs);
		 			
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
//		 						       "&memberpassword=" +MemberVO.getMemberpassword()+
		 						       "&memberphone="    +MemberVO.getMemberphone()+
		 						       "&memberaddress="  +MemberVO.getMemberaddress()+
		 							   "&memberjointime=" +MemberVO.getMemberjointime()+
		 						       "&memberbirthday=" +MemberVO.getMemberbirthday()+
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
		
	    int width = 130;
	    int height = 50;
	    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	    OutputStream out = res.getOutputStream();

	  //獲取畫筆
        Graphics g=image.getGraphics();
        //設定背景色
        g.setColor(new Color(245, 245, 220));
        g.fillRect(0,0,width,height);
        //取隨機產生的驗證碼(4位數字)
        Random rnd=new Random();
     // 生成隨機的颜色
     	int red = rnd.nextInt(256); // 0-255
     	int green = rnd.nextInt(256); // 0-255
     	int blue = rnd.nextInt(256); // 0-255
     		
     	Color randomColor = new Color(red, green, blue);
        int randNum=rnd.nextInt(8999)+1000;
        String randStr=String.valueOf(randNum);
        //將驗證碼存入session
        HttpSession session = req.getSession();
        session.setAttribute("randStr",randStr);
        //將驗證碼顯示到影象中
        g.setColor(randomColor);
        g.setFont(new Font("", Font.PLAIN,40));
        g.drawString(randStr,23,40);
        //隨機產生100個干擾點，使影象中的驗證碼不易被其他程式探測到
          for (int i = 0; i < 100; i++) {
         
         
              int x=rnd.nextInt(width);
              int y=rnd.nextInt(height);
              g.drawOval(x,y,1,1);
          }
        // 輸出到前端
        ImageIO.write(image, "JPEG", out);// .生成驗證碼
        
	}
	/**********************檢查帳號**********************/
	/**********************檢查帳號**********************/
	/**********************檢查帳號**********************/	
	private void checkAccount(HttpServletRequest req, HttpServletResponse res)
		    throws IOException {
		    String memberemail = req.getParameter("memberemail");
		    System.out.println("進來比對了");
		    boolean isAccountExists = checkAccountInDatabase(memberemail);

		    res.setContentType("application/json");
		    res.setCharacterEncoding("UTF-8");
		    res.getWriter().write("{\"exists\":" + isAccountExists + "}");
		}

	private boolean checkAccountInDatabase(String memberemail) {
		MemberService mbrSvc = new MemberService();
		MemberVO memberVO = mbrSvc.getMemberByMemberemail(memberemail);
	    System.out.println("Checking account in database: " + memberemail);

	    if (memberVO != null) {
	        System.out.println("Retrieved member email from database: " + memberVO.getMemberemail());
	        return true;
	    } else {
	        return false;
	    }
	}

}