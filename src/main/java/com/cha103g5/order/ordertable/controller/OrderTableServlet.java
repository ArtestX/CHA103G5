package com.cha103g5.order.ordertable.controller;


import com.cha103g5.order.ordertable.model.OrderTableVO;
import com.cha103g5.order.ordertable.service.OrderTableService;
import com.cha103g5.order.ordertable.service.OrderTableServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@WebServlet("/orderTableServlet")
public class OrderTableServlet extends HttpServlet {

	private OrderTableService otService;

	@Override
	public void init() throws ServletException {
		otService = new OrderTableServiceImpl();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String forwardPath = "";

		switch (action) {
			case "getOne":
				forwardPath = getOrderTableById(request, response);
				break;
			case "getAll":
				forwardPath = getAllOrderTables(request, response);
				break;
			case "getByMemberNo":
				forwardPath = getOrderTablesByMemberNo(request, response);
				break;
			case "compositeQuery":
				forwardPath = getOrderTablesByCompositeQuery(request, response);
				break;
			default:
				forwardPath = "/ordertable/index.jsp";
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
				forwardPath = deleteOrderTable(request, response);
				break;
			case "update":
				forwardPath = updateOrderTable(request, response);
				break;
			case "edit":
				forwardPath = editoption(request, response);
				break;
			case "add":
				forwardPath = addOrderTable(request, response);
				break;
			default:
				forwardPath = "/ordertable/index.jsp";
		}

		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}


	private String getOrderTableById(HttpServletRequest request, HttpServletResponse response) {
		String orderTableNoStr = request.getParameter("orderTableNo");
		if (orderTableNoStr.equals("")) {
			return this.getAllOrderTables(request, response);
		} else {
			Integer orderTableNo = Integer.parseInt(orderTableNoStr);
			OrderTableVO oneOrderTable = otService.getOrderTableById(orderTableNo);

			request.setAttribute("oneOrderTable", oneOrderTable);

			return "/ordertable/listOne.jsp";
		}
	}

	private String getAllOrderTables(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");
		int currentPage = (page == null) ? 1 : Integer.parseInt(page);
		System.out.println("1");
		List<OrderTableVO> allOrderTables = otService.getAllOrderTables(currentPage);
		System.out.println("2");
		if (request.getAttribute("orderTablesPageQty") == null) {
			int orderTablesPageQty = otService.getPageTotal();
			request.setAttribute("orderTablesPageQty", orderTablesPageQty);
		}
		request.setAttribute("allOrderTables", allOrderTables);
		request.setAttribute("currentPage", currentPage);

		return "/ordertable/listAll.jsp";
	}

	private String getOrderTablesByMemberNo(HttpServletRequest request, HttpServletResponse response) {
		String memberNoStr = request.getParameter("memberNo");
		if (memberNoStr.equals("")) {
			return this.getAllOrderTables(request, response);
		} else {
			Integer memberNo = Integer.parseInt(memberNoStr);
			List<OrderTableVO> someOrderTables = otService.getOrderTablesByMemberNo(memberNo);

			request.setAttribute("someOrderTables", someOrderTables);

			return "/ordertable/listSome.jsp";
		}
	}

	private String getOrderTablesByCompositeQuery(HttpServletRequest request, HttpServletResponse res) {
		Map<String, String[]> map = request.getParameterMap();
		if (map != null) {
			List<OrderTableVO> someOrderTables = otService.getOrderTablesByCompositeQuery(map);
			request.setAttribute("someOrderTables", someOrderTables);
		} else {
			return "/ordertable/index.jsp";
		}
		return "/ordertable/listSome.jsp";
	}

	private String deleteOrderTable(HttpServletRequest request, HttpServletResponse response) {
		Integer orderTableNo = Integer.parseInt(request.getParameter("orderTableNo"));
		otService.deleteOrderTable(orderTableNo);
		getAllOrderTables(request, response);

		return "/ordertable/listAll.jsp";
	}

	private String updateOrderTable(HttpServletRequest request, HttpServletResponse response) {
		Integer orderTableNo = Integer.parseInt(request.getParameter("orderTableNo"));

		Integer memberNo = Integer.parseInt(request.getParameter("memberNo"));
		Integer totalAmount = Integer.parseInt(request.getParameter("totalAmount"));
		Byte orderStat = Byte.parseByte(request.getParameter("orderStat"));
		Byte paymentMethod = Byte.parseByte(request.getParameter("paymentMethod"));
		Byte shipMethod = Byte.parseByte(request.getParameter("shipMethod"));

		OrderTableVO orderTable = otService.getOrderTableById(orderTableNo);
		orderTable.setMemberNo(memberNo);
		orderTable.setTotalAmount(totalAmount);
		orderTable.setOrderStat(orderStat);
		orderTable.setPaymentMethod(paymentMethod);
		orderTable.setShipMethod(shipMethod);
		otService.updateOrderTable(orderTable);
		getAllOrderTables(request, response);
		return "/ordertable/listAll.jsp";
	}

	private String editoption(HttpServletRequest request, HttpServletResponse response) {
		Integer orderTableNo = Integer.parseInt(request.getParameter("orderTableNo"));
		OrderTableVO orderTable = otService.getOrderTableById(orderTableNo);
		request.setAttribute("orderTable", orderTable);

		return "/ordertable/update.jsp";
	}

	private String addOrderTable(HttpServletRequest request, HttpServletResponse response) {
		Integer memberNo = Integer.parseInt(request.getParameter("memberNo"));

		SimpleDateFormat orderTimeSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String orderTimeStr = orderTimeSDF.format(new java.util.Date());
		Timestamp orderTime = Timestamp.valueOf(orderTimeStr);

		Integer totalAmount = Integer.parseInt(request.getParameter("totalAmount"));
		Byte orderStat = Byte.parseByte(request.getParameter("orderStat"));
		Byte paymentMethod = Byte.parseByte(request.getParameter("paymentMethod"));
		Byte shipMethod = Byte.parseByte(request.getParameter("shipMethod"));

		OrderTableVO orderTable = new OrderTableVO();
		orderTable.setMemberNo(memberNo);
		orderTable.setOrderTime(orderTime);
		orderTable.setTotalAmount(totalAmount);
		orderTable.setOrderStat(orderStat);
		orderTable.setPaymentMethod(paymentMethod);
		orderTable.setShipMethod(shipMethod);

		otService.addOrderTable(orderTable);
		getAllOrderTables(request, response);

		return "/ordertable/listAll.jsp";
	}

}

