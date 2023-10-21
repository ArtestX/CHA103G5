package com.cha103g5.admin.model;

import java.util.List;

public interface AdminHibernateDAOInterface {
	// 此介面定義對資料庫的相關存取抽象方法
	int insert(AdminVO adminVO);
	int update(AdminVO adminVO);
	int delete(Integer adminNo);
	AdminVO findByPrimaryKey(Integer adminNo);
	List<AdminVO> getAll();
	
//	public void insert(AdminVO adminVO);
//	public void update(AdminVO adminVO);
//	public void delete(Integer adminNo);
//	public AdminVO findByPrimaryKey(Integer adminNo);
//	public List<AdminVO> getAll();
}