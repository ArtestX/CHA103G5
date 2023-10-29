package com.cha103g5.infomationannouncement.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "infomationannouncement")
public class infomationannouncementVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "in_fo", updatable = false)
	private Integer info;
	
	@Column(name = "Admin_No")
	private Integer AdminNo;
	
	@Column(name = "Info_Content")
	private String InfoContent;
	
	@Column(name = "Info_Title")
	private String InfoTitle;
	
	@Column(name = "Info_Time", updatable=false, nullable=false)
	private Timestamp InfoTime;

	public Integer getInfo() {
		return info;
	}

	public void setInfo(Integer info) {
		this.info = info;
	}

	public Integer getAdminNo() {
		return AdminNo;
	}

	public void setAdminNo(Integer adminNo) {
		AdminNo = adminNo;
	}

	public String getInfoContent() {
		return InfoContent;
	}

	public void setInfoContent(String infoContent) {
		InfoContent = infoContent;
	}

	public String getInfoTitle() {
		return InfoTitle;
	}

	public void setInfoTitle(String infoTitle) {
		InfoTitle = infoTitle;
	}

	public Timestamp getInfoTime() {
		return InfoTime;
	}

	public void setInfoTime(Timestamp infoTime) {
		InfoTime = infoTime;
	}
}
