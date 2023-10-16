package com.cha103g5.animaltype.model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.cha103g5.util.HibernateUtil;

public class AnimaltypeHibernateDAOImpl implements AnimaltypeHibernateDAO  {

	@Override
	public Integer addAnimalType(AnimaltypeHibernateVO animalType) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    Transaction tx = null;
	    Integer id = null;
	    try {
	        tx = session.beginTransaction();
	        id = (Integer) session.save(animalType);
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) tx.rollback();
	        e.printStackTrace();
	    }
	    return id;
	}

	@Override
	public AnimaltypeHibernateVO getAnimalType(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    Transaction tx = session.beginTransaction();
	    AnimaltypeHibernateVO animalType = null;
	    try {
	        animalType = session.get(AnimaltypeHibernateVO.class, id);
	        tx.commit();
	    } catch (Exception e) {
	        tx.rollback();
	        e.printStackTrace();
	    }
	    return animalType;
	}

	@Override
	public void updateAnimalType(AnimaltypeHibernateVO animalType) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    Transaction tx = null;
	    try {
	        tx = session.beginTransaction();
	        session.update(animalType);
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) tx.rollback();
	        e.printStackTrace();
	    }
	}

	@Override
	public void deleteAnimalType(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    Transaction tx = null;
	    try {
	        tx = session.beginTransaction();
	        AnimaltypeHibernateVO animalType = session.get(AnimaltypeHibernateVO.class, id);
	        session.delete(animalType);
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) tx.rollback();
	        e.printStackTrace();
	    }
	}

	@Override
	public List<AnimaltypeHibernateVO> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    List<AnimaltypeHibernateVO> list = null;
	    Transaction tx = null;
	    try {
	        tx = session.beginTransaction();
	        String hql = "FROM AnimaltypeHibernateVO";
	        Query query = session.createQuery(hql);
	        list = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) tx.rollback();
	        e.printStackTrace();
	    }
	    return list;
	}
}
