package com.cha103g5.adoptedapplication.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;

public class AdoptedapplicationVO implements Serializable{
	private Integer applicationno;
    private Integer adminno;
    private Integer memberno;
    private Integer petid;
    private Date interactiondate;
    private Integer lotteryresult;
    private Date lotterydate;
    private Integer applicationstat;
    private String applicantnotes;
    private byte[] agreement;
    private Date applicationdate;
    
	public AdoptedapplicationVO() {
		super();
	}

	public AdoptedapplicationVO(Integer applicationno, Integer adminno, Integer memberno, Integer petid,
			Date interactiondate, Integer lotteryresult, Date lotterydate, Integer applicationstat,
			String applicantnotes, byte[] agreement, Date applicationdate) {
		super();
		this.applicationno = applicationno;
		this.adminno = adminno;
		this.memberno = memberno;
		this.petid = petid;
		this.interactiondate = interactiondate;
		this.lotteryresult = lotteryresult;
		this.lotterydate = lotterydate;
		this.applicationstat = applicationstat;
		this.applicantnotes = applicantnotes;
		this.agreement = agreement;
		this.applicationdate = applicationdate;
	}

	public Integer getApplicationno() {
		return applicationno;
	}

	public void setApplicationno(Integer applicationno) {
		this.applicationno = applicationno;
	}

	public Integer getAdminno() {
		return adminno;
	}

	public void setAdminno(Integer adminno) {
		this.adminno = adminno;
	}

	public Integer getMemberno() {
		return memberno;
	}

	public void setMemberno(Integer memberno) {
		this.memberno = memberno;
	}

	public Integer getPetid() {
		return petid;
	}

	public void setPetid(Integer petid) {
		this.petid = petid;
	}

	public Date getInteractiondate() {
		return interactiondate;
	}

	public void setInteractiondate(Date interactiondate) {
		this.interactiondate = interactiondate;
	}

	public Integer getLotteryresult() {
		return lotteryresult;
	}

	public void setLotteryresult(Integer lotteryresult) {
		this.lotteryresult = lotteryresult;
	}

	public Date getLotterydate() {
		return lotterydate;
	}

	public void setLotterydate(Date lotterydate) {
		this.lotterydate = lotterydate;
	}

	public Integer getApplicationstat() {
		return applicationstat;
	}

	public void setApplicationstat(Integer applicationstat) {
		this.applicationstat = applicationstat;
	}

	public String getApplicantnotes() {
		return applicantnotes;
	}

	public void setApplicantnotes(String applicantnotes) {
		this.applicantnotes = applicantnotes;
	}

	public byte[] getAgreement() {
		return agreement;
	}

	public void setAgreement(byte[] agreement) {
		this.agreement = agreement;
	}

	public Date getApplicationdate() {
		return applicationdate;
	}

	public void setApplicationdate(Date applicationdate) {
		this.applicationdate = applicationdate;
	}

//	@Override
//	public String toString() {
//		return "AdoptedapplicationVO [applicationno=" + applicationno + ", adminno=" + adminno + ", memberno="
//				+ memberno + ", petid=" + petid + ", interactiondate=" + interactiondate + ", lotteryresult="
//				+ lotteryresult + ", lotterydate=" + lotterydate + ", applicationstat=" + applicationstat
//				+ ", applicantnotes=" + applicantnotes + ", agreement=" + Arrays.toString(agreement)
//				+ ", applicationdate=" + applicationdate + "]";
//	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    
	    sb.append("AdoptedapplicationVO { ");
	    sb.append("申請編號: ").append(applicationno);
	    sb.append(", 管理員編號: ").append(adminno);
	    sb.append(", 會員編號: ").append(memberno);
	    sb.append(", 寵物編號: ").append(petid);
	    sb.append(", 互動日期: ").append(interactiondate);
	    sb.append(", 抽籤結果: ").append(lotteryresult);
	    sb.append(", 抽籤日期: ").append(lotterydate);
	    sb.append(", 申請狀態: ").append(applicationstat);
	    sb.append(", 申請者備註: ").append(applicantnotes);
	    sb.append(", 同意書: ").append(Arrays.toString(agreement));
	    sb.append(", 申請日期: ").append(applicationdate);
	    sb.append(" }");
	    
	    return sb.toString();
	}
}
