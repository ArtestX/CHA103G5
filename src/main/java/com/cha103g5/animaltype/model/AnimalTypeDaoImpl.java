package com.cha103g5.animaltype.model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.cha103g5.util.HibernateUtil;

public class AnimalTypeDaoImpl implements AnimalTypeDao  {

	@Override
	public AnimalType add(String animalTypeName) {
	    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    Transaction transaction = null;
	    AnimalType animalType = null;

	    try {
	        transaction = session.beginTransaction();

	        animalType = new AnimalType();
	        animalType.setAnimalTypeName(animalTypeName);
	        session.save(animalType);

	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) transaction.rollback();
	        e.printStackTrace();
	    }

	    return animalType;
	}

	@Override
	public AnimalType update(String newAnimalTypeName, String oldAnimalTypeName) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    Transaction transaction = null;
	    AnimalType animalType = null;
	    String hql = "FROM AnimalType WHERE animalTypeName = :oldAnimalTypeName";

	    try {
	        transaction = session.beginTransaction();

	        Query<AnimalType> query = session.createQuery(hql, AnimalType.class);
	        query.setParameter("oldAnimalTypeName", oldAnimalTypeName);
	        animalType = query.uniqueResult();
	        if (animalType != null) {
	            animalType.setAnimalTypeName(newAnimalTypeName);
	            session.update(animalType);
	        }

	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) transaction.rollback();
	        e.printStackTrace();
	    }

	    return animalType;
	}

	@Override
	public void delete(String animalTypeName) {
	    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    Transaction transaction = null;
	    String hql = "FROM AnimalType WHERE animalTypeName = :animalTypeName";

	    try {
	        transaction = session.beginTransaction();

	        Query<AnimalType> query = session.createQuery(hql, AnimalType.class);
	        query.setParameter("animalTypeName", animalTypeName);
	        List<AnimalType> animalTypes = query.list();
	        System.out.println("查詢結果：" + animalTypes);  // 新增這一行來查看查詢結果
	        for (AnimalType animalType : animalTypes) {
	            if (animalType != null) {
	            	System.out.println("準備刪除：" + animalType);  // 新增這一行來查看準備刪除哪個對象
	                session.delete(animalType);
	                System.out.println("刪除完成");  // 新增這一行來確認刪除操作已執行
	            }
	        }

	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) transaction.rollback();
	        e.printStackTrace();
	    }
	}

	@Override
	public AnimalType getByName(String animalTypeName) {
	    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    Transaction transaction = null;
	    AnimalType animalType = null;
	    String hql = "FROM AnimalType WHERE animalTypeName = :animalTypeName";

	    try {
	        transaction = session.beginTransaction();

	        Query<AnimalType> query = session.createQuery(hql, AnimalType.class);
	        query.setParameter("animalTypeName", animalTypeName);
	        query.setMaxResults(1);
	        List<AnimalType> results = query.getResultList();
	        if (!results.isEmpty()) {
	            animalType = results.get(0);
	        }

	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) transaction.rollback();
	        e.printStackTrace();
	    }

	    return animalType;
	}

	@Override
	public List<AnimalType> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
	    List<AnimalType> list = null;
	    String hql = "FROM AnimalType";

	    try {
	    	transaction = session.beginTransaction();

	        Query query = session.createQuery(hql);
	        list = query.list();

	        transaction.commit();
	    } catch (Exception e) {
	    	if (transaction != null) transaction.rollback();
	        e.printStackTrace();
	    }

	    return list;
	}
}
