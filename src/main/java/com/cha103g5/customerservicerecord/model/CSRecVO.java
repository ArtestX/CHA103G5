package com.cha103g5.customerservicerecord.model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "customerservicerecord")
public class CSRecVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recordno", updatable = false)
    private Integer recordNo;

    @Column(name = "memberno")
    private Integer memberNo;

    @Column(name = "adminno")
    private Integer adminNo;

    @Column(name = "recordtime")
    private Date recordTime;

    @Column(name = "interactioncontent")
    private String interactionContent;

    @Column(name = "talkdirection")
    private Integer talkDirection;


    public Integer getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(Integer recordNo) {
        this.recordNo = recordNo;
    }

    public Integer getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Integer memberNo) {
        this.memberNo = memberNo;
    }

    public Integer getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(Integer adminNo) {
        this.adminNo = adminNo;
    }

    public java.sql.Date getRecordTime() {
        return (java.sql.Date) recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getInteractionContent() {
        return interactionContent;
    }

    public void setInteractionContent(String interactionContent) {
        this.interactionContent = interactionContent;
    }

    public Integer getTalkDirection() {
        return talkDirection;
    }

    public void setTalkDirection(Integer talkDirection) {
        this.talkDirection = talkDirection;
    }
}