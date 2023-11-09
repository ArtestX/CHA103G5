package com.cha103g5.memberpointrecord.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cha103g5.member.model.MemberVO;

@Entity
@Table(name="memberpointrecord")
public class MemberPointRecordVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

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
	
//	private MemberVO memberVO;

	public MemberPointRecordVO() {
		}

	public MemberPointRecordVO(Integer memberpointno, Integer memberno, Timestamp getpointtime, Integer getpoint,
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

//	@ManyToOne
//	@JoinColumn(name = "memberno")   // 指定用來join table的column
//	public MemberVO getMemberVO() {
//		return memberVO;
//	}
//
//	public void setMemberVO(MemberVO memberVO) {
//		this.memberVO = memberVO;
//	}
}
