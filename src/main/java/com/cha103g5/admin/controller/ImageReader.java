package com.cha103g5.admin.controller;

import com.cha103g5.admin.model.AdminHibernateDAO;
import com.cha103g5.admin.model.AdminVO;
import com.cha103g5.util.HibernateUtil;
import org.hibernate.SessionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

			AdminHibernateDAO adminHibernateDAO = new AdminHibernateDAO(sessionFactory);
			AdminVO adminVO = adminHibernateDAO.findByPrimaryKey(id);
			if (adminVO != null) {
				byte[] image = adminVO.getAdminPic();
				System.out.println("image");
				outputStream.write(image);
				outputStream.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}