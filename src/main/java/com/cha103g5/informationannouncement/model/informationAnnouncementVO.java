package com.cha103g5.informationannouncement.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "informationannouncement")
public class informationAnnouncementVO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="infono", updatable=false)
    private Integer infoNo;

    @Column(name="adminno")
    private Integer adminNo;

    @Column(name="infocontent")
    private String infoContent;

    @Column(name="infotitle")
    private String infoTitle;

    @Column(name="infotime")
    private Timestamp infoTime;

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
