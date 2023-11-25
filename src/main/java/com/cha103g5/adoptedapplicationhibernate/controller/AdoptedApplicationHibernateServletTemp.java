package com.cha103g5.adoptedapplicationhibernate.controller;

import java.io.*;
import java.sql.Date;
import java.time.LocalTime;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.cha103g5.adoptedapplicationhibernate.model.*;
import com.cha103g5.adoptedapplicationhibernate.service.AdoptedApplicationHibernateService;
import com.cha103g5.adoptedapplicationhibernate.service.AdoptedApplicationHibernateServiceImpl;

@WebServlet("/adoptedApplicationHibernateServletTemp")
@MultipartConfig
public class AdoptedApplicationHibernateServletTemp extends HttpServlet {

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
                request.getRequestDispatcher("adoptedapplicationhibernate/listOneTemp.jsp")
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
                request.getRequestDispatcher("adoptedapplicationhibernate/listSomeTemp.jsp")
                        .forward(request, response);
            }
        }

        if ("frontendGetByMemberNo".equals(action)) {
            String memberNoStr = request.getParameter("memberNo");
            if (memberNoStr == null || memberNoStr.trim().isEmpty()) {
//				response.sendRedirect("adoptedApplicationHibernateServlet?action=getAll");
//				response.sendRedirect("member/memberCenter.jsp");
                request.getRequestDispatcher("adoptedapplicationhibernate/frontendListSome.jsp")
                        .forward(request, response);
            } else {
                Integer memberNo = Integer.parseInt(memberNoStr);
                List<AdoptedApplicationHibernate> someApplications = aahService.getApplicationsByMemberNo(memberNo);

                request.setAttribute("someApplications", someApplications);
                request.setAttribute("applicationIncludePath", "frontendListSome.jsp");
//				request.getRequestDispatcher("adoptedapplicationhibernate/frontmember.jsp")
//						.forward(request, response);
                request.getRequestDispatcher("adoptedapplicationhibernate/frontendListSome.jsp")
                        .forward(request, response);
            }
        }

        if ("compositeQuery".equals(action)) {
            Map<String, String[]> map = request.getParameterMap();
            if (map != null) {
                List<AdoptedApplicationHibernate> someApplications = aahService.getApplicationsByCompositeQuery(map);
                request.setAttribute("someApplications", someApplications);
            } else {
                request.getRequestDispatcher("adoptedapplicationhibernate/indexTemp.jsp")
                        .forward(request, response);
            }
            request.getRequestDispatcher("adoptedapplicationhibernate/listSomeTemp.jsp")
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
            int applicationsDataTotal = aahService.getDataTotal();
            request.setAttribute("applicationsDataTotal", applicationsDataTotal);
            request.setAttribute("allApplications", allApplications);
            request.setAttribute("currentPage", currentPage);
            request.getRequestDispatcher("adoptedapplicationhibernate/listAllTemp.jsp")
                    .forward(request, response);
        }

        if ("showCalendar".equals(action)) {
            List<AdoptedApplicationHibernate> allReservations = aahService.getAllApplications();
            Map<Date, boolean[]> reservationMap = new HashMap<>();
            for (AdoptedApplicationHibernate reservation : allReservations) {
                Date date = reservation.getInteractionDate();
                LocalTime time = reservation.getInteractionTime();
                boolean[] reservedSlots = reservationMap.getOrDefault(date, new boolean[3]);
                if (time != null) {
                    int hour = time.getHour();
                    if (hour >= 9 && hour <= 12) reservedSlots[0] = true;
                    else if (hour >= 14 && hour <= 17) reservedSlots[1] = true;
                    else if (hour >= 18 && hour <= 21) reservedSlots[2] = true;
                }

                reservationMap.put(date, reservedSlots);
            }

            request.setAttribute("reservationMap", reservationMap);
            request.getRequestDispatcher("adoptedapplicationhibernate/showCalendar.jsp").forward(request, response);
        }

        if ("frontendCalendar".equals(action)) {
            List<AdoptedApplicationHibernate> allReservations = aahService.getAllApplications();
            Map<Date, boolean[]> reservationMap = new HashMap<>();
            for (AdoptedApplicationHibernate reservation : allReservations) {
                Date date = reservation.getInteractionDate();
                LocalTime time = reservation.getInteractionTime();
                boolean[] reservedSlots = reservationMap.getOrDefault(date, new boolean[3]);
                if (time != null) {
                    int hour = time.getHour();
                    if (hour >= 9 && hour <= 12) reservedSlots[0] = true;
                    else if (hour >= 14 && hour <= 17) reservedSlots[1] = true;
                    else if (hour >= 18 && hour <= 21) reservedSlots[2] = true;
                }

                reservationMap.put(date, reservedSlots);
            }

            request.setAttribute("reservationMap", reservationMap);
            request.getRequestDispatcher("adoptedapplicationhibernate/frontendCalendar.jsp").forward(request, response);
        }

        if ("addOption".equals(action)) {
            List<AdoptedApplicationHibernate> allReservations = aahService.getAllApplications();
            Map<Date, boolean[]> reservationMap = new HashMap<>();
            for (AdoptedApplicationHibernate reservation : allReservations) {
                Date date = reservation.getInteractionDate();
                LocalTime time = reservation.getInteractionTime();
                boolean[] reservedSlots = reservationMap.getOrDefault(date, new boolean[3]);
                if (time != null) {
                    int hour = time.getHour();
                    if (hour >= 9 && hour <= 12) reservedSlots[0] = true;
                    else if (hour >= 14 && hour <= 17) reservedSlots[1] = true;
                    else if (hour >= 18 && hour <= 21) reservedSlots[2] = true;
                }

                reservationMap.put(date, reservedSlots);
            }

            request.setAttribute("reservationMap", reservationMap);

//			PetVO randomPet = aahService.getRandomPet();
//			Byte petStatByte = randomPet.getStat();
//			boolean isPetAvailableForReservation = (petStatByte != null && petStatByte == 1);
//			request.setAttribute("isPetAvailableForReservation", isPetAvailableForReservation);

            request.getRequestDispatcher("adoptedapplicationhibernate/add.jsp").forward(request, response);

        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        AdoptedApplicationHibernateService aahService = new AdoptedApplicationHibernateServiceImpl();

        if ("deleteCalendar".equals(action)) {
            String interactionDateStr = request.getParameter("interactionDate");
            String timeSlot = request.getParameter("timeSlot");
            Date interactionDate = Date.valueOf(interactionDateStr);

            LocalTime startTime = null;
            LocalTime endTime = null;
            switch (timeSlot) {
                case "morning":
                    startTime = LocalTime.of(9, 0);
                    endTime = LocalTime.of(12, 0);
                    break;
                case "afternoon":
                    startTime = LocalTime.of(14, 0);
                    endTime = LocalTime.of(17, 0);
                    break;
                case "night":
                    startTime = LocalTime.of(18, 0);
                    endTime = LocalTime.of(21, 0);
                    break;
            }

            List<AdoptedApplicationHibernate> applications = aahService.getApplicationsByDatedAndTime(interactionDate, startTime, endTime);
            for (AdoptedApplicationHibernate application : applications) {
                aahService.deleteApplication(application.getApplicationNo());
            }

            List<AdoptedApplicationHibernate> allReservations = aahService.getAllApplications();
            Map<Date, boolean[]> reservationMap = new HashMap<>();
            for (AdoptedApplicationHibernate reservation : allReservations) {
                Date date = reservation.getInteractionDate();
                LocalTime time = reservation.getInteractionTime();
                boolean[] reservedSlots = reservationMap.getOrDefault(date, new boolean[3]);
                if (time != null) {
                    int hour = time.getHour();
                    if (hour >= 9 && hour <= 12) reservedSlots[0] = true;
                    else if (hour >= 14 && hour <= 17) reservedSlots[1] = true;
                    else if (hour >= 18 && hour <= 21) reservedSlots[2] = true;
                }

                reservationMap.put(date, reservedSlots);
            }

            request.setAttribute("reservationMap", reservationMap);
            request.getRequestDispatcher("adoptedapplicationhibernate/showCalendar.jsp")
                    .forward(request, response);
        }

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
//			Date lotteryDate = Date.valueOf(request.getParameter("lotteryDate"));
            Integer lotteryResult = Integer.parseInt(request.getParameter("lotteryResult"));
            Date applicationDate = Date.valueOf(request.getParameter("applicationDate"));
            Date interactionDate = Date.valueOf(request.getParameter("interactionDate"));
            LocalTime interactionTime = LocalTime.parse(request.getParameter("interactionTime"));
            Integer applicationStat = Integer.parseInt(request.getParameter("applicationStat"));
            String applicantNotes = request.getParameter("applicantNotes");

//			Part filePart = request.getPart("signaturePhoto");
//			InputStream fileContent = filePart.getInputStream();
//			byte[] signaturePhotoBytes = IOUtils.toByteArray(fileContent);
            // 接收簽名數據
            String signatureImageData = request.getParameter("signaturePhoto");
            byte[] signaturePhotoBytes = Base64.getDecoder().decode(signatureImageData.split(",")[1]);

            AdoptedApplicationHibernate application = aahService.getApplicationById(applicationNo);
            application.setApplicationNo(applicationNo);
            application.setAdminNo(adminNo);
            application.setMemberNo(memberNo);
            application.setPetId(petId);
//			application.setLotteryDate(lotteryDate);
            application.setLotteryResult(lotteryResult);
            application.setApplicationDate(applicationDate);
            application.setInteractionDate(interactionDate);
            application.setInteractionTime(interactionTime);
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

            List<AdoptedApplicationHibernate> allReservations = aahService.getAllApplications();
            Map<Date, boolean[]> reservationMap = new HashMap<>();
            for (AdoptedApplicationHibernate reservation : allReservations) {
                Date date = reservation.getInteractionDate();
                LocalTime time = reservation.getInteractionTime();
                boolean[] reservedSlots = reservationMap.getOrDefault(date, new boolean[3]);
                if (time != null) {
                    int hour = time.getHour();
                    if (hour >= 9 && hour <= 12) reservedSlots[0] = true;
                    else if (hour >= 14 && hour <= 17) reservedSlots[1] = true;
                    else if (hour >= 18 && hour <= 21) reservedSlots[2] = true;
                }

                reservationMap.put(date, reservedSlots);
            }

            request.setAttribute("reservationMap", reservationMap);

//			PetVO randomPet = aahService.getRandomPet();
//			Byte petStatByte = randomPet.getStat();
//			boolean isPetAvailableForReservation = (petStatByte != null && petStatByte == 1);
//			request.setAttribute("isPetAvailableForReservation", isPetAvailableForReservation);

            request.getRequestDispatcher("adoptedapplicationhibernate/update.jsp")
                    .forward(request, response);
        }

        if ("add".equals(action)) {
            try {
                Integer adminNo = Integer.parseInt(request.getParameter("adminNo"));
                Integer memberNo = Integer.parseInt(request.getParameter("memberNo"));
                Integer petId = Integer.parseInt(request.getParameter("petId"));
//			Date lotteryDate = Date.valueOf(request.getParameter("lotteryDate"));
                Integer lotteryResult = Integer.parseInt(request.getParameter("lotteryResult"));
                Date applicationDate = Date.valueOf(request.getParameter("applicationDate"));
                Date interactionDate = Date.valueOf(request.getParameter("interactionDate"));
                LocalTime interactionTime = LocalTime.parse(request.getParameter("interactionTime"));
                Integer applicationStat = Integer.parseInt(request.getParameter("applicationStat"));
                String applicantNotes = request.getParameter("applicantNotes");

//			Part filePart = request.getPart("signaturePhoto");
//			InputStream fileContent = filePart.getInputStream();
//			byte[] signaturePhotoBytes = IOUtils.toByteArray(fileContent);
                // 接收簽名數據
                String signatureImageData = request.getParameter("signaturePhoto");
                byte[] signaturePhotoBytes = Base64.getDecoder().decode(signatureImageData.split(",")[1]);

                AdoptedApplicationHibernate application = new AdoptedApplicationHibernate();
                application.setAdminNo(adminNo);
                application.setMemberNo(memberNo);
                application.setPetId(petId);
//			application.setLotteryDate(lotteryDate);
                application.setLotteryResult(lotteryResult);
                application.setApplicationDate(applicationDate);
                application.setInteractionDate(interactionDate);
                application.setInteractionTime(interactionTime);
                application.setApplicationStat(applicationStat);
                application.setApplicantNotes(applicantNotes);
                application.setSignaturePhoto(signaturePhotoBytes);

                int applicationNo = aahService.addApplication(application);
                if (applicationNo == -1) {
                    request.getSession().setAttribute("addSuccess", false);
                } else {
                    request.setAttribute("applicationNo", applicationNo);
                    request.getSession().setAttribute("addSuccess", true);
                }
            } catch (Exception e) {
                request.getSession().setAttribute("addSuccess", false);
                e.printStackTrace();
            }
//			response.sendRedirect("adoptedApplicationHibernateServlet?action=getAll");
            request.getRequestDispatcher("adoptedapplicationhibernate/add.jsp")
                    .forward(request, response);
        }
    }
}

