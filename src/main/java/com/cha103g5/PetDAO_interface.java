package com.cha103g5;

import java.util.List;

public interface PetDAO_interface {
	public void insert(PetVO petVO);
	public void update(PetVO petVO);
	public void delete(PetVO petVO);
	public PetVO findByPrimaryKey(Integer petid);
	public List<PetVO> getALL();

}
