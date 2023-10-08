package com.cha103g5.admin.model;

import java.util.Date;

public class AdminVO {
    private Integer adminNo;
    private String adminAccount;
    private String adminPassword;
    private String adminName;
    private Date createDate;
    private Integer adminStat;
    private String adminEmail;
    private String adminPhone;

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

    public java.sql.Date getCreateDate() {
        return (java.sql.Date) createDate;
    }

    public void setCreateDate(java.sql.Date createDate) {
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
}
