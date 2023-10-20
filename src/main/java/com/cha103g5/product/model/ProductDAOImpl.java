package com.cha103g5.product.model;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cha103g5.util.HibernateUtil;

public class ProductDAOImpl implements ProductDAO {

    private static final int PAGE_MAX_RESULT = 10;
    private SessionFactory factory;

    public ProductDAOImpl() {
        this.factory = HibernateUtil.getSessionFactory();
    }

    private Session getSession() {
        return factory.getCurrentSession();
    }

    @Override
    public int insert(Product entity) {
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
    public int update(Product entity) {
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
        Product product = session.get(Product.class, id);
        try {
            session.beginTransaction();
            if (product != null) {
                session.delete(product);
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
    public Product getById(Integer id) {
        Session session = getSession();
        try {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public List<Product> getAll() {
        Session session = getSession();
        try {
            session.beginTransaction();
            List<Product> list = session.createQuery("from Product", Product.class).list();
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

	@Override
	public List<Product> getByCompositeQuery(Map<String, String> map) {
		return null;
	}

	@Override
	public List<Product> getAll(int currentPage) {
		return null;
	}

	@Override
	public long getTotal() {		
		return 0;
	}

}
