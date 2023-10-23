package com.cha103g5.pet.model;

import java.util.List;

public interface PetHibernateDAOinterface {
	int insert(PetVO petVO);
	int update(PetVO petVO);
	int delete(Integer petId);
	PetVO findByPrimaryKey(Integer petId);
	List<PetVO> getAll();
}
