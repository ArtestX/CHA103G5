package com.cha103g5.adminpermission.model;

import javax.persistence.*;

@Entity
@Table(name = "adminpermission")
public class AdminPmsVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adminpmsno", updatable = false)
    private Integer adminPmsNo;

    @Column(name = "permissionsno")
    private Integer pmsNo;

    @Column(name = "adminno")
    private Integer adminNo;

    public Integer getAdminPmsNo() {
        return adminPmsNo;
    }

    public void setAdminPmsNo(Integer adminPmsNo) {
        this.adminPmsNo = adminPmsNo;
    }

    public Integer getPmsNo() {
        return pmsNo;
    }

    public void setPmsNo(Integer pmsNo) {
        this.pmsNo = pmsNo;
    }

    public Integer getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(Integer adminNo) {
        this.adminNo = adminNo;
    }
}