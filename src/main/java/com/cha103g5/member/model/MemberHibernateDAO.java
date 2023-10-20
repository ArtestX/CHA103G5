package com.cha103g5.member.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
	public List<MemberVO> getByCompositeQuery(Map<String, String> map) {
			if (map.size() == 0)
				return getAll();
	
			CriteriaBuilder builder = getSession().getCriteriaBuilder();
			CriteriaQuery<MemberVO> criteria = builder.createQuery(MemberVO.class);
			Root<MemberVO> root = criteria.from(MemberVO.class);
	
			List<Predicate> predicates = new ArrayList<>();
			
			if (map.containsKey("startmemberjointime") && map.containsKey("endmemberjointime"))
				predicates.add(builder.between(root.get("memberjointime"), Timestamp.valueOf(map.get("startmemberjointime")), Timestamp.valueOf(map.get("endmemberjointime"))));
			
		
			for (Map.Entry<String, String> row : map.entrySet()) {
				if ("startmemberjointime".equals(row.getKey())) {
					if (!map.containsKey("endmemberjointime"))
						predicates.add(builder.greaterThanOrEqualTo(root.get("memberjointime"), Timestamp.valueOf(row.getValue())));
				}
	
				if ("endmemberjointime".equals(row.getKey())) {
					if (!map.containsKey("startmemberjointime"))
						predicates.add(builder.lessThanOrEqualTo(root.get("memberjointime"), Timestamp.valueOf(row.getValue())));
	
				}
				
				if ("memberemail".equals(row.getKey())) {
				    predicates.add(builder.equal(root.get("memberemail"), row.getValue()));
				}
				
			}
			
			criteria.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
			criteria.orderBy(builder.asc(root.get("memberno")));
			TypedQuery<MemberVO> query = getSession().createQuery(criteria);
	
			return query.getResultList();
	
	}

}







	
