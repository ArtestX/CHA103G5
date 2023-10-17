package com.cha103g5.pet.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pet")
public class PetVO {
	@Id
	@Column(name="petid")
    private Integer petid;
	
	@Column(name="pettype")
    private Integer pettype;
	
	@Column(name="memnerid")
    private Integer memberid;
	
	@Column(name="petname")
    private String petname;
	
	@Column(name="petsex")
    private String petsex;
	
	@Column(name="petage")
    private Integer petage;
	
	@Column(name="petnote")
    private String petnote;
	
	@Column(name="stat")
    private byte stat;
	
	@Column(name="applicationdeadline")
    private Date applicationdeadline;

    public PetVO() {
    	super();
    }

    public PetVO(Integer petid, Integer pettype, Integer memberid, String petname, String petsex, Integer petage, String petnote, byte stat, Date applicationdeadline) {
        super();
    	this.petid = petid;
        this.pettype = pettype;
        this.memberid = memberid;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PetVO { ");
        sb.append("寵物編號: ").append(petid);
        sb.append(", 寵物類型: ").append(pettype);
        sb.append(", 會員編號: ").append(memberid);
        sb.append(", 寵物名稱: ").append(petname);
        sb.append(", 寵物性別: ").append(petsex);
        sb.append(", 寵物年齡: ").append(petage);
        sb.append(", 備註: ").append(petnote);
        sb.append(", 狀態: ").append(stat);
        sb.append(", 申請截止日期: ").append(applicationdeadline);
        sb.append(" }");
        return sb.toString();
    }
}
