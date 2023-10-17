package com.cha103g5.pet.model;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class TestPetHibernateDAO {
	
	public static void main(String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		
		SessionFactory factory = new MetadataSources()
				.buildMetadata()
				.buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		//  從交易區娟開始進行對資料庫的操作 //
		
		PetVO pet = new PetVO();
		pet.setPettype(1);
		pet.setPetname("Alan");
		pet.setPetsex("F");
		pet.setStat((byte)1);
		
		session.save(pet);
		
		
		// 區間結束 //
		tx.commit();
		session.close();
		factory.close();
	}

}
