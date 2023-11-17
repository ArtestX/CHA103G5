package com.cha103g5.order.orderdetail.dao;

import com.cha103g5.order.orderdetail.model.OrderDetailVO;

import java.util.List;
import java.util.Map;

public interface OrderDetailDao {

    int add(OrderDetailVO orderDetailVO);
    int update(OrderDetailVO orderDetailVO);
    int delete(Integer orderDetailNo);
    OrderDetailVO getById(Integer orderDetailNo);
    List<OrderDetailVO> getAll();
    List<OrderDetailVO> getAll(int currentPage);
    List<OrderDetailVO> getByOrderTableNo(Integer orderTableNo);
    List<OrderDetailVO> getByCompositeQuery(Map<String, String> map);
    long getTotal();

}
