package com.cha103g5.order.orderdetail.service;

import com.cha103g5.order.orderdetail.dao.OrderDetailDao;
import com.cha103g5.order.orderdetail.dao.OrderDetailDaoImpl;
import com.cha103g5.order.orderdetail.model.OrderDetailVO;
import com.cha103g5.util.HibernateUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.cha103g5.adoptedapplicationhibernate.util.Constants.PAGE_MAX_RESULT;

public class OrderDetailServiceImpl implements OrderDetailService{

    private OrderDetailDao dao;
    public OrderDetailServiceImpl() {
        dao = new OrderDetailDaoImpl(HibernateUtil.getSessionFactory());
    }

    @Override
    public int addOrderDetail(OrderDetailVO orderDetailVO) {
        return dao.add(orderDetailVO);
    }

    @Override
    public int updateOrderDetail(OrderDetailVO orderDetailVO) {
        return dao.update(orderDetailVO);
    }

    @Override
    public int deleteOrderDetail(Integer orderDetailNo) {
        return dao.delete(orderDetailNo);
    }

    @Override
    public OrderDetailVO getOrderDetailById(Integer orderDetailNo) {
        return dao.getById(orderDetailNo);
    }

    @Override
    public List<OrderDetailVO> getAllOrderDetails() {
        return dao.getAll();
    }

    @Override
    public List<OrderDetailVO> getAllOrderDetails(int currentPage) {
        return dao.getAll(currentPage);
    }

    @Override
    public List<OrderDetailVO> getOrderDetailsByOrderTableNo(Integer orderTableNo) {
        List<OrderDetailVO> orderDetails = dao.getByOrderTableNo(orderTableNo);
        return orderDetails;
    }

    @Override
    public List<OrderDetailVO> getOrderDetailsByCompositeQuery(Map<String, String[]> map) {
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
