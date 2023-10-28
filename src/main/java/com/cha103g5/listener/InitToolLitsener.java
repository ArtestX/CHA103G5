package com.cha103g5.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hibernate.Hibernate;

import com.cha103g5.util.HibernateUtil;
import com.cha103g5.util.JedisUtil;

@WebListener
public class InitToolLitsener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		HibernateUtil.getSessionFactory();
//		System.out.println("Build SessionFactory");
		JedisUtil.getJedisPool();
//		System.out.println("Create JedisPool");

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		HibernateUtil.shutdown();
//		System.out.println("Shutdown SessionFactory");
		JedisUtil.shutdownJedisPool();
//		System.out.println("Shutdown JedisPool");
	}

	
}
