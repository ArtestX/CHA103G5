package com.cha103g5.pet.model;

import java.util.List;

public interface PetHibernateDAOinterface {
	int insert(PetServletVO petVO);
	int update(PetServletVO petVO);
	int delete(Integer petid);
	PetServletVO findByPrimaryKey(Integer petid);
	List<PetServletVO> getAll();
}
