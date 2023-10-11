package com.cha103g5.infoann.model;

import java.sql.Timestamp;

public class InfoAnnVO implements java.io.Serializable{
	private Integer infoNo;
    private Integer adminNo;
    private String infoContent;
    private String infoTitle;
    private Timestamp infoTime;
    
	public InfoAnnVO() {
		super();
	}
//
//	public InfoAnnVO(Integer infoNo, Integer adminNo, String infoContent, String infoTitle,
//			Date infoTime) {
//		this.infoNo = infoNo;
//		this.adminNo = adminNo;
//		this.infoContent = infoContent;
//		this.infoTitle = infoTitle;
//		this.infoTime = infoTime;
//	}

	public Integer getInfoNo() {
		return infoNo;
	}

	public void setInfoNo(Integer infoNo) {
		this.infoNo = infoNo;
	}

	public Integer getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(Integer adminNo) {
		this.adminNo = adminNo;
	}

	public String getInfoContent() {
		return infoContent;
	}

	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}

	public String getInfoTitle() {
		return infoTitle;
	}

	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}

	public Timestamp getInfoTime() {
		return infoTime;
	}

	public void setInfoTime(Timestamp infoTime) {
		this.infoTime = infoTime;
	}
    
}
