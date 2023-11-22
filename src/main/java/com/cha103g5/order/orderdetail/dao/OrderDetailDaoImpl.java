package com.cha103g5.order.orderdetail.dao;

import com.cha103g5.order.orderdetail.model.OrderDetailVO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.cha103g5.order.util.Constants.PAGE_MAX_RESULT;

public class OrderDetailDaoImpl implements OrderDetailDao{

    private SessionFactory factory;
    public OrderDetailDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }
    private Session getSession() {
        return factory.getCurrentSession();
    }

    @Override
    public int add(OrderDetailVO orderDetailVO) {
        try {
            int orderDetailNo = (Integer) getSession().save(orderDetailVO);
            return orderDetailNo;
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public int update(OrderDetailVO orderDetailVO) {
        try {
            getSession().update(orderDetailVO);
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public int delete(Integer orderDetailNo) {
        OrderDetailVO orderDetailVO = getSession().get(OrderDetailVO.class, orderDetailNo);
        if (orderDetailVO != null) {
            getSession().delete(orderDetailVO);
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public OrderDetailVO getById(Integer orderDetailNo) {
        return getSession().get(OrderDetailVO.class, orderDetailNo);
    }

    @Override
    public List<OrderDetailVO> getAll() {
        return getSession().createQuery("from OrderDetailVO", OrderDetailVO.class).list();
    }

    @Override
    public List<OrderDetailVO> getAll(int currentPage) {
        int first = (currentPage - 1) * PAGE_MAX_RESULT;
        return getSession().createQuery("from OrderDetailVO", OrderDetailVO.class)
                .setFirstResult(first)
                .setMaxResults(PAGE_MAX_RESULT)
                .list();
    }

    @Override
    public List<OrderDetailVO> getByOrderTableNo(Integer orderTableNo) {
        String hql = "FROM OrderDetailVO WHERE orderTableNo = :orderTableNo";
        Query<OrderDetailVO> query = getSession().createQuery(hql, OrderDetailVO.class);
        query.setParameter("orderTableNo", orderTableNo);
        return query.getResultList();
    }

    @Override
    public List<OrderDetailVO> getByCompositeQuery(Map<String, String> map) {
        if (map.size() == 0)
            return getAll();

        CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
        CriteriaQuery<OrderDetailVO> criteriaQuery = criteriaBuilder.createQuery(OrderDetailVO.class);
        Root<OrderDetailVO> root = criteriaQuery.from(OrderDetailVO.class);
        List<Predicate> predicates = new ArrayList<>();

        if (map.containsKey("orderTableNo")) {
            String orderTableNoStr = map.get("orderTableNo");
            int orderTableNo = Integer.valueOf(orderTableNoStr);

            predicates.add(criteriaBuilder
                    .equal(root.get("orderTableNo"), orderTableNo));
        }

        if (map.containsKey("productNo")) {
            String productNoStr = map.get("productNo");
            int productNo = Integer.valueOf(productNoStr);

            predicates.add(criteriaBuilder
                    .equal(root.get("productNo"), productNo));
        }

        criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
        TypedQuery<OrderDetailVO> query = getSession().createQuery(criteriaQuery);

        return query.getResultList();
    }

    @Override
    public long getTotal() {
        return getSession().createQuery("select count(*) from OrderDetailVO", Long.class).uniqueResult();
    }

}
