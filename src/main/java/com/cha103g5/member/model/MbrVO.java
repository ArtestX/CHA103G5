package com.cha103g5.member.model;

import java.sql.Timestamp;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class MbrVO implements java.io.Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="memberno", updatable=false)
	private Integer memberno;
	
	@Column(name="memberaccount", updatable=false)
    private String memberaccount;
	
	@Column(name="membername")
    private String membername;
	
	@Column(name="membergender")
    private Integer membergender;
	
	@Column(name="memberpassword")
    private String memberpassword;
	
	@Column(name="memberphone")
    private String memberphone;
    
    @Column(name="memberemail", updatable=false)
    private String memberemail;
    
    @Column(name="memberaddress")
    private String memberaddress;
    
    @Column(name="memberjointime")
    private Timestamp memberjointime;
    
    @Column(name="memberbirthday")
    private Timestamp memberbirthday;
    
    @Column(name="membernation")
    private String membernation;
    
    @Column(name="memberpic")
    private byte[] memberpic;
    
    @Column(name="membercard")
    private String membercard;
    
    @Column(name="memberpoints")
    private Integer memberpoints;
    
    @Column(name="memberstat")
    private Integer memberstat;
    
    @Column(name="memberid")
    private String memberid;
    
    @Column(name="memberjob")
    private String memberjob;
    
    @Column(name="membersal")
    private Integer membersal;
    
    public MbrVO() {
	}

	public MbrVO(Integer memberno, String memberaccount, String membername, Integer membergender, String memberpassword,
			String memberphone, String memberemail, String memberaddress, Timestamp memberjointime,
			Timestamp memberbirthday, String membernation, byte[] memberpic, String membercard, Integer memberpoints,
			Integer memberstat, String memberid, String memberjob, Integer membersal) {
		super();
		this.memberno = memberno;
		this.memberaccount = memberaccount;
		this.membername = membername;
		this.membergender = membergender;
		this.memberpassword = memberpassword;
		this.memberphone = memberphone;
		this.memberemail = memberemail;
		this.memberaddress = memberaddress;
		this.memberjointime = memberjointime;
		this.memberbirthday = memberbirthday;
		this.membernation = membernation;
		this.memberpic = memberpic;
		this.membercard = membercard;
		this.memberpoints = memberpoints;
		this.memberstat = memberstat;
		this.memberid = memberid;
		this.memberjob = memberjob;
		this.membersal = membersal;
	}

	public Integer getMemberno() {
		return memberno;
	}

	public void setMemberno(Integer memberno) {
		this.memberno = memberno;
	}

	public String getMemberaccount() {
		return memberaccount;
	}

	public void setMemberaccount(String memberaccount) {
		this.memberaccount = memberaccount;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public Integer getMembergender() {
		return membergender;
	}

	public void setMembergender(Integer membergender) {
		this.membergender = membergender;
	}

	public String getMemberpassword() {
		return memberpassword;
	}

	public void setMemberpassword(String memberpassword) {
		this.memberpassword = memberpassword;
	}

	public String getMemberphone() {
		return memberphone;
	}

	public void setMemberphone(String memberphone) {
		this.memberphone = memberphone;
	}

	public String getMemberemail() {
		return memberemail;
	}

	public void setMemberemail(String memberemail) {
		this.memberemail = memberemail;
	}

	public String getMemberaddress() {
		return memberaddress;
	}

	public void setMemberaddress(String memberaddress) {
		this.memberaddress = memberaddress;
	}

	public Timestamp getMemberjointime() {
		return memberjointime;
	}

	public void setMemberjointime(Timestamp memberjointime) {
		this.memberjointime = memberjointime;
	}

	public Timestamp getMemberbirthday() {
		return memberbirthday;
	}

	public void setMemberbirthday(Timestamp memberbirthday) {
		this.memberbirthday = memberbirthday;
	}

	public String getMembernation() {
		return membernation;
	}

	public void setMembernation(String membernation) {
		this.membernation = membernation;
	}

	public byte[] getMemberpic() {
		return memberpic;
	}

	public void setMemberpic(byte[] memberpic) {
		this.memberpic = memberpic;
	}

	public String getMembercard() {
		return membercard;
	}

	public void setMembercard(String membercard) {
		this.membercard = membercard;
	}

	public Integer getMemberpoints() {
		return memberpoints;
	}

	public void setMemberpoints(Integer memberpoints) {
		this.memberpoints = memberpoints;
	}

	public Integer getMemberstat() {
		return memberstat;
	}

	public void setMemberstat(Integer memberstat) {
		this.memberstat = memberstat;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getMemberjob() {
		return memberjob;
	}

	public void setMemberjob(String memberjob) {
		this.memberjob = memberjob;
	}

	public Integer getMembersal() {
		return membersal;
	}

	public void setMembersal(Integer membersal) {
		this.membersal = membersal;
	}

	@Override
	public String toString() {
		return "MbrVO [memberno=" + memberno + ", memberaccount=" + memberaccount + ", membername=" + membername
				+ ", membergender=" + membergender + ", memberpassword=" + memberpassword + ", memberphone="
				+ memberphone + ", memberemail=" + memberemail + ", memberaddress=" + memberaddress
				+ ", memberjointime=" + memberjointime + ", memberbirthday=" + memberbirthday + ", membernation="
				+ membernation + ", memberpic=" + Arrays.toString(memberpic) + ", membercard=" + membercard
				+ ", memberpoints=" + memberpoints + ", memberstat=" + memberstat + ", memberid=" + memberid
				+ ", memberjob=" + memberjob + ", membersal=" + membersal + "]";
	}
	
}
