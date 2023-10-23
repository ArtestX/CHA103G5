package com.cha103g5.pet.model;

import java.sql.Date;
import java.util.List;

import com.cha103g5.pet.model.PetVO;
import com.cha103g5.util.HibernateUtil;

public class PetService {

	private PetHibernateDAOinterface dao;
	
	public PetService() {
		dao =  new PetHibernateDAO(HibernateUtil.getSessionFactory());
	}

	public PetVO addPet(Integer petid, Integer pettype, Integer memberno, String petname, String petsex, String petage,
			String petnote, byte stat, Date applicationdeadline) {

		PetVO petVO = new PetVO();
		petVO.setPettype(pettype);
		petVO.setMemberno(memberno);
		petVO.setPetname(petname);
		petVO.setPetsex(petsex);
		petVO.setPetage(petage);
		petVO.setPetnote(petnote);
		petVO.setStat(stat);
		petVO.setApplicationdeadline(applicationdeadline);
		dao.insert(petVO);
		return petVO;
	}

	// 預留給 Struts 2 或 Spring MVC 用
//	    public void addPet(PetVO petVO) {
//	        dao.insert(petVO);
//	    }

	public PetVO updatePet(Integer petid, Integer pettype, Integer memberno, String petname, String petsex,
			String petage, String petnote, byte stat, Date applicationdeadline) {

		PetVO petVO = new PetVO();
		petVO.setPettype(pettype);
		petVO.setMemberno(memberno);
		petVO.setPetname(petname);
		petVO.setPetsex(petsex);
		petVO.setPetage(petage);
		petVO.setPetnote(petnote);
		petVO.setStat(stat);
		petVO.setApplicationdeadline(applicationdeadline);
		dao.update(petVO);

		return dao.findByPrimaryKey(petid);
	}

	// 預留給 Struts 2 用的
//	    public void updateAdmin(AdminVO adminVO) {
//	        dao.update(adminVO);
//	    }

	public void deletePet(Integer petid) {
		dao.delete(petid);
	}

	public PetVO getOneAdmin(Integer petid) {
		return dao.findByPrimaryKey(petid);
	}

	public List<PetVO> getAll() {
		return dao.getAll();
	}

}
