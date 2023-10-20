package com.cha103g5.report.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_no", updatable = false)
    private Integer reportNo;

    @Column(name = "member_no")
    private Integer memberNo;

    @Column(name = "order_det_no")
    private Integer orderDetNo;

    @Column(name = "report_content")
    private String reportContent;

    @Column(name = "report_stat")
    private Integer reportStat;

    @Column(name = "report_time")
    private Date reportTime;

    public Integer getReportNo() {
        return reportNo;
    }

    public void setReportNo(Integer reportNo) {
        this.reportNo = reportNo;
    }

    public Integer getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Integer memberNo) {
        this.memberNo = memberNo;
    }

    public Integer getOrderDetNo() {
        return orderDetNo;
    }

    public void setOrderDetNo(Integer orderDetNo) {
        this.orderDetNo = orderDetNo;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public Integer getReportStat() {
        return reportStat;
    }

    public void setReportStat(Integer reportStat) {
        this.reportStat = reportStat;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    @Override
    public String toString() {
        return "Report [reportNo=" + reportNo + ", memberNo=" + memberNo + ", orderDetNo=" + orderDetNo +
                ", reportContent=" + reportContent + ", reportStat=" + reportStat + ", reportTime=" + reportTime + "]";
    }
}
