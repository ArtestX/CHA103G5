package com.cha103g5.admin.model;

import javax.persistence.*;

import java.sql.Date;


@Entity
@Table(name = "admin")
public class AdminVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adminno", updatable = false)
    private Integer adminNo;

    @Column(name = "adminaccount")
    private String adminAccount;

    @Column(name = "adminpassword")
    private String adminPassword;

    @Column(name = "adminname")
    private String adminName;

    @Column(name = "createddate")
    private Date createDate;

    @Column(name = "adminstat", columnDefinition = "tinyint")
    private Integer adminStat;

    @Column(name = "adminemail")
    private String adminEmail;

    @Column(name = "adminphone")
    private String adminPhone;

    @Column(name = "adminpic", columnDefinition = "MEDIUMBLOB")
    private byte[] adminPic;
    

    public Integer getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(Integer adminNo) {
        this.adminNo = adminNo;
    }

    public String getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Date getCreateDate() {
        return  createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getAdminStat() {
        return adminStat;
    }

    public void setAdminStat(Integer adminStat) {
        this.adminStat = adminStat;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

	public byte[] getAdminPic() {
		return adminPic;
	}

	public void setAdminPic(byte[] adminPic) {
		this.adminPic = adminPic;
	}

}

