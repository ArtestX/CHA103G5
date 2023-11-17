package com.cha103g5.order.ordertable.dao;

import com.cha103g5.order.ordertable.model.OrderTableVO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.cha103g5.order.util.Constants.PAGE_MAX_RESULT;

public class OrderTableDaoImpl implements OrderTableDao{

    private SessionFactory factory;
    public OrderTableDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }
    private Session getSession() {
        return factory.getCurrentSession();
    }

    @Override
    public int add(OrderTableVO orderTableVO) {
        try {
            int orderTableNo = (Integer) getSession().save(orderTableVO);
            return orderTableNo;
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public int update(OrderTableVO orderTableVO) {
        try {
            getSession().update(orderTableVO);
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public int delete(Integer orderTableNo) {
        OrderTableVO orderTableVO = getSession().get(OrderTableVO.class, orderTableNo);
        if (orderTableVO != null) {
            getSession().delete(orderTableVO);
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public OrderTableVO getById(Integer orderTableNo) {
        return getSession().get(OrderTableVO.class, orderTableNo);
    }

    @Override
    public List<OrderTableVO> getAll() {
        return getSession().createQuery("from OrderTableVO", OrderTableVO.class).list();
    }

    @Override
    public List<OrderTableVO> getAll(int currentPage) {
        int first = (currentPage - 1) * PAGE_MAX_RESULT;
        return getSession().createQuery("from OrderTableVO", OrderTableVO.class)
                .setFirstResult(first)
                .setMaxResults(PAGE_MAX_RESULT)
                .list();
    }

    @Override
    public List<OrderTableVO> getByMemberNo(int memberNo) {
        String hql = "FROM OrderTableVO WHERE memberNo = :memberNo";
        Query<OrderTableVO> query = getSession().createQuery(hql, OrderTableVO.class);
        query.setParameter("memberNo", memberNo);
        return query.getResultList();
    }

    @Override
    public List<OrderTableVO> getByCompositeQuery(Map<String, String> map) {
        if (map.size() == 0)
            return getAll();

        CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
        CriteriaQuery<OrderTableVO> criteriaQuery = criteriaBuilder.createQuery(OrderTableVO.class);
        Root<OrderTableVO> root = criteriaQuery.from(OrderTableVO.class);
        List<Predicate> predicates = new ArrayList<>();

        if (map.containsKey("startOrderDate") && map.containsKey("endOrderDate")) {
            String startOrderDateStr = map.get("startOrderDate")+ " 00:00:00";
            Timestamp startOrderDate = Timestamp.valueOf(startOrderDateStr);
            String endOrderDateStr = map.get("endOrderDate")+ " 00:00:00";
            Timestamp endOrderDate = Timestamp.valueOf(endOrderDateStr);
            predicates.add(criteriaBuilder
                    .between(root.get("orderTime"), startOrderDate, endOrderDate));
        }
        else if (map.containsKey("startOrderDate") && (!map.containsKey("endOrderDate")) ) {
            String startOrderDateStr = map.get("startOrderDate")+ " 00:00:00";
            Timestamp startOrderDate = Timestamp.valueOf(startOrderDateStr);

            predicates.add(criteriaBuilder
                    .greaterThanOrEqualTo(root.get("orderTime"), startOrderDate));
        }
        else if (map.containsKey("endOrderDate") && (!map.containsKey("startOrderDate")) ) {
            String endOrderDateStr = map.get("endOrderDate")+ " 00:00:00";
            Timestamp endOrderDate = Timestamp.valueOf(endOrderDateStr);

            predicates.add(criteriaBuilder
                    .lessThanOrEqualTo(root.get("orderTime"), endOrderDate));
        }

        if (map.containsKey("memberNo")) {
            String memberNoStr = map.get("memberNo");
            int memberNo = Integer.valueOf(memberNoStr);

            predicates.add(criteriaBuilder.
                    equal(root.get("memberNo"), memberNo));
        }

        if (map.containsKey("orderStat")) {
            String orderStatStr = map.get("orderStat");
            int orderStat = Integer.valueOf(orderStatStr);

            predicates.add(criteriaBuilder.
                    equal(root.get("orderStat"), orderStat));
        }

        if (map.containsKey("shipMethod")) {
            String shipMethodStr = map.get("shipMethod");
            int shipMethod = Integer.valueOf(shipMethodStr);

            predicates.add(criteriaBuilder.
                    equal(root.get("shipMethod"), shipMethod));
        }

        criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
        TypedQuery<OrderTableVO> query = getSession().createQuery(criteriaQuery);

        return query.getResultList();
    }

    @Override
    public long getTotal() {
        return getSession().createQuery("select count(*) from OrderTableVO", Long.class).uniqueResult();
    }

}
