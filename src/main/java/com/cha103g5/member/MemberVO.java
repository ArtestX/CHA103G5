package com.cha103g5.member;

import java.sql.Date;

public class MemberVO implements java.io.Serializable{
	private Integer memberNo;
    private String memberAccount;
    private String memberName;
    private Integer memberGender;
    private String memberPassword;
    private String memberPhone;
    private String memberEmail;
    private String memberAddress;
    private Date memberJoinTime;
    private Date memberBirthday;
    private String memberNation;
    private byte[] memberPic;
    private String memberCard;
    private Double memberPoints;
    private Integer memberStat;
    private String memberId;
    private String memberJob;
    private Integer memberSal;
    
    public MemberVO() {
	}
    
	public MemberVO(Integer memberNo, String memberAccount, String memberName, Integer memberGender,
			String memberPassword, String memberPhone, String memberEmail, String memberAddress, Date memberJoinTime,
			Date memberBirthday, String memberNation, byte[] memberPic, String memberCard, Double memberPoints,
			Integer memberStat, String memberId, String memberJob, Integer memberSal) {
		this.memberNo = memberNo;
		this.memberAccount = memberAccount;
		this.memberName = memberName;
		this.memberGender = memberGender;
		this.memberPassword = memberPassword;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberAddress = memberAddress;
		this.memberJoinTime = memberJoinTime;
		this.memberBirthday = memberBirthday;
		this.memberNation = memberNation;
		this.memberPic = memberPic;
		this.memberCard = memberCard;
		this.memberPoints = memberPoints;
		this.memberStat = memberStat;
		this.memberId = memberId;
		this.memberJob = memberJob;
		this.memberSal = memberSal;
	}

	public Integer getMemberNo() {
		return memberNo;
	}
	
	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}
	
	public String getMemberAccount() {
		return memberAccount;
	}
	
	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}
	
	public String getMemberName() {
		return memberName;
	}
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public Integer getMemberGender() {
		return memberGender;
	}
	
	public void setMemberGender(Integer memberGender) {
		this.memberGender = memberGender;
	}
	
	public String getMemberPassword() {
		return memberPassword;
	}
	
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	
	public String getMemberPhone() {
		return memberPhone;
	}
	
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	
	public String getMemberEmail() {
		return memberEmail;
	}
	
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	
	public String getMemberAddress() {
		return memberAddress;
	}
	
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	
	public Date getMemberJoinTime() {
		return memberJoinTime;
	}
	
	public void setMemberJoinTime(Date memberJoinTime) {
		this.memberJoinTime = memberJoinTime;
	}
	
	public Date getMemberBirthday() {
		return memberBirthday;
	}
	
	public void setMemberBirthday(Date memberBirthday) {
		this.memberBirthday = memberBirthday;
	}
	
	public String getMemberNation() {
		return memberNation;
	}
	
	public void setMemberNation(String memberNation) {
		this.memberNation = memberNation;
	}
	
	public byte[] getMemberPic() {
		return memberPic;
	}
	
	public void setMemberPic(byte[] memberPic) {
		this.memberPic = memberPic;
	}
	
	public String getMemberCard() {
		return memberCard;
	}
	
	public void setMemberCard(String memberCard) {
		this.memberCard = memberCard;
	}
	
	public Double getMemberPoints() {
		return memberPoints;
	}
	
	public void setMemberPoints(Double memberPoints) {
		this.memberPoints = memberPoints;
	}
	
	public Integer getMemberStat() {
		return memberStat;
	}
	
	public void setMemberStat(Integer memberStat) {
		this.memberStat = memberStat;
	}
	
	public String getMemberId() {
		return memberId;
	}
	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public String getMemberJob() {
		return memberJob;
	}
	
	public void setMemberJob(String memberJob) {
		this.memberJob = memberJob;
	}
	
	public Integer getMemberSal() {
		return memberSal;
	}
	
	public void setMemberSal(Integer memberSal) {
		this.memberSal = memberSal;
	}
	
	
}
