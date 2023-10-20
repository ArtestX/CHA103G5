package com.cha103g5.product_category_detail.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.cha103g5.util.HibernateUtil;

import java.util.List;
import java.util.Map;

public class Product_category_detailDAOImpl implements Product_category_detailDAO {

    private SessionFactory factory;

    public Product_category_detailDAOImpl() {
        this.factory = HibernateUtil.getSessionFactory();
    }

    private Session getSession() {
        return factory.getCurrentSession();
    }

    @Override
    public int insert(Product_category_detail entity) {
        Session session = getSession();
        try {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            return entity.getProductCatDetNo(); // Return the ID of the newly inserted entity
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return -1;
        }
    }

    @Override
    public int update(Product_category_detail entity) {
        Session session = getSession();
        try {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return -1;
        }
    }

    @Override
    public int delete(Integer id) {
        Session session = getSession();
        try {
            session.beginTransaction();
            Product_category_detail productCategoryDetail = session.get(Product_category_detail.class, id);
            if (productCategoryDetail != null) {
                session.delete(productCategoryDetail);
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
    public Product_category_detail getById(Integer id) {
        Session session = getSession();
        try {
            session.beginTransaction();
            Product_category_detail productCategoryDetail = session.get(Product_category_detail.class, id);
            session.getTransaction().commit();
            return productCategoryDetail;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public List<Product_category_detail> getAll() {
        Session session = getSession();
        try {
            session.beginTransaction();
            List<Product_category_detail> list = session.createQuery("from Product_category_detail", Product_category_detail.class).list();
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();    
        }
        return null;
    }

    @Override
    public List<Product_category_detail> getByCompositeQuery(Map<String, String> map) {
        return null;
    }

    @Override
    public List<Product_category_detail> getAll(int currentPage) {
        return null;
    }

    @Override
    public long getTotal() {
        return 0;
    }
}
