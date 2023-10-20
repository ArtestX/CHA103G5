package com.cha103g5.adoptedapplication.model;

import java.sql.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.cha103g5.util.HibernateUtil;

public class HibernateAdoptedApplicationDAOImpl implements HibernateAdoptedApplicationDAO{

	@Override
	public Integer addApplication(HibernateAdoptedApplicationVO application) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Integer applicationno = null;
        try {
            tx = session.beginTransaction();
            applicationno = (Integer) session.save(application);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return applicationno;
	}

	@Override
	public void updateApplication(HibernateAdoptedApplicationVO application) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(application);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
	}

	@Override
	public List<HibernateAdoptedApplicationVO> findByPetidAndLotterydate(Integer petid, Date lotterydate) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<HibernateAdoptedApplicationVO> list = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from HibernateAdoptedApplicationVO where petid = :petid and lotterydate = :lotterydate");
            query.setParameter("petid", petid);
            query.setParameter("lotterydate", lotterydate);
            list = query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List<HibernateAdoptedApplicationVO> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<HibernateAdoptedApplicationVO> list = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from HibernateAdoptedApplicationVO");
            list = query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return list;
	}

}
