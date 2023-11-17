//package com.cha103g5.ordertable.model;
//
//import java.util.List;
//import java.util.Map;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
//import com.cha103g5.util.HibernateUtil;
//
//public class OrderTableDAOImpl implements OrderTableDAO {
//
//	private static final int PAGE_MAX_RESULT = 10;
//	private SessionFactory factory;
//
//	public OrderTableDAOImpl() {
//		this.factory = HibernateUtil.getSessionFactory();
//	}
//
//	private Session getSession() {
//		return factory.getCurrentSession();
//	}
//
//	@Override
//	public int insert(OrderTable entity) {
//		Session session = getSession();
//		try {
//			session.beginTransaction();
//			Integer id = (Integer) session.save(entity);
//			session.getTransaction().commit();
//			return id;
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//		return -1;
//	}
//
//	@Override
//	public int update(OrderTable entity) {
//		Session session = getSession();
//		try {
//			session.beginTransaction();
//			session.update(entity);
//			session.getTransaction().commit();
//			return 1;
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//		return -1;
//	}
//
//	@Override
//	public int delete(Integer id) {
//		Session session = getSession();
//		OrderTable Order = session.get(OrderTable.class, id);
//		try {
//			session.beginTransaction();
//			if (Order != null) {
//				session.delete(Order);
//				session.getTransaction().commit();
//				return 1;
//			} else {
//				session.getTransaction().commit();
//				return -1;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//			return -1;
//		}
//	}
//
//	@Override
//	public OrderTable getById(Integer id) {
//		Session session = getSession();
//		try {
//			session.beginTransaction();
//			OrderTable Order = session.get(OrderTable.class, id);
//			session.getTransaction().commit();
//			return Order;
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//		return null;
//	}
//
//	@Override
//	public List<OrderTable> getAll() {
//	    Session session = getSession();
//	    try {
//	        session.beginTransaction();
//	        List<OrderTable> list = session.createQuery("from OrderTable", OrderTable.class).list();
//	        session.getTransaction().commit();
//	        return list;
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        session.getTransaction().rollback();
//	    }
//	    return null;
//	}
//
//
//	@Override
//	public List<OrderTable> getByCompositeQuery(Map<String, String> map) {
//		return null;
//	}
//
//	@Override
//	public List<OrderTable> getAll(int currentPage) {
//		return null;
//	}
//
//	@Override
//	public long getTotal() {
//		return 0;
//	}
//
//}