//package com.cha103g5.filters;
//
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpFilter;
//
//import org.hibernate.Hibernate;
//import org.hibernate.SessionFactory;
//
//import com.cha103g5.util.HibernateUtil;
//
//@WebFilter("/*")
//public class OpenSessionRequestFilter implements Filter {
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//		
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		try {
//			sessionFactory.getCurrentSession().beginTransaction();
//			System.out.println(sessionFactory.getCurrentSession());
//			System.out.println("Get Session");
//			
//			filterChain.doFilter(request, response);
//			sessionFactory.getCurrentSession().getTransaction().commit();
//			System.out.println("Session Commit");
//		} catch (Exception e) {
//			sessionFactory.getCurrentSession().getTransaction().rollback();
//			e.printStackTrace();
//			filterChain.doFilter(request, response);
//		}
//	}
//	
//}
