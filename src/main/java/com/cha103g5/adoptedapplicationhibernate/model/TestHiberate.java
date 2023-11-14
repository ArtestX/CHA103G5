package com.cha103g5.adoptedapplicationhibernate.model;

import com.cha103g5.adoptedapplicationhibernate.dao.AdoptedApplicationHibernateDao;
import com.cha103g5.adoptedapplicationhibernate.dao.AdoptedApplicationHibernateDaoImpl;
import com.cha103g5.adoptedapplicationhibernate.service.AdoptedApplicationHibernateService;
import com.cha103g5.adoptedapplicationhibernate.service.AdoptedApplicationHibernateServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;

public class TestHiberate {

    public static void main(String[] args) {
//        AdoptedApplicationHibernateDao adoptedApplicationHibernateDao = new AdoptedApplicationHibernateDaoImpl();
        AdoptedApplicationHibernateService service = new AdoptedApplicationHibernateServiceImpl();


//        // 新增
//        AdoptedApplicationHibernate newApplication = new AdoptedApplicationHibernate();
//        newApplication.setAdminNo(1);
//        newApplication.setMemberNo(1);
//        newApplication.setPetId(1);
//
//        Date today = new Date(new java.util.Date().getTime());
//        newApplication.setLotteryDate(today);
//
//        newApplication.setLotteryResult(1);
//        newApplication.setApplicationDate(today);
//        newApplication.setInteractionDate(today);
//        newApplication.setApplicationStat(1);
//        newApplication.setSignaturePhoto(new byte[]{});
//        newApplication.setApplicantNotes("zzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
//
//        int applicationNo = service.addApplication(newApplication);
//
//        if (applicationNo != -1) {
//            System.out.println("新增成功，申請編號: " + applicationNo);
//        } else {
//            System.out.println("新增失敗");
//        }

//        // 修改
//        AdoptedApplicationHibernate updateApplication = new AdoptedApplicationHibernate();
//        updateApplication.setApplicationNo(14);
//        updateApplication.setAdminNo(2);
//        updateApplication.setMemberNo(2);
//        updateApplication.setPetId(2);
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new java.util.Date());
//        calendar.add(Calendar.DATE, 1);
//        Date tomorrow = new Date(calendar.getTimeInMillis());
//        updateApplication.setLotteryDate(tomorrow);
//
//        updateApplication.setLotteryResult(2);
//        updateApplication.setApplicationDate(tomorrow);
//        updateApplication.setInteractionDate(tomorrow);
//        updateApplication.setApplicationStat(2);
//        updateApplication.setSignaturePhoto(new byte[]{});
//        updateApplication.setApplicantNotes("updateupdateupdateupdateupdate");
//        service.updateApplication(updateApplication);
//
//        int updateResult = service.updateApplication(updateApplication);
//
//        if (updateResult == 1) {
//            System.out.println("修改成功");
//        } else {
//            System.out.println("修改失敗");
//        }

//        // 刪除
//        int deleteApplicationNo = 14;
//        int deleteResult = service.deleteApplication(deleteApplicationNo);
//
//        if (deleteResult == 1) {
//            System.out.println("刪除成功，申請編號: " + deleteApplicationNo);
//        } else {
//            System.out.println("刪除失敗");
//        }

//        // 查詢單筆
//        int ApplicationNo = 1;
//        AdoptedApplicationHibernate oneApplication = service.getApplicationById(ApplicationNo);
//
//        if (oneApplication != null) {
//            System.out.println("查詢成功，找到的申請資料: " + oneApplication);
//        } else {
//            System.out.println("未找到指定的申請編號: " + ApplicationNo);
//        }

//        // 查詢全部
//        List<AdoptedApplicationHibernate> allApplications = service.getAllApplications();
//
//        if (allApplications != null) {
//            for (AdoptedApplicationHibernate application : allApplications) {
//                System.out.println(application);
//            }
//            System.out.println("查詢成功，總共找到 " + allApplications.size() + " 條申請記錄。");
//        } else {
//            System.out.println("查詢失敗或沒有找到任何申請記錄。");
//        }


//        // 查詢多筆 PetId, LotteryDate
//        int petId = 3;
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        String lotteryDateStr = "2023-11-12";
//
//        try {
//            Date lotteryDate = new Date(format.parse(lotteryDateStr).getTime());
//
//            List<AdoptedApplicationHibernate> applications = service.getApplicationsByPetIdAndLotteryDate(petId, lotteryDate);
//
//            if (applications != null && !applications.isEmpty()) {
//                for (AdoptedApplicationHibernate application : applications) {
//                    System.out.println(application);
//                }
//                System.out.println("查詢成功，找到 " + applications.size() + " 條匹配的申請記錄。");
//            } else {
//                System.out.println("沒有找到匹配的申請記錄。");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("日期解析錯誤");
//        }


//        // 查詢多筆 MemberNo
//        int memberNo = 3;
//        List<AdoptedApplicationHibernate> applications = service.getApplicationsByMemberNo(memberNo);
//
//        if (applications != null && !applications.isEmpty()) {
//            for (AdoptedApplicationHibernate application : applications) {
//                System.out.println(application);
//            }
//            System.out.println("查詢成功，找到 " + applications.size() + " 條匹配的申請記錄。");
//        } else {
//            System.out.println("沒有找到匹配的申請記錄。");
//        }

    }
}
