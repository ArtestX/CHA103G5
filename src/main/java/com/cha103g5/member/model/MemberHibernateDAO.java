package com.cha103g5.member.model;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.cha103g5.util.HibernateUtil;



public class MemberHibernateDAO implements MemberDAOinterface {
	
	@Override
	public int insert(MemberVO memberVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Integer id = (Integer) session.save(memberVO);
			session.getTransaction().commit();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public int update(MemberVO memberVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.update(memberVO);
			session.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public MemberVO findByPrimaryKey(Integer memberno) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			MemberVO memberVO = session.get(MemberVO.class, memberno);
			session.getTransaction().commit();
			return memberVO;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<MemberVO> findByMemberName(String membername) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
	        Query<MemberVO> query = session.createQuery("from MemberVO where membername = :name", MemberVO.class);
	        query.setParameter("name", membername);

	        List<MemberVO> members = query.list();
	        session.getTransaction().commit();

	        return members;
	    } catch (Exception e) {
	        session.getTransaction().rollback();
	        e.printStackTrace();
	        return null;
	    }
	}

	@Override
	public List<MemberVO> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<MemberVO> list = session.createQuery("from MemberVO", MemberVO.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

}
