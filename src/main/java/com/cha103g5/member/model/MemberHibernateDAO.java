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

import static com.cha103g5.member.model.Constants.PAGE_MAX_RESULT;


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
		// 回傳給 service 剛新增成功的自增主鍵值
		return (Integer) getSession().save(memberVO);
	}

	@Override
	public int update(MemberVO memberVO) {
		try {
			getSession().update(memberVO);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public MemberVO findByPrimaryKey(Integer memberno) {
		return getSession().get(MemberVO.class, memberno);
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
			
			if ("membername".equals(row.getKey())) {
				predicates.add(builder.like(root.get("membername"), "%" + row.getValue() + "%"));
			}
			
		}
		
		criteria.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
		criteria.orderBy(builder.asc(root.get("memberno")));
		TypedQuery<MemberVO> query = getSession().createQuery(criteria);

		return query.getResultList();
	}

	@Override
	public List<MemberVO> getAll(int currentPage) {
		int first = (currentPage - 1) * PAGE_MAX_RESULT;
		Session session1 = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session1.beginTransaction();
			List<MemberVO> list = session1.createQuery("from MemberVO", MemberVO.class)
					.setFirstResult(first)
					.setMaxResults(PAGE_MAX_RESULT)
					.list();
			session1.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session1.getTransaction().rollback();
		}
		return null;
		
	}

	@Override
	public long getTotal() {
	    Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();
	    session2.beginTransaction();
	    Long count =  (Long) session2.createQuery("SELECT COUNT(*) FROM MemberVO").uniqueResult();
	    session2.getTransaction().commit();
	    return count;
	}
}







	
