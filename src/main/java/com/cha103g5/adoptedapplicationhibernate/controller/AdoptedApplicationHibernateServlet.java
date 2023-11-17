package com.cha103g5.adoptedapplicationhibernate.controller;

import java.io.*;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.cha103g5.adoptedapplicationhibernate.model.*;
import com.cha103g5.adoptedapplicationhibernate.service.AdoptedApplicationHibernateService;
import com.cha103g5.adoptedapplicationhibernate.service.AdoptedApplicationHibernateServiceImpl;

@WebServlet("/adoptedApplicationHibernateServlet")
@MultipartConfig
public class AdoptedApplicationHibernateServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		AdoptedApplicationHibernateService aahService = new AdoptedApplicationHibernateServiceImpl();

		if ("getOne".equals(action)) {
			String applicationNoStr = request.getParameter("applicationNo");
			if (applicationNoStr.equals("")) {
				response.sendRedirect("adoptedApplicationHibernateServlet?action=getAll");
			} else {
				Integer applicationNo = Integer.parseInt(applicationNoStr);
				AdoptedApplicationHibernate oneApplication = aahService.getApplicationById(applicationNo);

				request.setAttribute("oneApplication", oneApplication);
				request.getRequestDispatcher("adoptedapplicationhibernate/listOne.jsp")
						.forward(request, response);
			}
		}

		if ("getByMemberNo".equals(action)) {
			String memberNoStr = request.getParameter("memberNo");
			if (memberNoStr.equals("")) {
				response.sendRedirect("adoptedApplicationHibernateServlet?action=getAll");
			} else {
				Integer memberNo = Integer.parseInt(memberNoStr);
				List<AdoptedApplicationHibernate> someApplications = aahService.getApplicationsByMemberNo(memberNo);

				request.setAttribute("someApplications", someApplications);
				request.getRequestDispatcher("adoptedapplicationhibernate/listSome.jsp")
						.forward(request, response);
			}
		}

		if ("compositeQuery".equals(action)) {
			Map<String, String[]> map = request.getParameterMap();
			if (map != null) {
				List<AdoptedApplicationHibernate> someApplications = aahService.getApplicationsByCompositeQuery(map);
				request.setAttribute("someApplications", someApplications);
			} else {
				request.getRequestDispatcher("adoptedapplicationhibernate/index.jsp")
						.forward(request, response);
			}
			request.getRequestDispatcher("adoptedapplicationhibernate/listSome.jsp")
					.forward(request, response);
		}

		if ("getAll".equals(action)) {
			String page = request.getParameter("page");
			int currentPage = (page == null) ? 1 : Integer.parseInt(page);

			List<AdoptedApplicationHibernate> allApplications = aahService.getAllApplications(currentPage);
			if (request.getAttribute("applicationsPageQty") == null) {
				int applicationsPageQty = aahService.getPageTotal();
				request.setAttribute("applicationsPageQty", applicationsPageQty);
			}
			request.setAttribute("allApplications", allApplications);
			request.setAttribute("currentPage", currentPage);
			request.getRequestDispatcher("adoptedapplicationhibernate/listAll.jsp")
					.forward(request, response);
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		AdoptedApplicationHibernateService aahService = new AdoptedApplicationHibernateServiceImpl();

		if ("delete".equals(action)) {
			Integer applicationNo = Integer.parseInt(request.getParameter("applicationNo"));
			aahService.deleteApplication(applicationNo);

			response.sendRedirect("adoptedApplicationHibernateServlet?action=getAll");
		}

		if ("update".equals(action)) {
			Integer applicationNo = Integer.parseInt(request.getParameter("applicationNo"));
			Integer adminNo = Integer.parseInt(request.getParameter("adminNo"));
			Integer memberNo = Integer.parseInt(request.getParameter("memberNo"));
			Integer petId = Integer.parseInt(request.getParameter("petId"));
			Date lotteryDate = Date.valueOf(request.getParameter("lotteryDate"));
			Integer lotteryResult = Integer.parseInt(request.getParameter("lotteryResult"));
			Date applicationDate = Date.valueOf(request.getParameter("applicationDate"));
			Date interactionDate = Date.valueOf(request.getParameter("interactionDate"));
			Integer applicationStat = Integer.parseInt(request.getParameter("applicationStat"));
			String applicantNotes = request.getParameter("applicantNotes");

			Part filePart = request.getPart("signaturePhoto");
			InputStream fileContent = filePart.getInputStream();
			byte[] signaturePhotoBytes = IOUtils.toByteArray(fileContent);

			AdoptedApplicationHibernate application = aahService.getApplicationById(applicationNo);
			application.setApplicationNo(applicationNo);
			application.setAdminNo(adminNo);
			application.setMemberNo(memberNo);
			application.setPetId(petId);
			application.setLotteryDate(lotteryDate);
			application.setLotteryResult(lotteryResult);
			application.setApplicationDate(applicationDate);
			application.setInteractionDate(interactionDate);
			application.setApplicationStat(applicationStat);
			application.setApplicantNotes(applicantNotes);
			application.setSignaturePhoto(signaturePhotoBytes);

			aahService.updateApplication(application);

			response.sendRedirect("adoptedApplicationHibernateServlet?action=getAll");
		}

		if ("edit".equals(action)) {
			Integer applicationNo = Integer.parseInt(request.getParameter("applicationNo"));
			AdoptedApplicationHibernate application = aahService.getApplicationById(applicationNo);
			request.setAttribute("application", application);

			request.getRequestDispatcher("adoptedapplicationhibernate/update.jsp")
					.forward(request, response);
		}

		if ("add".equals(action)) {
			Integer adminNo = Integer.parseInt(request.getParameter("adminNo"));
			Integer memberNo = Integer.parseInt(request.getParameter("memberNo"));
			Integer petId = Integer.parseInt(request.getParameter("petId"));
			Date lotteryDate = Date.valueOf(request.getParameter("lotteryDate"));
			Integer lotteryResult = Integer.parseInt(request.getParameter("lotteryResult"));
			Date applicationDate = Date.valueOf(request.getParameter("applicationDate"));
			Date interactionDate = Date.valueOf(request.getParameter("interactionDate"));
			Integer applicationStat = Integer.parseInt(request.getParameter("applicationStat"));
			String applicantNotes = request.getParameter("applicantNotes");

			Part filePart = request.getPart("signaturePhoto");
			InputStream fileContent = filePart.getInputStream();
			byte[] signaturePhotoBytes = IOUtils.toByteArray(fileContent);

			AdoptedApplicationHibernate application = new AdoptedApplicationHibernate();
			application.setAdminNo(adminNo);
			application.setMemberNo(memberNo);
			application.setPetId(petId);
			application.setLotteryDate(lotteryDate);
			application.setLotteryResult(lotteryResult);
			application.setApplicationDate(applicationDate);
			application.setInteractionDate(interactionDate);
			application.setApplicationStat(applicationStat);
			application.setApplicantNotes(applicantNotes);
			application.setSignaturePhoto(signaturePhotoBytes);

			aahService.addApplication(application);

			response.sendRedirect("adoptedApplicationHibernateServlet?action=getAll");
		}
	}
}

