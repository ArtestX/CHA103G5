package com.cha103g5.pet.model;

import java.util.List;

public interface PetDAOinterface {
	public void insert(PetVO petVO);
	public void update(PetVO petVO);
	public void delete(Integer petid);
	public PetVO findByPrimaryKey(Integer petid);
	public List<PetVO> getAll();

}
