package com.cha103g5.member.controller;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.cha103g5.member.model.MemberService;
import com.cha103g5.member.model.MemberVO;
import com.cha103g5.member.model.SendMailService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import redis.clients.jedis.Jedis;

@WebServlet("/member/sendemail")
public class SendMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private static final Random random = new SecureRandom();

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			String origin = req.getHeader("Origin");
	        if ("https://mail.google.com".equals(origin)) {
	            // 允許Google的郵件服務訪問
	            res.setHeader("Access-Control-Allow-Origin", origin);
	            res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
	            res.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
	        }
	
			req.setCharacterEncoding("UTF-8");
			String action = req.getParameter("action");
			System.out.println("action================"+ action);
/**********************寄信(註冊)**********************/
/**********************寄信(註冊)**********************/
/**********************寄信(註冊)**********************/
			
			if("verificationEmail".equals(action)) {
			    		System.out.println("寄信(註冊)");
			    		String to = req.getParameter("memberemail");
			    		String subject = " 浪愛有家_註冊成功通知信";
			    		
			    		String activeCode = generateRandomString(6);
			    		
			    		String link = "http://lovepethome.ddns.net/CHA103G5//member/sendemail?action=action&activeCode=" + activeCode + "&memberemail=" + to;
			    		String messageText =" 你好, 你在浪愛有家的會員帳號已經創建! \n請點擊以下連結完成信箱認證\n"+ link ;			    				
			    		SendMailService SendMailService = new SendMailService();
			    		SendMailService.sendMail(to, subject, messageText);
			    		 
					    res.setContentType("text/plain");
					    res.sendRedirect(req.getContextPath() + "/member/memberLogin.jsp");
					    
					    //將驗證碼存進redis
					    Map<String,String> verification =  new HashMap<>();
			    		verification.put("activeCode", activeCode);
			    		
			    		Jedis jedis = new Jedis("localhost", 6379);
						jedis.select(1);
						Gson gson = new Gson();
						String verificationValue = gson.toJson(verification);
						String email =  String.valueOf(to);
						    
						jedis.expire(email, 30);//設定生命週期(以秒為單位)

						jedis.set(email, verificationValue);
						jedis.close();
			}	
			
/**********************寄信(忘記密碼)**********************/
/**********************寄信(忘記密碼)**********************/
/**********************寄信(忘記密碼)**********************/
			if("forgot".equals(action)) {
				
				    System.out.println("寄信(忘記密碼)");
				    /***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/    
					Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
				   	req.setAttribute("errorMsgs", errorMsgs);
				   	
		    		String memberemail = req.getParameter("memberemail");
		    		String memailReg = "^[A-Za-z0-9+_.-]+@(.+)$";
					if (memberemail == null || memberemail.trim().length() == 0) {
						errorMsgs.put("memberemail","帳號請勿空白");
					}else if(!memberemail.trim().matches(memailReg)) { 
						errorMsgs.put("memberemail","不符合信箱格式");
			        }
		    		
		    		// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
						RequestDispatcher failureView = req
								.getRequestDispatcher("/member/membeFotgotPassword.jsp");
						failureView.forward(req, res);
						return;//程式中斷
					}
					/***************************2.開始查詢資料*****************************************/
					MemberService mbrSvc = new MemberService();
					MemberVO memberVO = mbrSvc.getMemberByMemberemail(memberemail);
					
					if (memberVO == null) {
							errorMsgs.put("forgotpassword","此信箱未註冊過");
				        	
				        	// Send the use back to the form, if there were errors
							if (!errorMsgs.isEmpty()) {
								RequestDispatcher failureView = req
										.getRequestDispatcher("/member/membeFotgotPassword.jsp");
								failureView.forward(req, res);
								return;//程式中斷
							}	
					}
					
		            req.setAttribute("isForgotStepOneCompleted", true);
		         
					
		    		String subject = " 浪愛有家_密碼重置驗證信";
		    		
		    		String activeCode = generateRandomString(6);

		    		String messageText = "你好, 你的驗證碼為:" + activeCode +"\n請於十分鐘內完成驗證，請勿轉發或告知他人訊息，以維護你的帳號使用安全，謝謝" ;
		    		SendMailService SendMailService = new SendMailService();
		    		SendMailService.sendMail(memberemail, subject, messageText);
		    		
		    		RequestDispatcher failureView = req
							.getRequestDispatcher("/member/membeFotgotPassword.jsp");
					failureView.forward(req, res);
				    
				    //將驗證碼存進redis
				    Map<String,String> verification =  new HashMap<>();
			        verification.put("activeCode", activeCode);
			        
			        Jedis jedis = new Jedis("localhost", 6379);
				     jedis.select(2);
				     Gson gson = new Gson();
				     String verificationValue = gson.toJson(verification);
				     String email =  String.valueOf(memberemail);
				     
				     jedis.expire(email, 600);//設定生命週期(以秒為單位)
				 
				     jedis.set(email, verificationValue);
				     jedis.close();
			}	
/**********************寄信(重寄驗證信)**********************/
/**********************寄信(重寄驗證信)**********************/
/**********************寄信(重寄驗證信)**********************/
						
						if("verificationResendEmail".equals(action)) {
						    		System.out.println("寄信(重寄驗證信)");
						    		String to = req.getParameter("memberemail");
						    		String subject = " 浪愛有家_信箱認證信";
						    		
						    		String activeCode = generateRandomString(6);
						    		
						    		String link = "http://localhost:8081/CHA103G5/member/sendemail?action=action&activeCode=" + activeCode + "&memberemail=" + to;
						    		String messageText =" 你好! \n請點擊以下連結完成信箱認證\n"+ link ;			    				
						    		SendMailService SendMailService = new SendMailService();
						    		SendMailService.sendMail(to, subject, messageText);
						    		 
								    res.setContentType("text/plain");
								    res.sendRedirect(req.getContextPath() + "/member/memberLogin.jsp");
								    
								    //將驗證碼存進redis
								    Map<String,String> verification =  new HashMap<>();
						    		verification.put("activeCode", activeCode);
						    		
						    		Jedis jedis = new Jedis("localhost", 6379);
									jedis.select(1);
									Gson gson = new Gson();
									String verificationValue = gson.toJson(verification);
									String email =  String.valueOf(to);
									    
									jedis.expire(email, 30);//設定生命週期(以秒為單位)

									jedis.set(email, verificationValue);
									jedis.close();
						}				
			
			
/**********************驗證(註冊)**********************/
/**********************驗證(註冊)**********************/
/**********************驗證(註冊)**********************/				
			if("action".equals(action)) {
			      String getActiveCode = req.getParameter("activeCode");
			      String memberemail = req.getParameter("memberemail");

			      System.out.println(memberemail);
			      System.out.println(getActiveCode);
			    MemberService mbrSvc = new MemberService();
				MemberVO memberVO = mbrSvc.getMemberByMemberemail(memberemail);
//			/////////////////////////////////////redis測試//////////////////// 
			      Jedis jedis = new Jedis("localhost", 6379);
			      jedis.select(1); 

			      String emailRdis = memberemail; 
			      String verificationValue = jedis.get(emailRdis); 
			      if (verificationValue != null) {
		         
			          Gson gson = new Gson();
			          Map<String, String> verification = gson.fromJson(verificationValue, new TypeToken<Map<String, String>>() {}.getType());
		          
			          String   activeCode = verification.get("activeCode");
			          System.out.println(activeCode);
			          // 在这里使用activeCode

			          if(activeCode.equals(getActiveCode)) {
			              System.out.println("驗證成功");
			              System.out.println("============="+activeCode);
			              System.out.println("============="+getActiveCode);
			              memberVO.setMemberstat(1);
			              mbrSvc.updateMembers(memberVO);
			              res.sendRedirect(req.getContextPath() + "/member/memberLogin.jsp");
			             }else {
			              System.out.println(activeCode);
			              System.out.println(getActiveCode);
			              
			             }
			      }
			}     

			      
/**********************驗證(忘記密碼)**********************/
/**********************驗證(忘記密碼)**********************/
/**********************驗證(忘記密碼)**********************/			
			if("verificationforgot".equals(action)) {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/    
				 System.out.println("驗證(忘記密碼)");
				 
				 String verification = req.getParameter("verification");
				
				Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			   	req.setAttribute("errorMsgs", errorMsgs);
	    		
				if (verification == null || verification.trim().length() == 0) {
					errorMsgs.put("verification","驗證碼請勿空白");
				}
				
				req.setAttribute("isForgotStepOneCompleted", true);
	    		
	    		// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/member/membeFotgotPassword.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				/***************************2.開始查詢資料*****************************************/
				 Jedis jedis = new Jedis("localhost", 6379);
			     jedis.select(2);
			     String memberemail = req.getParameter("memberemail");
			     System.out.println(memberemail);
			     
			      String verificationValue = jedis.get(memberemail);
			      if (verificationValue != null) {
				      	Gson gson = new Gson();
				      	Map<String, String> verification2 = gson.fromJson(verificationValue, new TypeToken<Map<String, String>>() {}.getType());
				      	System.out.println(verificationValue);
				      
				      	String activeCode = verification2.get("activeCode");
				      	System.out.println(activeCode);
				      
				      	jedis.close();
					       
				      	if (verificationValue != null && verification.equals(activeCode)) {
						    	   System.out.println("驗證通過");
						    	   
						            req.setAttribute("isForgotStepTwoCompleted", true);
						            req.setAttribute("isForgotStepOneCompleted", false);
						    	    
						    		RequestDispatcher failureView = req
											.getRequestDispatcher("/member/membeFotgotPassword.jsp");
									failureView.forward(req, res);
						    		
				    	} else {
					    	    System.out.println("驗證失敗");
					    	    errorMsgs.put("verification","驗證碼不正確");
					    	    
					    	    RequestDispatcher failureView = req
										.getRequestDispatcher("/member/membeFotgotPassword.jsp");
								failureView.forward(req, res);
				    	}
			      }else {
			    	  
			    	    System.out.println("抓不到redis，驗證失敗");
			    	    errorMsgs.put("verification","驗證碼不正確");
			    	
			    	    RequestDispatcher failureView = req
								.getRequestDispatcher("/member/membeFotgotPassword.jsp");
						failureView.forward(req, res);
		    	}
			      
			      
			}
/**********************修改(忘記密碼)**********************/
/**********************修改(忘記密碼)**********************/
/**********************修改(忘記密碼)*********************/	
			if ("changePassword".equals(action)) {
				
				Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
				req.setAttribute("errorMsgs", errorMsgs);
				 /***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
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
				    errorMsgs.put("confirmPassword", "密碼不一致");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					 req.setAttribute("isForgotStepTwoCompleted", true);
			         req.setAttribute("isForgotStepOneCompleted", false);
					RequestDispatcher failureView = req.getRequestDispatcher("/member/membeFotgotPassword.jsp");
					failureView.forward(req, res);
					return;
				}
				
				 /***************************2.開始修改密碼***************************************/
	            String memberemail = req.getParameter("memberemail");
	            String hashedPassword = BCrypt.hashpw(memberpassword, BCrypt.gensalt());
	            
	            System.out.println("email="+memberemail);
	            System.out.println(memberpassword);
	   
	            MemberService mbrSvc = new MemberService();
				MemberVO memberVO = mbrSvc.getMemberByMemberemail(memberemail);
				
				memberVO.setMemberpassword(hashedPassword);
				mbrSvc.updateMembers(memberVO);
	            
				req.setAttribute("memberVO", memberVO); // 資料庫update成功後,正確的的memberVO物件,存入req
				String url = "/member/memberLogin.jsp";
	
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交memberLogin.jsp
				successView.forward(req, res);
	            
	        }						
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	 
		 private String generateRandomString(int length) {
	        StringBuilder sb = new StringBuilder(length);
	        for (int i = 0; i < length; i++) {
	            int randomIndex = random.nextInt(CHARACTERS.length());
	            sb.append(CHARACTERS.charAt(randomIndex));
	        }
	        return sb.toString();
	    }	
	
}


