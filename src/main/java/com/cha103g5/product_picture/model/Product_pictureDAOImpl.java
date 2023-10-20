package com.cha103g5.product_picture.model;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.cha103g5.util.HibernateUtil;

public class Product_pictureDAOImpl implements Product_pictureDAO {

	private static final int PAGE_MAX_RESULT = 10;
	private SessionFactory factory;

	public Product_pictureDAOImpl() {
		this.factory = HibernateUtil.getSessionFactory();
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public int insert(Product_picture entity) {
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
	public int update(Product_picture entity) {
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
		Product_picture productpicture = session.get(Product_picture.class, id);
		try {
			session.beginTransaction();
			if (productpicture != null) {
				session.delete(productpicture);
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
	public Product_picture getById(Integer id) {
		Session session = getSession();
		try {
			session.beginTransaction();
			Product_picture productpicture = session.get(Product_picture.class, id);
			session.getTransaction().commit();
			return productpicture;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<Product_picture> getAll() {
		Session session = getSession();
		try {
			session.beginTransaction();
			List<Product_picture> list = session.createQuery("from Product_picture", Product_picture.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<Product_picture> getByCompositeQuery(Map<String, String> map) {
		return null;
	}

	@Override
	public List<Product_picture> getAll(int currentPage) {
		return null;
	}

	@Override
	public long getTotal() {
		return 0;
	}

}
