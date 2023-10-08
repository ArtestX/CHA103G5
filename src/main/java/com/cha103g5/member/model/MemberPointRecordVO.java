package com.cha103g5.member.model;

import java.sql.Date;

public class MemberPointRecordVO implements java.io.Serializable{
	private Integer memberPointNo;
    private Integer memberNo;
    private Date getPointTime;
    private Integer getPoint;
    private String getPointReason;
    
	public MemberPointRecordVO() {
		}

	public MemberPointRecordVO(Integer memberPointNo, Integer memberNo, Date getPointTime, Integer getPoint,
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

	public Date getGetPointTime() {
		return getPointTime;
	}

	public void setGetPointTime(Date getPointTime) {
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
    
}
