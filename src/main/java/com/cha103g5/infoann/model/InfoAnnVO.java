package com.cha103g5.infoann.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="informationannouncement")
public class InfoAnnVO implements java.io.Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="infono", updatable=false)
	private Integer infono;
	
	@Column(name="adminno")
    private Integer adminno;
	
    @Column(name="infocontent")
    private String infocontent;
    
    @Column(name="infotitle")
    private String infotitle;
    
    @Column(name="infotime")
    private Timestamp infotime;
    
    public InfoAnnVO() {
		super();
	}

	public InfoAnnVO(Integer infono, Integer adminno, String infocontent, String infotitle, Timestamp infotime) {
		super();
		this.infono = infono;
		this.adminno = adminno;
		this.infocontent = infocontent;
		this.infotitle = infotitle;
		this.infotime = infotime;
	}

	public Integer getInfono() {
		return infono;
	}

	public void setInfono(Integer infono) {
		this.infono = infono;
	}

	public Integer getAdminno() {
		return adminno;
	}

	public void setAdminno(Integer adminno) {
		this.adminno = adminno;
	}

	public String getInfocontent() {
		return infocontent;
	}

	public void setInfocontent(String infocontent) {
		this.infocontent = infocontent;
	}

	public String getInfotitle() {
		return infotitle;
	}

	public void setInfotitle(String infotitle) {
		this.infotitle = infotitle;
	}

	public Timestamp getInfotime() {
		return infotime;
	}

	public void setInfotime(Timestamp infotime) {
		this.infotime = infotime;
	}

	@Override
	public String toString() {
		return "InfoAnnVO [infono=" + infono + ", adminno=" + adminno + ", infocontent=" + infocontent + ", infotitle="
				+ infotitle + ", infotime=" + infotime + "]";
	}

}
