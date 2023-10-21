package com.cha103g5.pet.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pet")
public class PetVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="petid")
    private Integer petid;
	
	@Column(name="pettype")
    private Integer pettype;
	
	@Column(name="memberno")
    private Integer memberno;
	
	@Column(name="petname")
    private String petname;
	
	@Column(name="petsex")
    private String petsex;
	
	@Column(name="petage")
    private String petage;
	
	@Column(name="petnote")
    private String petnote;
	
	@Column(name="stat")
    private byte stat;
	
	@Column(name="applicationdeadline")
    private Date applicationdeadline;

    public PetVO() {
    	super();
    }

    public PetVO(Integer petid, Integer pettype, Integer memberno, String petname, String petsex, String petage, String petnote, byte stat, Date applicationdeadline) {
        super();
    	this.petid = petid;
        this.pettype = pettype;
        this.memberno = memberno;
        this.petname = petname;
        this.petsex = petsex;
        this.petage = petage;
        this.petnote = petnote;
        this.stat = stat;
        this.applicationdeadline = applicationdeadline;
    }

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

    public Integer getMemberno() {
        return memberno;
    }

    public void setMemberno(Integer memberno) {
        this.memberno = memberno;
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

    public String getPetage() {
        return petage;
    }

    public void setPetage(String petage) {
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
