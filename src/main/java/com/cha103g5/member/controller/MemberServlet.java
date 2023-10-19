package com.cha103g5.member.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.cha103g5.member.model.MemberVO;
import com.cha103g5.member.service.*;

public class MemberServlet extends HttpServlet {
	
	// 一個 servlet 實體對應一個 service 實體
		private MemberServiceInterface memberServiceInterface;

		@Override
		public void init() throws ServletException {
			memberServiceInterface = new MemberService();
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");
			String action = req.getParameter("action");
			String forwardPath = "";
			switch (action) {
				case "getAll":
					forwardPath = getAllMembers(req, res);
					break;
				case "compositeQuery":
					forwardPath = getMembersByCompositeQuery(req, res);
					break;
				default:
					forwardPath = "/member/index1.jsp";
			}
			
			res.setContentType("text/html; charset=UTF-8");
			RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
			dispatcher.forward(req, res);
		}

		private String getAllMembers(HttpServletRequest req, HttpServletResponse res) {
			String page = req.getParameter("page");
			int currentPage = (page == null) ? 1 : Integer.parseInt(page);
			
			List<MemberVO> memberList = memberServiceInterface.getAllMembers(currentPage);

			if (req.getSession().getAttribute("empPageQty") == null) {
				int empPageQty = memberServiceInterface.getPageTotal();
				req.getSession().setAttribute("empPageQty", empPageQty);
			}
			
			req.setAttribute("memberList", memberList);
			req.setAttribute("currentPage", currentPage);
			
			return "/member/listAllEmps.jsp";
		}
		
		private String getMembersByCompositeQuery(HttpServletRequest req, HttpServletResponse res) {
			Map<String, String[]> map = req.getParameterMap();
			if (map != null) {
				List<MemberVO> memberList = memberServiceInterface.getMembersByCompositeQuery(map);
				req.setAttribute("memberList", memberList);
			} else {
				return "/member/index1.jsp";
			}
			return "/member/listCompositeQueryEmps.jsp";
		}
		
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			doPost(req, res);
		}
}

