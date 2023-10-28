package com.cha103g5.adoptedapplication.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "adoptedapplication")
public class AdoptedApplication implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicationno")
    private Integer applicationNo;

    @Column(name = "adminno")
    private Integer adminNo;

    @Column(name = "memberno")
    private Integer memberNo;

    @Column(name = "petid")
    private Integer petId;

    @Column(name = "lotterydate")
    private Date lotteryDate;

    @Column(name = "lotteryresult")
    private Integer lotteryResult;

    @Column(name = "interactiondate")
    private Date interactionDate;

    @Column(name = "applicationstat")
    private Integer applicationStat;

    @Column(name = "applicantnotes")
    private String applicantNotes;

    @Column(name = "agreement")
    private String agreement;

    @Column(name = "applicationdate")
    private Date applicationDate;

    public AdoptedApplication() {
        super();
    }

    public AdoptedApplication(Integer applicationNo, Integer adminNo, Integer memberNo, Integer petId,
                              Date interactionDate, Integer lotteryResult, Date lotteryDate,
                              Integer applicationStat, String applicantNotes, String agreement,
                              Date applicationDate) {
        super();
        this.applicationNo = applicationNo;
        this.adminNo = adminNo;
        this.memberNo = memberNo;
        this.petId = petId;
        this.interactionDate = interactionDate;
        this.lotteryResult = lotteryResult;
        this.lotteryDate = lotteryDate;
        this.applicationStat = applicationStat;
        this.applicantNotes = applicantNotes;
        this.agreement = agreement;
        this.applicationDate = applicationDate;
    }

    public Integer getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(Integer applicationNo) {
        this.applicationNo = applicationNo;
    }

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

    @Override
    public String toString() {
        return "AdoptedApplication{" +
                "applicationNo=" + applicationNo +
                ", adminNo=" + adminNo +
                ", memberNo=" + memberNo +
                ", petId=" + petId +
                ", interactionDate=" + interactionDate +
                ", lotteryResult=" + lotteryResult +
                ", lotteryDate=" + lotteryDate +
                ", applicationStat=" + applicationStat +
                ", applicantNotes='" + applicantNotes + '\'' +
                ", agreement='" + agreement + '\'' +
                ", applicationDate=" + applicationDate +
                '}';
    }
}
