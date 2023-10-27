package com.cha103g5.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;

import com.cha103g5.member.model.MemberHibernateDAO;
import com.cha103g5.member.model.MemberVO;
import com.cha103g5.util.HibernateUtil;

public class ImageReader extends HttpServlet {

	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//        String servletPath = request.getServletPath() + request.getPathInfo();
		response.setContentType("image/jpeg");
		ServletOutputStream outputStream = response.getOutputStream();
		try {
			int id = Integer.parseInt(request.getParameter("id"));

			MemberHibernateDAO memberHibernateDAO = new MemberHibernateDAO(sessionFactory);
			MemberVO memberVO = memberHibernateDAO.findByPrimaryKey(id);
			if (memberVO != null) {
				byte[] image = memberVO.getMemberpic();
				System.out.println("image");
				outputStream.write(image);
				outputStream.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}