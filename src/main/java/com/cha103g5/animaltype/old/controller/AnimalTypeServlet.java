//package com.cha103g5.animaltype.old.controller;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.cha103g5.animaltype.old.model.AnimalType;
//import com.cha103g5.animaltype.old.model.AnimalTypeService;
//
//@WebServlet("/animalTypeServlet")
//public class AnimalTypeServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    private AnimalTypeService animalTypeService = new AnimalTypeService();
//
////    public void doGet(HttpServletRequest request, HttpServletResponse response)
////    		throws ServletException, IOException {
////
////    	request.setCharacterEncoding("UTF-8");
////    	response.setCharacterEncoding("UTF-8");
////
////        String action = request.getParameter("ACTION");
////
////        if ("getAll".equals(action)) {
////            List<AnimalType> list = animalTypeService.getAll();
////            request.setAttribute("animalTypes", list);
////            request.getRequestDispatcher("/showAnimalTypes.jsp").forward(request, response);
////
////
////        }
////        else if ("getByName".equals(action)) {
////            String name = request.getParameter("name");
////            AnimalType animalType = animalTypeService.getByName(name);
////            request.setAttribute("animalType", animalType);
////            request.getRequestDispatcher("/showAnimalType.jsp").forward(request, response);
////
////
////        }
////    }
//
//    public void doPost(HttpServletRequest request, HttpServletResponse response)
//    		throws ServletException, IOException {
//
//    	request.setCharacterEncoding("UTF-8");
//    	response.setCharacterEncoding("UTF-8");
//
//        String action = request.getParameter("action");
//
//        if ("add".equals(action)) {
//            String name = request.getParameter("animalTypeName");
//            AnimalType newAnimalType = animalTypeService.add(name);
//            response.sendRedirect(request.getContextPath() + "/animaltype/listAllAnimalType.jsp");
//        }
//        if ("getOne_For_Update".equals(action)) {
//            String oldAnimalTypeName = request.getParameter("animalTypeName");
//            AnimalType animalType = animalTypeService.getByName(oldAnimalTypeName);
//            request.setAttribute("animalType", animalType);
//            request.getRequestDispatcher("/animaltype/update_petTypeName_input.jsp").forward(request, response);
//        }
//        if ("update".equals(action)) {
//            String newName = request.getParameter("newAnimalTypeName");
//            String oldName = request.getParameter("oldAnimalTypeName");
//            animalTypeService.update(newName, oldName);
//            response.sendRedirect(request.getContextPath() + "/animaltype/listAllAnimalType.jsp");
//        }
//        if ("delete".equals(action)) {
//        	String name = request.getParameter("animalTypeName");
//            System.out.println(name);
//            animalTypeService.delete(name);
//            response.sendRedirect(request.getContextPath() + "/animaltype/listAllAnimalType.jsp");
//        }
//    }
//}
