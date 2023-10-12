package com.cha103g5.mbrnotice.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="membernotice")
public class MbrNoticeVO implements java.io.Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="membernoticeno", updatable=false)
	private Integer membernoticeno;
	
	@Column(name="memberno")
    private Integer memberno;
	
	@Column(name="noticecontent")
    private String noticecontent;
	
	@Column(name="noticetime")
    private Timestamp noticetime;
	
	@Column(name="readstat")
    private Integer readstat;

	public MbrNoticeVO() {
		super();
	}

	public MbrNoticeVO(Integer membernoticeno, Integer memberno, String noticecontent, Timestamp noticetime,
			Integer readstat) {
		super();
		this.membernoticeno = membernoticeno;
		this.memberno = memberno;
		this.noticecontent = noticecontent;
		this.noticetime = noticetime;
		this.readstat = readstat;
	}

	public Integer getMembernoticeno() {
		return membernoticeno;
	}

	public void setMembernoticeno(Integer membernoticeno) {
		this.membernoticeno = membernoticeno;
	}

	public Integer getMemberno() {
		return memberno;
	}

	public void setMemberno(Integer memberno) {
		this.memberno = memberno;
	}

	public String getNoticecontent() {
		return noticecontent;
	}

	public void setNoticecontent(String noticecontent) {
		this.noticecontent = noticecontent;
	}

	public Timestamp getNoticetime() {
		return noticetime;
	}

	public void setNoticetime(Timestamp noticetime) {
		this.noticetime = noticetime;
	}

	public Integer getReadstat() {
		return readstat;
	}

	public void setReadstat(Integer readstat) {
		this.readstat = readstat;
	}

	@Override
	public String toString() {
		return "MbrNoticeVO [membernoticeno=" + membernoticeno + ", memberno=" + memberno + ", noticecontent="
				+ noticecontent + ", noticetime=" + noticetime + ", readstat=" + readstat + "]";
	}

	
}



