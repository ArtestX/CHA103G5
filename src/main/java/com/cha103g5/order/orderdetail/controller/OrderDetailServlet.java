package com.cha103g5.order.orderdetail.controller;


import com.cha103g5.order.orderdetail.model.OrderDetailVO;
import com.cha103g5.order.orderdetail.service.OrderDetailService;
import com.cha103g5.order.orderdetail.service.OrderDetailServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/orderDetailServlet")
public class OrderDetailServlet extends HttpServlet {

	private OrderDetailService odService;

	@Override
	public void init() throws ServletException {
		odService = new OrderDetailServiceImpl();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String forwardPath = "";

		switch (action) {
			case "getOne":
				forwardPath = getOrderDetailById(request, response);
				break;
			case "getAll":
				forwardPath = getAllOrderDetails(request, response);
				break;
			case "getByOrderTableNo":
				forwardPath = getOrderDetailsByOrderTableNo(request, response);
				break;
			case "compositeQuery":
				forwardPath = getOrderDetailsByCompositeQuery(request, response);
				break;
			case "getByOrderTableNoFrontend":
				forwardPath = getOrderDetailsByOrderTableNoFrontend(request, response);
				break;
			default:
				forwardPath = "/orderdetail/index.jsp";
		}

		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String forwardPath = "";
		switch (action) {
			case "delete":
				forwardPath = deleteOrderDetail(request, response);
				break;
			case "update":
				forwardPath = updateOrderDetail(request, response);
				break;
			case "edit":
				forwardPath = editoption(request, response);
				break;
			case "add":
				forwardPath = addOrderDetail(request, response);
				break;
			default:
				forwardPath = "/orderdetail/index.jsp";
		}

		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}


	private String getOrderDetailById(HttpServletRequest request, HttpServletResponse response) {
		String orderDetailNoStr = request.getParameter("orderDetailNo");
		if (orderDetailNoStr.equals("")) {
			return this.getAllOrderDetails(request, response);
		} else {
			Integer orderDetailNo = Integer.parseInt(orderDetailNoStr);
			OrderDetailVO oneOrderDetail = odService.getOrderDetailById(orderDetailNo);

			request.setAttribute("oneOrderDetail", oneOrderDetail);

			return "/orderdetail/listOne.jsp";
		}
	}

	private String getAllOrderDetails(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");
		int currentPage = (page == null) ? 1 : Integer.parseInt(page);

		List<OrderDetailVO> allOrderDetails = odService.getAllOrderDetails(currentPage);
		if (request.getAttribute("orderDetailsPageQty") == null) {
			int orderDetailsPageQty = odService.getPageTotal();
			request.setAttribute("orderDetailsPageQty", orderDetailsPageQty);
		}
		request.setAttribute("allOrderDetails", allOrderDetails);
		request.setAttribute("currentPage", currentPage);

		return "/orderdetail/listAll.jsp";
	}

	private String getOrderDetailsByOrderTableNo(HttpServletRequest request, HttpServletResponse response) {
		String orderTableNoStr = request.getParameter("orderTableNo");
		if (orderTableNoStr.equals("")) {
			return this.getAllOrderDetails(request, response);
		} else {
			Integer orderTableNo = Integer.parseInt(orderTableNoStr);
			List<OrderDetailVO> someOrderDetails = odService.getOrderDetailsByOrderTableNo(orderTableNo);

			request.setAttribute("someOrderDetails", someOrderDetails);

			return "/orderdetail/listSome.jsp";
		}
	}

	private String getOrderDetailsByOrderTableNoFrontend(HttpServletRequest request, HttpServletResponse response) {
		String orderTableNoStr = request.getParameter("currentOrderTableNo");
		if (orderTableNoStr.equals("")) {
			return null;
		} else {
			Integer orderTableNo = Integer.parseInt(orderTableNoStr);
			List<OrderDetailVO> someOrderDetails = odService.getOrderDetailsByOrderTableNo(orderTableNo);

			request.setAttribute("someOrderDetails", someOrderDetails);
			request.setAttribute("orderDetailIncludePath", "../orderdetail/listSomeOrderDetailFrontend.jsp");

			return "orderdetail/listSomeOrderDetailFrontend.jsp";
		}
	}

	private String getOrderDetailsByCompositeQuery(HttpServletRequest request, HttpServletResponse res) {
		Map<String, String[]> map = request.getParameterMap();
		if (map != null) {
			List<OrderDetailVO> someOrderDetails = odService.getOrderDetailsByCompositeQuery(map);
			request.setAttribute("someOrderDetails", someOrderDetails);
		} else {
			return "/orderdetail/index.jsp";
		}
		return "/orderdetail/listSome.jsp";
	}

	private String deleteOrderDetail(HttpServletRequest request, HttpServletResponse response) {
		Integer orderDetailNo = Integer.parseInt(request.getParameter("orderDetailNo"));
		odService.deleteOrderDetail(orderDetailNo);
		getAllOrderDetails(request, response);

		return "/orderdetail/listAll.jsp";
	}

	private String updateOrderDetail(HttpServletRequest request, HttpServletResponse response) {
		Integer orderDetailNo = Integer.parseInt(request.getParameter("orderDetailNo"));
		Integer orderTableNo = Integer.parseInt(request.getParameter("orderTableNo"));
		Integer productNo = Integer.parseInt(request.getParameter("productNo"));
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		Integer productPrice = Integer.parseInt(request.getParameter("productPrice"));

		OrderDetailVO orderDetail = odService.getOrderDetailById(orderDetailNo);
		orderDetail.setOrderDetailNo(orderDetailNo);
		orderDetail.setOrderTableNo(orderTableNo);
		orderDetail.setProductNo(productNo);
		orderDetail.setQuantity(quantity);
		orderDetail.setProductPrice(productPrice);
		odService.updateOrderDetail(orderDetail);
		getAllOrderDetails(request, response);
		return "/orderdetail/listAll.jsp";
	}

	private String editoption(HttpServletRequest request, HttpServletResponse response) {
		Integer orderDetailNo = Integer.parseInt(request.getParameter("orderDetailNo"));
		OrderDetailVO orderDetail = odService.getOrderDetailById(orderDetailNo);
		request.setAttribute("orderDetail", orderDetail);

		return "/orderdetail/update.jsp";
	}

	private String addOrderDetail(HttpServletRequest request, HttpServletResponse response) {
		Integer orderTableNo = Integer.parseInt(request.getParameter("orderTableNo"));
		Integer productNo = Integer.parseInt(request.getParameter("productNo"));
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		Integer productPrice = Integer.parseInt(request.getParameter("productPrice"));

		OrderDetailVO orderDetail = new OrderDetailVO();
		orderDetail.setOrderTableNo(orderTableNo);
		orderDetail.setProductNo(productNo);
		orderDetail.setQuantity(quantity);
		orderDetail.setProductPrice(productPrice);

		odService.addOrderDetail(orderDetail);
		getAllOrderDetails(request, response);

		return "/orderdetail/listAll.jsp";
	}

}

