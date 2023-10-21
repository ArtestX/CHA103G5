package com.cha103g5.report.model;

import java.util.Date;
import java.util.List;

public class TestReportDAO {
    public static void main(String[] args) {
        ReportDAO reportDAO = new ReportDAOImpl();

        // 新增
//        Report report1 = new Report();
//        report1.setMemberNo(1);
//        report1.setOrderDetNo(1);
//        report1.setReportContent("Test Report 1");
//        report1.setReportStat(1);
//        // 设置报告时间为当前时间
//        report1.setReportTime(new Date());
//        reportDAO.insert(report1);
//
//        // 修改
//        Report report2 = reportDAO.getById(1); // 将1替换为您要更新的报告的ID
//        if (report2 != null) {
//            report2.setReportContent("Updated Report Content");
//            report2.setReportStat(2);
//            // 设置报告时间为更新后的时间
//            report2.setReportTime(new Date());
//            reportDAO.update(report2);
//        }
//
//        // 删除
//        int reportIdToDelete = 2; // 将2替换为您要删除的报告的ID
//        reportDAO.delete(reportIdToDelete);

        // 查询單筆报告
        int reportIdToQuery = 3; // 将3替换为您要检索的报告的ID
        Report retrievedReport = reportDAO.getById(reportIdToQuery);
        if (retrievedReport != null) {
            System.out.println(retrievedReport);
        } else {
            System.out.println("Report not found.");
        }

        // 查詢多筆报告
        List<Report> reports = reportDAO.getAll();
        for (Report report : reports) {
            System.out.println(report);
        }
    }
}
