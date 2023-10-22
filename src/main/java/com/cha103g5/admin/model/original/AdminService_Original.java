package com.cha103g5.admin.model.original;

import java.sql.Timestamp;
import java.util.List;

//public class AdminService_Original {
//
//    private AdminHibernateDAOInterface dao;
//
//    public AdminService_Original() {
//
//        dao = new AdminHibernateDAO_Original();
//    }
//
//    public AdminVO addAdmin(Integer adminNo,
//                            String adminAccount,
//                            String adminPassword,
//                            String adminName,
//                            Timestamp createDate,
//                            Integer adminStat,
//                            String adminEmail,
//                            String adminPhone
//    ) {
//
//        AdminVO adminVO = new AdminVO();
//        adminVO.setAdminAccount(adminAccount);
//        adminVO.setAdminPassword(adminPassword);
//        adminVO.setAdminName(adminName);
//        adminVO.setCreateDate(createDate);
//        adminVO.setAdminStat(adminStat);
//        adminVO.setAdminEmail(adminEmail);
//        adminVO.setAdminPhone(adminPhone);
//        dao.insert(adminVO);
//        return adminVO;
//    }
//
//    //預留給 Struts 2 或 Spring MVC 用
////    public void addAdmin(AdminVO adminVO) {
////        dao.insert(adminVO);
////    }
//
//    public AdminVO updateAdmin(Integer adminNo,
//                           String adminAccount,
//                           String adminPassword,
//                           String adminName,
//                           Timestamp createDate,
//                           Integer adminStat,
//                           String adminEmail,
//                           String adminPhone
//                           
//    ) {
//
//        AdminVO adminVO = new AdminVO();
//        adminVO.setAdminNo(adminNo);
//        adminVO.setAdminAccount(adminAccount);
//        adminVO.setAdminPassword(adminPassword);
//        adminVO.setAdminName(adminName);
//        adminVO.setCreateDate(createDate);
//        adminVO.setAdminStat(adminStat);
//        adminVO.setAdminEmail(adminEmail);
//        adminVO.setAdminPhone(adminPhone);
//        dao.update(adminVO);
//
//        return dao.findByPrimaryKey(adminNo);
//    }
//
//    //預留給 Struts 2 用的
////    public void updateAdmin(AdminVO adminVO) {
////        dao.update(adminVO);
////    }
//
//    public void deleteAdmin(Integer adminNo) {
//        dao.delete(adminNo);
//    }
//
//    public AdminVO getOneAdmin(Integer adminNo) {
//        return dao.findByPrimaryKey(adminNo);
//    }
//
//    public List<AdminVO> getAll() {
//        return dao.getAll();
//    }
//
//
//
//}
