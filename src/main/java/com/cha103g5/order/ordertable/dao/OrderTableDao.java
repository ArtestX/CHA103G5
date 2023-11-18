package com.cha103g5.order.ordertable.dao;

import com.cha103g5.order.ordertable.model.OrderTableVO;

import java.util.List;
import java.util.Map;

public interface OrderTableDao {

    int add(OrderTableVO orderTableVO);
    int update(OrderTableVO orderTableVO);
    int delete(Integer orderTableNo);
    OrderTableVO getById(Integer orderTableVO);
    List<OrderTableVO> getAll();
    List<OrderTableVO> getAll(int currentPage);
    List<OrderTableVO> getByMemberNo(int memberNo);
    List<OrderTableVO> getByCompositeQuery(Map<String, String> map);
    long getTotal();

}
