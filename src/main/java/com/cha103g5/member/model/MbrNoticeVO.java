package com.cha103g5.member.model;

import java.sql.Date;

public class MbrNoticeVO implements java.io.Serializable{
	private Integer memberNoticeNo;
    private Integer memberNo;
    private String noticeContent;
    private Date noticeTime;
    private Integer readStat;
    
	public MbrNoticeVO() {	
	}

	public MbrNoticeVO(Integer memberNoticeNo, Integer memberNo, String noticeContent, Date noticeTime,
			Integer readStat) {
		this.memberNoticeNo = memberNoticeNo;
		this.memberNo = memberNo;
		this.noticeContent = noticeContent;
		this.noticeTime = noticeTime;
		this.readStat = readStat;
	}

	public Integer getMemberNoticeNo() {
		return memberNoticeNo;
	}

	public void setMemberNoticeNo(Integer memberNoticeNo) {
		this.memberNoticeNo = memberNoticeNo;
	}

	public Integer getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public Date getNoticeTime() {
		return noticeTime;
	}

	public void setNoticeTime(Date noticeTime) {
		this.noticeTime = noticeTime;
	}

	public Integer getReadStat() {
		return readStat;
	}

	public void setReadStat(Integer readStat) {
		this.readStat = readStat;
	}

	@Override
	public String toString() {
		return "MbrNoticeVO [memberNoticeNo=" + memberNoticeNo + ", memberNo=" + memberNo + ", noticeContent="
				+ noticeContent + ", noticeTime=" + noticeTime + ", readStat=" + readStat + "]";
	}
    
	
}



