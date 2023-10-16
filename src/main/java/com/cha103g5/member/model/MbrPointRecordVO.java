package com.cha103g5.member.model;

import java.sql.*;

public class MbrPointRecordVO implements java.io.Serializable{
	private Integer memberPointNo;
    private Integer memberNo;
    private Timestamp getPointTime;
    private Integer getPoint;
    private String getPointReason;
    
	public MbrPointRecordVO() {
		}

	public MbrPointRecordVO(Integer memberPointNo, Integer memberNo, Timestamp getPointTime, Integer getPoint,
			String getPointReason) {
		this.memberPointNo = memberPointNo;
		this.memberNo = memberNo;
		this.getPointTime = getPointTime;
		this.getPoint = getPoint;
		this.getPointReason = getPointReason;
	}

	public Integer getMemberPointNo() {
		return memberPointNo;
	}

	public void setMemberPointNo(Integer memberPointNo) {
		this.memberPointNo = memberPointNo;
	}

	public Integer getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}

	public Timestamp getGetPointTime() {
		return getPointTime;
	}

	public void setGetPointTime(Timestamp getPointTime) {
		this.getPointTime = getPointTime;
	}

	public Integer getGetPoint() {
		return getPoint;
	}

	public void setGetPoint(Integer getPoint) {
		this.getPoint = getPoint;
	}

	public String getGetPointReason() {
		return getPointReason;
	}

	public void setGetPointReason(String getPointReason) {
		this.getPointReason = getPointReason;
	}

	@Override
	public String toString() {
		return "MbrPointRecordVO [memberPointNo=" + memberPointNo + ", memberNo=" + memberNo + ", getPointTime="
				+ getPointTime + ", getPoint=" + getPoint + ", getPointReason=" + getPointReason + "]";
	}
	
}
