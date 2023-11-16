package com.cha103g5.order.ordertable.service;

import com.cha103g5.order.ordertable.dao.OrderTableDao;
import com.cha103g5.order.ordertable.dao.OrderTableDaoImpl;
import com.cha103g5.order.ordertable.model.OrderTableVO;
import com.cha103g5.util.HibernateUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.cha103g5.adoptedapplicationhibernate.util.Constants.PAGE_MAX_RESULT;

public class OrderTableServiceImpl implements OrderTableService{

    private OrderTableDao dao;
    public OrderTableServiceImpl() {
        dao = new OrderTableDaoImpl(HibernateUtil.getSessionFactory());
    }

    @Override
    public int addOrderTable(OrderTableVO orderTableVO) {
        return dao.add(orderTableVO);
    }

    @Override
    public int updateOrderTable(OrderTableVO orderTableVO) {
        return dao.update(orderTableVO);
    }

    @Override
    public int deleteOrderTable(Integer orderTableNo) {
        return dao.delete(orderTableNo);
    }

    @Override
    public OrderTableVO getOrderTableById(Integer orderTableNo) {
        return dao.getById(orderTableNo);
    }

    @Override
    public List<OrderTableVO> getAllOrderTables() {
        return dao.getAll();
    }

    @Override
    public List<OrderTableVO> getAllOrderTables(int currentPage) {
        return dao.getAll(currentPage);
    }

    @Override
    public List<OrderTableVO> getOrderTablesByMemberNo(Integer memberNo) {
        List<OrderTableVO> orderTables = dao.getByMemberNo(memberNo);
        return orderTables;
    }

    @Override
    public List<OrderTableVO> getOrderTablesByCompositeQuery(Map<String, String[]> map) {
        Map<String, String> query = new HashMap<>();
        Set<Map.Entry<String, String[]>> entry = map.entrySet();
        for (Map.Entry<String, String[]> row : entry) {
            String key = row.getKey();
            if ("action".equals(key)) {
                continue;
            }
            String value = row.getValue()[0];
            if (value == null || value.isEmpty()) {
                continue;
            }
            query.put(key, value);
        }
        System.out.println("query: " + query);
        return dao.getByCompositeQuery(query);
    }

    @Override
    public int getPageTotal() {
        long total = dao.getTotal();
        int pageQty = (int)(total % PAGE_MAX_RESULT == 0 ? (total / PAGE_MAX_RESULT) : (total / PAGE_MAX_RESULT + 1));
        return pageQty;
    }

}
