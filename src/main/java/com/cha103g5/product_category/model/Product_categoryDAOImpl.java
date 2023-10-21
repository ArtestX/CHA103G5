package com.cha103g5.product_category.model;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cha103g5.util.HibernateUtil;

public class Product_categoryDAOImpl implements Product_categoryDAO {

	private static final int PAGE_MAX_RESULT = 10;
	private SessionFactory factory;

	public Product_categoryDAOImpl() {
		this.factory = HibernateUtil.getSessionFactory();
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public int insert(Product_category entity) {
		Session session = getSession();
		try {
			session.beginTransaction();
			Integer id = (Integer) session.save(entity);
			session.getTransaction().commit();
			return id;
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public int update(Product_category entity) {
		Session session = getSession();
		try {
			session.beginTransaction();
			session.update(entity);
			session.getTransaction().commit();
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	 public int delete(Integer id) {
        Session session = getSession();
        Product_category productCategory = session.get(Product_category.class, id);
        try {
            session.beginTransaction();
            if (productCategory != null) {
                session.delete(productCategory);
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
	public Product_category getById(Integer id) {
		Session session = getSession();
		try {
			session.beginTransaction();
			Product_category productcategory = session.get(Product_category.class,id);
			session.getTransaction().commit();
			return productcategory;
		}catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<Product_category> getAll() {
		Session session = getSession();
		try {
			session.beginTransaction();
			List<Product_category> list = session.createQuery("from Product_category", Product_category.class).list();
			session.getTransaction().commit();
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<Product_category> getByCompositeQuery(Map<String, String> map) {
		return null;
	}

	@Override
	public List<Product_category> getAll(int currentPage) {
		return null;
	}

	@Override
	public long getTotal() {
		return 0;
	}
	
	
	
	
}
