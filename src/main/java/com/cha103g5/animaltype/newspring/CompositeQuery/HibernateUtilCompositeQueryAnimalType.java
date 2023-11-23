//package com.cha103g5.animaltype.newspring.CompositeQuery;
//
//import com.cha103g5.animaltype.newspring.model.AnimalType;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//import javax.persistence.Query;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class HibernateUtilCompositeQueryAnimalType {
//
//    public static Predicate get_aPredicate_For_AnyDB(
//            CriteriaBuilder criteriaBuilder,
//            Root<AnimalType> root,
//            String columnName,
//            String value) {
//
//        Predicate predicate = null;
//        if ("animalTypeName".equals(columnName)) {
//            predicate = criteriaBuilder
//                    .like(root.get(columnName), "%" + value + "%");
//        }
//
//        return predicate;
//    }
//
//    public static List<AnimalType> getAllC(Map<String, String[]> map, Session session) {
//        List<AnimalType> list = null;
//        Transaction transaction = null;
//        try {
//
//            transaction = session.beginTransaction();
//            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//            CriteriaQuery<AnimalType> criteriaQuery = criteriaBuilder.createQuery(AnimalType.class);
//            Root<AnimalType> root = criteriaQuery.from(AnimalType.class);
//
//            List<Predicate> predicateList = new ArrayList<Predicate>();
//
//            int count = 0;
//            for (String key : map.keySet()) {
//                String value = map.get(key)[0];
//                if (value != null && value.trim().length() != 0 && !"action".equals(key)) {
//                    count++;
//                    predicateList.add(get_aPredicate_For_AnyDB(criteriaBuilder, root, key, value.trim()));
//                    System.out.println("有送出查詢資料的欄位數count = " + count);
//                }
//            }
//            System.out.println("predicateList.size()=" + predicateList.size());
//            criteriaQuery.where(predicateList.toArray(new Predicate[0]));
//            criteriaQuery.orderBy(criteriaBuilder.asc(root.get("animalTypeNo")));
//            Query query = session.createQuery(criteriaQuery);
//            list = query.getResultList();
//
//            transaction.commit();
//
//        } catch (RuntimeException ex) {
//            if (transaction != null) transaction.rollback();
//            throw ex;
//        } finally {
//            session.close();
//        }
//
//        return list;
//    }
//}
