package com.cha103g5.order.ordertable.service;

import com.cha103g5.order.ordertable.model.OrderTableVO;

import java.util.List;
import java.util.Map;

public interface OrderTableService {

    int addOrderTable(OrderTableVO orderTableVO);
    int updateOrderTable(OrderTableVO orderTableVO);
    int deleteOrderTable(Integer orderTableNo);
    OrderTableVO getOrderTableById(Integer orderTableNo);
    List<OrderTableVO> getAllOrderTables();
    List<OrderTableVO> getAllOrderTables(int currentPage);
    List<OrderTableVO> getOrderTablesByMemberNo(Integer memberNo);
    List<OrderTableVO> getOrderTablesByCompositeQuery(Map<String, String[]> map);
    int getPageTotal();

}
