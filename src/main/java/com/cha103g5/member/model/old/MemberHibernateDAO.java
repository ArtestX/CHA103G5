package com.cha103g5.member.model.old;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import com.cha103g5.member.model.MemberVO;
import com.cha103g5.util.HibernateUtil;


public class MemberHibernateDAO implements MemberDAOinterface {

	// SessionFactory 為 thread-safe，可宣告為屬性讓請求執行緒們共用
	private SessionFactory factory;
	
	public MemberHibernateDAO(SessionFactory factory) {
			this.factory = factory;
	}	
	
	// Session 為 not thread-safe，所以此方法在各個增刪改查方法裡呼叫
		// 以避免請求執行緒共用了同個 Session
	private Session getSession() {
			return factory.getCurrentSession();
	}
		
	@Override
	public int insert(MemberVO memberVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.save(memberVO);
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
		} finally {
	        if (session != null && session.isOpen()) {
	            session.close();
	        }
	    }
		return -1;
	}
	
	@Override
	public void delete(Integer memberno) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			MemberVO memberVO = session.get(MemberVO.class, memberno);
			if (memberVO != null) {
				session.delete(memberVO);
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
	public MemberVO findByPrimaryKey(Integer memberno) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			MemberVO memberVO = session.get(MemberVO.class, memberno);
			session.getTransaction().commit();
			return memberVO;
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
		} finally {
	        if (session != null && session.isOpen()) {
	            session.close();
	        }
	    }
		return null;
		
	}

	@Override
	public MemberVO findByMemberEmail(String memberemail) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			MemberVO memberVO = (MemberVO) session.createQuery("FROM MemberVO WHERE memberemail = :memberemail")
	                 .setParameter("memberemail",memberemail)
	                 .uniqueResult();
			session.getTransaction().commit();
			return memberVO;
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

	

}
