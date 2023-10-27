package com.cha103g5.member.filter;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginFilter implements Filter {

	private FilterConfig config;

	public void init(FilterConfig config) {
		this.config = config;
	}

	public void destroy() {
		config = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws ServletException, IOException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// 【取得 session】
		HttpSession session = req.getSession();
		// 【從 session 判斷此user是否登入過】
		Object account = session.getAttribute("user");
		System.out.println("login Filter!");
		if (account == null) {
			System.out.println("Please login !");
			try {                                                        
		         String location = (String) session.getAttribute("location");
		         if (location != null) {
		           session.removeAttribute("location");   //*工作2: 看看有無來源網頁 (-->如有來源網頁:則重導至來源網頁)
		           res.sendRedirect(location);            
		           return;
		         }
		       }catch (Exception ignored) { }
			res.sendRedirect(req.getContextPath() + "/member/memberLogin.jsp");
			return;
		} else {
			System.out.println("Already login !");
			chain.doFilter(request, response);
		}
		
		
		
		
		
	}
}
