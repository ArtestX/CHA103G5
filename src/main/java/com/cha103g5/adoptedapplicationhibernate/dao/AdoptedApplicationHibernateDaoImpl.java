package com.cha103g5.adoptedapplicationhibernate.dao;

import com.cha103g5.adoptedapplicationhibernate.model.AdoptedApplicationHibernate;
import com.cha103g5.util.HibernateUtil;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.cha103g5.adoptedapplicationhibernate.util.Constants.PAGE_MAX_RESULT;

public class AdoptedApplicationHibernateDaoImpl implements AdoptedApplicationHibernateDao {

    @Override
    public int add(AdoptedApplicationHibernate adoptedApplication) {
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            session.save(adoptedApplication);

            int applicationNo = adoptedApplication.getApplicationNo();

            transaction.commit();
            return applicationNo;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int update(AdoptedApplicationHibernate adoptedApplication) {
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            session.update(adoptedApplication);

            transaction.commit();
            return 1;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int delete(Integer applicationNo) {
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            AdoptedApplicationHibernate adoptedApplication = session.get(AdoptedApplicationHibernate.class, applicationNo);

            if (adoptedApplication != null) {
                session.delete(adoptedApplication);
            }
            transaction.commit();
            return 1;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public AdoptedApplicationHibernate getById(Integer applicationNo) {
        Transaction transaction = null;
        AdoptedApplicationHibernate adoptedApplication = null;

        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            adoptedApplication = session.get(AdoptedApplicationHibernate.class, applicationNo);

            transaction.commit();
            return adoptedApplication;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<AdoptedApplicationHibernate> getAll() {
        Transaction transaction = null;
        List<AdoptedApplicationHibernate> adoptedApplications = null;

        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            adoptedApplications = session.createQuery(
                    "FROM AdoptedApplicationHibernate", AdoptedApplicationHibernate.class
            ).getResultList();

            transaction.commit();
            return adoptedApplications;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    public List<AdoptedApplicationHibernate> getByPetIdAndLotteryDate(Integer petId, Date lotteryDate) {
        Transaction transaction = null;
        List<AdoptedApplicationHibernate> adoptedApplications = null;

        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            String hql = "FROM AdoptedApplicationHibernate WHERE petId = :petId AND lotteryDate = :lotteryDate";
            Query<AdoptedApplicationHibernate> query = session.createQuery(hql, AdoptedApplicationHibernate.class);
            query.setParameter("petId", petId);
            query.setParameter("lotteryDate", lotteryDate);

            adoptedApplications = query.getResultList();

            transaction.commit();
            return adoptedApplications;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<AdoptedApplicationHibernate> getByMemberNo(Integer memberNo) {
        Transaction transaction = null;
        List<AdoptedApplicationHibernate> adoptedApplications = null;

        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            String hql = "FROM AdoptedApplicationHibernate WHERE memberNo = :memberNo";
            Query<AdoptedApplicationHibernate> query = session.createQuery(hql, AdoptedApplicationHibernate.class);
            query.setParameter("memberNo", memberNo);

            adoptedApplications = query.getResultList();

            transaction.commit();
            return adoptedApplications;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<AdoptedApplicationHibernate> getByCompositeQuery(Map<String, String> map) {
        if (map.size() == 0)
            return getAll();

        Transaction transaction = null;
        List<AdoptedApplicationHibernate> applications = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<AdoptedApplicationHibernate> criteriaQuery = criteriaBuilder.createQuery(AdoptedApplicationHibernate.class);
            Root<AdoptedApplicationHibernate> root = criteriaQuery.from(AdoptedApplicationHibernate.class);

            List<Predicate> predicates = new ArrayList<>();

            if (map.containsKey("petId")) {
                String petId = map.get("petId");
                if (petId != null && !petId.isEmpty()) {
                    predicates.add(criteriaBuilder.equal(root.get("petId"), petId));
                }
            }

            if (map.containsKey("lotteryDate")) {
                String lotteryDateStr = map.get("lotteryDate");
                if (lotteryDateStr != null && !lotteryDateStr.isEmpty()) {
                    Date lotteryDate = Date.valueOf(lotteryDateStr);
                    predicates.add(criteriaBuilder.equal(root.get("lotteryDate"), lotteryDate));
                }
            }

            criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
            applications = session.createQuery(criteriaQuery).getResultList();

            transaction.commit();
            return applications;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<AdoptedApplicationHibernate> getAll(int currentPage) {
        Transaction transaction = null;
        List<AdoptedApplicationHibernate> applications = null;

        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            int firstResult = (currentPage - 1) * PAGE_MAX_RESULT;

            Query<AdoptedApplicationHibernate> query = session.createQuery(
                    "FROM AdoptedApplicationHibernate", AdoptedApplicationHibernate.class
            );
            query.setFirstResult(firstResult);
            query.setMaxResults(PAGE_MAX_RESULT);

            applications = query.list();

            transaction.commit();
            return applications;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long getTotal() {
        Transaction transaction = null;
        long count = 0;

        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            Query<Long> query = session.createQuery("SELECT count(*) FROM AdoptedApplicationHibernate", Long.class);
            count = query.uniqueResult();

            transaction.commit();
            return count;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return count;
    }
}
