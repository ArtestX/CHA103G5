package com.cha103g5.report.model;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cha103g5.util.HibernateUtil;

public class ReportDAOImpl implements ReportDAO {

	private static final int PAGE_MAX_RESULT = 10;
	private SessionFactory factory;

	public ReportDAOImpl() {
		this.factory = HibernateUtil.getSessionFactory();
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public int insert(Report entity) {
		Session session = getSession();
		try {
			session.beginTransaction();
			Integer id = (Integer) session.save(entity);
			session.getTransaction().commit();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public int update(Report entity) {
		Session session = getSession();
		try {
			session.beginTransaction();
			session.update(entity);
			session.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public int delete(Integer id) {
		Session session = getSession();
		Report report = session.get(Report.class, id);
		try {
			session.beginTransaction();
			if (report != null) {
				session.delete(report);
				session.getTransaction().commit();
				return 1;
			} else {
				session.getTransaction().commit();
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return -1;
		}
	}

	@Override
	public Report getById(Integer id) {
		Session session = getSession();
		try {
			session.beginTransaction();
			Report report = session.get(Report.class, id);
			session.getTransaction().commit();
			return report;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<Report> getAll() {
		Session session = getSession();
		try {
			session.beginTransaction();
			List<Report> list = session.createQuery("from Report", Report.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<Report> getByCompositeQuery(Map<String, String> map) {
		return null;
	}

	@Override
	public List<Report> getAll(int currentPage) {
		return null;
	}

	@Override
	public long getTotal() {
		return 0;
	}

}