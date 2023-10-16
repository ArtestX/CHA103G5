package com.cha103g5.admin.model;

import java.util.List;

public interface AdminHibernateDAOInterface {
	// 此介面定義對資料庫的相關存取抽象方法
	int insert(AdminVO adminVO);
	int update(AdminVO adminVO);
	int delete(Integer adminNo);
	AdminVO findByPrimaryKey(Integer adminNo);
	List<AdminVO> getAll();
}