package com.cha103g5.informationannouncement.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "informationannouncement")
public class InformationAnnouncementVO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="infono", updatable=false)
    private Integer infoNo;

    @NotNull
    @Column(name="adminno")
    private Integer adminNo;

    @NotNull
    @Column(name="infocontent")
    private String infoContent;

    @NotNull
    @Column(name="infotitle")
    private String infoTitle;

    @NotNull
    @Column(name="infotime")
    private Date infoTime;

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

    public Date getInfoTime() {
        return infoTime;
    }

    public void setInfoTime(Date infoTime) {
        this.infoTime = infoTime;
    }
}
