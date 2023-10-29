package com.cha103g5.pet.model;


import java.sql.Date;

public class PetVO {
	private Integer petid;
	private Integer pettype;
	private Integer memberid;
	private String petname;
	private String petsex;
	private Integer petage;
	private String petnote;
	private byte stat;
	private Date applicationdeadline;
	
	
	public Integer getPetid() {
		return petid;
	}
	public void setPetid(Integer petid) {
		this.petid = petid;
	}
	public Integer getPettype() {
		return pettype;
	}
	public void setPettype(Integer pettype) {
		this.pettype = pettype;
	}
	public Integer getMemberid() {
		return memberid;
	}
	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}
	public String getPetname() {
		return petname;
	}
	public void setPetname(String petname) {
		this.petname = petname;
	}
	public String getPetsex() {
		return petsex;
	}
	public void setPetsex(String petsex) {
		this.petsex = petsex;
	}
	public Integer getPetage() {
		return petage;
	}
	public void setPetage(Integer petage) {
		this.petage = petage;
	}
	public String getPetnote() {
		return petnote;
	}
	public void setPetnote(String petnote) {
		this.petnote = petnote;
	}
	public byte getStat() {
		return stat;
	}
	public void setStat(byte stat) {
		this.stat = stat;
	}
	public Date getApplicationdeadline() {
		return applicationdeadline;
	}
	public void setApplicationdeadline(Date applicationdeadline) {
		this.applicationdeadline = applicationdeadline;
	}
	
	
	

}
