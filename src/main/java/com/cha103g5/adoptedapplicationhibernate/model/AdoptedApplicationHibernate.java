package com.cha103g5.adoptedapplicationhibernate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalTime;
import java.util.Arrays;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "adoptedapplication")
public class AdoptedApplicationHibernate implements Serializable {

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
//
//    @Column(name = "lotterydate")
//    private Date lotteryDate;

    @Column(name = "lotteryresult")
    private Integer lotteryResult;

    @Column(name = "applicationdate")
    private Date applicationDate;

    @Column(name = "interactiondate")
    private Date interactionDate;

    @Column(name = "interactiontime")
    private LocalTime interactionTime;

    @Column(name = "applicationstat")
    private Integer applicationStat;

    @Column(name = "signaturephoto", columnDefinition = "MEDIUMBLOB")
    private byte[] signaturePhoto;

    @Column(name = "applicantnotes")
    private String applicantNotes;

//    public AdoptedApplicationHibernate() {
//        super();
//    }
//
//    public AdoptedApplicationHibernate(Integer applicationNo, Integer adminNo, Integer memberNo, Integer petId,
//                                       Date lotteryDate, Integer lotteryResult, Date applicationDate, Date interactionDate,
//                                       Integer applicationStat, byte[] signaturePhoto, String applicantNotes) {
//        super();
//        this.applicationNo = applicationNo;
//        this.adminNo = adminNo;
//        this.memberNo = memberNo;
//        this.petId = petId;
//        this.lotteryDate = lotteryDate;
//        this.lotteryResult = lotteryResult;
//        this.applicationDate = applicationDate;
//        this.interactionDate = interactionDate;
//        this.applicationStat = applicationStat;
//        this.signaturePhoto = signaturePhoto;
//        this.applicantNotes = applicantNotes;
//    }
//
//    public Integer getApplicationNo() {
//        return applicationNo;
//    }
//
//    public void setApplicationNo(Integer applicationNo) {
//        this.applicationNo = applicationNo;
//    }
//
//    public Integer getAdminNo() {
//        return adminNo;
//    }
//
//    public void setAdminNo(Integer adminNo) {
//        this.adminNo = adminNo;
//    }
//
//    public Integer getMemberNo() {
//        return memberNo;
//    }
//
//    public void setMemberNo(Integer memberNo) {
//        this.memberNo = memberNo;
//    }
//
//    public Integer getPetId() {
//        return petId;
//    }
//
//    public void setPetId(Integer petId) {
//        this.petId = petId;
//    }
//
//    public Date getLotteryDate() {
//        return lotteryDate;
//    }
//
//    public void setLotteryDate(Date lotteryDate) {
//        this.lotteryDate = lotteryDate;
//    }
//
//    public Integer getLotteryResult() {
//        return lotteryResult;
//    }
//
//    public void setLotteryResult(Integer lotteryResult) {
//        this.lotteryResult = lotteryResult;
//    }
//
//    public Date getApplicationDate() {
//        return applicationDate;
//    }
//
//    public void setApplicationDate(Date applicationDate) {
//        this.applicationDate = applicationDate;
//    }
//
//    public Date getInteractionDate() {
//        return interactionDate;
//    }
//
//    public void setInteractionDate(Date interactionDate) {
//        this.interactionDate = interactionDate;
//    }
//
//    public Integer getApplicationStat() {
//        return applicationStat;
//    }
//
//    public void setApplicationStat(Integer applicationStat) {
//        this.applicationStat = applicationStat;
//    }
//
//    public byte[] getSignaturePhoto() {
//        return signaturePhoto;
//    }
//
//    public void setSignaturePhoto(byte[] signaturePhoto) {
//        this.signaturePhoto = signaturePhoto;
//    }
//
//    public String getApplicantNotes() {
//        return applicantNotes;
//    }
//
//    public void setApplicantNotes(String applicantNotes) {
//        this.applicantNotes = applicantNotes;
//    }
//
//    @Override
//    public String toString() {
//        return "AdoptedApplicationHibernate{" +
//                "applicationNo=" + applicationNo +
//                ", adminNo=" + adminNo +
//                ", memberNo=" + memberNo +
//                ", petId=" + petId +
//                ", lotteryDate=" + lotteryDate +
//                ", lotteryResult=" + lotteryResult +
//                ", applicationDate=" + applicationDate +
//                ", interactionDate=" + interactionDate +
//                ", applicationStat=" + applicationStat +
//                ", signaturePhoto=" + Arrays.toString(signaturePhoto) +
//                ", applicantNotes='" + applicantNotes + '\'' +
//                '}';
//    }

    @Transient
    private String signaturePhotoBase64;

    public String getSignaturePhotoBase64() {
        return signaturePhotoBase64;
    }

    public void setSignaturePhotoBase64(String signaturePhotoBase64) {
        this.signaturePhotoBase64 = signaturePhotoBase64;
    }

}
