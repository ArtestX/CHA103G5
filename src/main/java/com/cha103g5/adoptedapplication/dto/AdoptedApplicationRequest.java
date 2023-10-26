package com.cha103g5.adoptedapplication.dto;

import javax.validation.constraints.NotNull;
import java.sql.Date;

public class AdoptedApplicationRequest {

    private Integer adminNo;
    private Integer memberNo;
    private Integer petId;
    private Date lotteryDate;
    private Integer lotteryResult;
    private Date interactionDate;
    private Integer applicationStat;
    private String applicantNotes;
    private String agreement;
    private Date applicationDate;

    public Integer getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(Integer adminNo) {
        this.adminNo = adminNo;
    }

    public Integer getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Integer memberNo) {
        this.memberNo = memberNo;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public Date getInteractionDate() {
        return interactionDate;
    }

    public void setInteractionDate(Date interactionDate) {
        this.interactionDate = interactionDate;
    }

    public Integer getLotteryResult() {
        return lotteryResult;
    }

    public void setLotteryResult(Integer lotteryResult) {
        this.lotteryResult = lotteryResult;
    }

    public Date getLotteryDate() {
        return lotteryDate;
    }

    public void setLotteryDate(Date lotteryDate) {
        this.lotteryDate = lotteryDate;
    }

    public Integer getApplicationStat() {
        return applicationStat;
    }

    public void setApplicationStat(Integer applicationStat) {
        this.applicationStat = applicationStat;
    }

    public String getApplicantNotes() {
        return applicantNotes;
    }

    public void setApplicantNotes(String applicantNotes) {
        this.applicantNotes = applicantNotes;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }
}
