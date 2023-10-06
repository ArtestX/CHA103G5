package com.member;

public class Member {
	private String member_no;
	
	public Member() {
		super();
		
	}
	
	public Member(String member_no) {
		super();
		this.member_no = member_no;
	}



	public String getMember_no() {
		return member_no;
	}

	public void setMember_no(String member_no) {
		this.member_no = member_no;
	}
}
