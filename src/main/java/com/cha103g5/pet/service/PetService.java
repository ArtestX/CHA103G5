package com.cha103g5.pet.service;

import java.util.List;

import com.cha103g5.pet.model.PetHibernateDAO;
import com.cha103g5.pet.model.PetHibernateDAOinterface;
import com.cha103g5.pet.model.PetServletVO;
import com.cha103g5.util.HibernateUtil;

public class PetService {

	private PetHibernateDAOinterface dao;

	public PetService() {
		dao = new PetHibernateDAO(HibernateUtil.getSessionFactory());
	}

	public PetServletVO addPet(Integer animaltypeno, Integer memberno, String petname, String petsex, String petage,
                               String petnote, byte stat, java.sql.Date applicationdeadline) {

		PetServletVO petVO = new PetServletVO();
		petVO.setAnimaltypeno(animaltypeno);
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

	public PetServletVO updatePet(Integer petid, Integer animaltypeno, Integer memberno, String petname, String petsex,
                                  String petage, String petnote, byte stat, java.sql.Date applicationdeadline) {

		PetServletVO petVO = new PetServletVO();
		
		petVO.setPetid(petid);
		petVO.setAnimaltypeno(animaltypeno);
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
//	    public void updatePet(PetVO PetVO) {
//	        dao.update(petVO);
//	    }

	public void deletePet(Integer petid) {
		dao.delete(petid);
	}

	public PetServletVO getOnePet(Integer petid) {
		return dao.findByPrimaryKey(petid);
	}

	public List<PetServletVO> getAll() {
		return dao.getAll();
	}

}
