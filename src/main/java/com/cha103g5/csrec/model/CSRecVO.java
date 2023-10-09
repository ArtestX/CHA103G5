package com.cha103g5.csrec.model;

import java.util.Date;

public class CSRecVO {
    private Integer recordNo;
    private Integer memberNo;
    private Integer adminNo;
    private Date recordTime;
    private String interactionContent;
    private byte[] attachments;
    private Integer TalkDirection;

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

    public byte[] getAttachments() {
        return attachments;
    }

    public void setAttachments(byte[] attachments) {
        this.attachments = attachments;
    }

    public Integer getTalkDirection() {
        return TalkDirection;
    }

    public void setTalkDirection(Integer talkDirection) {
        TalkDirection = talkDirection;
    }
}