package com.cha103g5.animaltype.model;

import java.util.List;

public class TestAnimaltypeHibernate {
	public static void main(String[] args) {
		AnimaltypeHibernateDAOImpl dao = new AnimaltypeHibernateDAOImpl();
        
        // 測試新增
        AnimaltypeHibernateVO animal1 = new AnimaltypeHibernateVO();
        animal1.setPetTypeName("蟑螂");
        Integer newId = dao.addAnimalType(animal1);
        System.out.println("新增成功，新ID: " + newId);
        
        // 測試查詢
//        AnimaltypeHibernateVO animal2 = dao.getAnimalType(210003);
//        System.out.println("查詢成功: " + animal2.toString());
        
        // 測試更新
//        AnimaltypeHibernateVO animal3 = dao.getAnimalType(210003);
//        animal3.setPetTypeName("大便");
//        dao.updateAnimalType(animal3);
//        AnimaltypeHibernateVO animalUpdated = dao.getAnimalType(210003);
//        System.out.println("更新成功: " + animalUpdated.toString());
        
        // 測試刪除
//        dao.deleteAnimalType(210003);
//        AnimaltypeHibernateVO animalDeleted = dao.getAnimalType(210003);
//        System.out.println("刪除成功，查詢結果應為 null: " + animalDeleted);
        
        // 測試查詢全部
//        List<AnimaltypeHibernateVO> list = dao.getAll();
//        for(AnimaltypeHibernateVO a : list) {
//            System.out.println(a.toString());
//        }
	}
}
