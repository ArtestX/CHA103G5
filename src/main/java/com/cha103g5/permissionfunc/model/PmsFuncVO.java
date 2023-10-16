package com.cha103g5.permissionfunc.model;

import javax.persistence.*;

@Entity
@Table(name = "permissionfunc")
public class PmsFuncVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permissionsno", updatable = false)
    private Integer pmsNo;

    @Column(name = "pmsname")
    private String pmsName;

    @Column(name = "permissionsdes")
    private String pmsDes;

    public Integer getPmsNo() {
        return pmsNo;
    }

    public void setPmsNo(Integer pmsNo) {
        this.pmsNo = pmsNo;
    }

    public String getPmsName() {
        return pmsName;
    }

    public void setPmsName(String pmsName) {
        this.pmsName = pmsName;
    }

    public String getPmsDes() {
        return pmsDes;
    }

    public void setPmsDes(String pmsDes) {
        this.pmsDes = pmsDes;
    }
}


