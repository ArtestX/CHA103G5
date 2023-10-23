package com.cha103g5.admin.model;

import com.cha103g5.admin.model.AdminVO;
import org.hibernate.Session;
import com.cha103g5.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class AdminHibernateDAO implements AdminHibernateDAOInterface {

	// SessionFactory 為 thread-safe，可宣告為屬性讓請求執行緒們共用
	private SessionFactory factory;

	public AdminHibernateDAO(SessionFactory factory) {
		this.factory = factory;
	}

	// Session 為 not thread-safe，所以此方法在各個增刪改查方法裡呼叫
	// 以避免請求執行緒共用了同個 Session
	private Session getSession() {
		return factory.getCurrentSession();
	}
	@Override
	public int insert(AdminVO adminVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.save(adminVO);
			session.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return -1;
	}

	@Override
	public int update(AdminVO adminVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.update(adminVO);
			session.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return -1;
	}

	@Override
	public void delete(Integer adminNo) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			AdminVO adminVO = session.get(AdminVO.class, adminNo);
			if (adminVO != null) {
				session.delete(adminVO);
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

	}

	@Override
	public AdminVO findByPrimaryKey(Integer adminNo) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			AdminVO adminVO = session.get(AdminVO.class, adminNo);
			session.getTransaction().commit();
			return adminVO;
		}catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return null;
	}
	
	public AdminVO findByNamePassword(String adminAccount, String adminPassword) {
	    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    try {
	        session.beginTransaction();
	        
	        String hql = "from AdminVO where adminAccount = :account and adminPassword = :password";
	        Query<AdminVO> query = session.createQuery(hql, AdminVO.class);
	        query.setParameter("account", adminAccount);
	        query.setParameter("password", adminPassword);
	        
	        AdminVO adminVO = query.uniqueResult(); // Assuming there should be only one matching user.
	        
	        session.getTransaction().commit();
	        return adminVO;
	    } catch (Exception e) {
	        e.printStackTrace();
	        session.getTransaction().rollback();
	    } finally {
	        if (session != null && session.isOpen()) {
	            session.close();
	        }
	    }
	    return null;
	}


	@Override
	public List<AdminVO> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<AdminVO> list = session.createQuery("from AdminVO", AdminVO.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

}
