package com.cha103g5.member.controller;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import redis.clients.jedis.Jedis;

import com.cha103g5.member.model.SendMailService;
import com.google.gson.Gson;

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
			
/**********************寄信(註冊)**********************/
/**********************寄信(註冊)**********************/
/**********************寄信(註冊)**********************/
			
			if("verificationEmail".equals(action)) {
			    		System.out.println("寄信(註冊)");
			    		String to = req.getParameter("memberemail");
			    		String subject = " 浪愛有家_註冊成功通知信";
			    		
			    		String activeCode = generateRandomString(6);
			    		String membername = (String) req.getAttribute("membername");
			
			    		String messageText =  membername +" 你好, 你在浪愛有家的會員帳號已經創建! \n請輸入驗證碼完成信箱驗證，謝謝~ \n" + activeCode ;
			    		SendMailService SendMailService = new SendMailService();
			    		SendMailService.sendMail(to, subject, messageText);
			    		 
					    res.setContentType("text/plain");
					    res.getWriter().write("123");
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
		    		String to = req.getParameter("memberemail");
		    		String subject = " 浪愛有家_密碼重置驗證信";
		    		
		    		String activeCode = generateRandomString(6);

		    		String messageText = "你好, 你的驗證碼為:" + activeCode +"/n請於十分鐘內完成驗證，請勿轉發或告知他人訊息，以維護你的帳號使用安全，謝謝" ;
		    		SendMailService SendMailService = new SendMailService();
		    		SendMailService.sendMail(to, subject, messageText);
		    		 
				    res.setContentType("text/plain");
				    res.sendRedirect(req.getContextPath() + "/member/membeFotgotPassword.jsp");
				    
				    //將驗證碼存進redis
				    Map<String,String> verification =  new HashMap<>();
		    		verification.put("activeCode", activeCode);
		    		
		    		Jedis jedis = new Jedis("localhost", 6379);
					jedis.select(2);
					Gson gson = new Gson();
					String verificationValue = gson.toJson(verification);
					String email =  String.valueOf(to);
					    
					jedis.expire(email, 600);//設定生命週期(以秒為單位)
	
					jedis.set(email, verificationValue);
					jedis.close();
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


