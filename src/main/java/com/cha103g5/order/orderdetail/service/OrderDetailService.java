package com.cha103g5.order.orderdetail.service;

import com.cha103g5.order.orderdetail.model.OrderDetailVO;

import java.util.List;
import java.util.Map;

public interface OrderDetailService {

    int addOrderDetail(OrderDetailVO orderDetailVO);
    int updateOrderDetail(OrderDetailVO orderDetailVO);
    int deleteOrderDetail(Integer orderDetailNo);
    OrderDetailVO getOrderDetailById(Integer orderDetailNo);
    List<OrderDetailVO> getAllOrderDetails();
    List<OrderDetailVO> getAllOrderDetails(int currentPage);
    List<OrderDetailVO> getOrderDetailsByOrderTableNo(Integer orderTableNo);
    List<OrderDetailVO> getOrderDetailsByCompositeQuery(Map<String, String[]> map);
    int getPageTotal();

}
