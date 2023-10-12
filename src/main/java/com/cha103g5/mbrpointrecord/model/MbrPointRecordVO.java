package com.cha103g5.mbrpointrecord.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="memberpointrecord")
public class MbrPointRecordVO implements java.io.Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="memberpointno", updatable=false)
	private Integer memberpointno;
	
	@Column(name="memberno")
    private Integer memberno;
	
	@Column(name="getpointtime")
    private Timestamp getpointtime;
	
	@Column(name="getpoint")
    private Integer getpoint;
	
	@Column(name="getpointreason")
    private String getpointreason;
    
	public MbrPointRecordVO() {
		}

	public MbrPointRecordVO(Integer memberpointno, Integer memberno, Timestamp getpointtime, Integer getpoint,
			String getpointreason) {
		super();
		this.memberpointno = memberpointno;
		this.memberno = memberno;
		this.getpointtime = getpointtime;
		this.getpoint = getpoint;
		this.getpointreason = getpointreason;
	}

	public Integer getMemberpointno() {
		return memberpointno;
	}

	public void setMemberpointno(Integer memberpointno) {
		this.memberpointno = memberpointno;
	}

	public Integer getMemberno() {
		return memberno;
	}

	public void setMemberno(Integer memberno) {
		this.memberno = memberno;
	}

	public Timestamp getGetpointtime() {
		return getpointtime;
	}

	public void setGetpointtime(Timestamp getpointtime) {
		this.getpointtime = getpointtime;
	}

	public Integer getGetpoint() {
		return getpoint;
	}

	public void setGetpoint(Integer getpoint) {
		this.getpoint = getpoint;
	}

	public String getGetpointreason() {
		return getpointreason;
	}

	public void setGetpointreason(String getpointreason) {
		this.getpointreason = getpointreason;
	}

	@Override
	public String toString() {
		return "MbrPointRecordVO [memberpointno=" + memberpointno + ", memberno=" + memberno + ", getpointtime="
				+ getpointtime + ", getpoint=" + getpoint + ", getpointreason=" + getpointreason + "]";
	}

	
}
