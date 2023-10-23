package com.cha103g5.admin.model;

import com.cha103g5.member.model.MemberVO;
import com.cha103g5.util.HibernateUtil;

import net.bytebuddy.description.DeclaredByType;

import java.sql.Date;
import java.util.List;

public class AdminService {

    private AdminHibernateDAOInterface dao;

    public AdminService() {

        dao = new AdminHibernateDAO(HibernateUtil.getSessionFactory());
    }

    public AdminVO addAdmin(
                           	String adminAccount,
                            String adminPassword,
                            String adminName,
                            Date createDate,
                            Integer adminStat,
                            String adminEmail,
                            String adminPhone,
                            byte[] adminPic
    ) {

        AdminVO adminVO = new AdminVO();
        adminVO.setAdminAccount(adminAccount);
        adminVO.setAdminPassword(adminPassword);
        adminVO.setAdminName(adminName);
        adminVO.setCreateDate(createDate);
        adminVO.setAdminStat(adminStat);
        adminVO.setAdminEmail(adminEmail);
        adminVO.setAdminPhone(adminPhone);
        adminVO.setAdminPic(adminPic);
        dao.insert(adminVO);
        return adminVO;
    }

    //預留給 Struts 2 或 Spring MVC 用
//    public void addAdmin(AdminVO adminVO) {
//        dao.insert(adminVO);
//    }

    public AdminVO updateAdmin(Integer adminNo,
                           String adminAccount,
                           String adminPassword,
                           String adminName,
                           Date createDate,
                           Integer adminStat,
                           String adminEmail,
                           String adminPhone,
                           byte[] adminPic
                           
    ) {
        AdminVO adminVO = dao.findByPrimaryKey(adminNo); 
        if (adminVO != null) {
            adminVO.setAdminNo(adminNo);
            adminVO.setAdminAccount(adminAccount);
            adminVO.setAdminPassword(adminPassword);
            adminVO.setAdminName(adminName);
            adminVO.setCreateDate(createDate);
            adminVO.setAdminStat(adminStat);
            adminVO.setAdminEmail(adminEmail);
            adminVO.setAdminPhone(adminPhone);
            adminVO.setAdminPic(adminPic);
            dao.update(adminVO);
        }
        return dao.findByPrimaryKey(adminNo);
    }

    //預留給 Struts 2 用的
//    public void updateAdmin(AdminVO adminVO) {
//        dao.update(adminVO);
//    }

    public AdminVO deleteAdmin(Integer adminNo) {
        AdminVO memberVO = dao.findByPrimaryKey(adminNo); // 先獲取現有的 MemberVO 物件
        if (memberVO != null)
            dao.delete(adminNo);
        return null;
    }

    public AdminVO getOneAdmin(Integer adminNo) {
        return dao.findByPrimaryKey(adminNo);
    }

    public List<AdminVO> getAll() {
        return dao.getAll();
    }
    
    public AdminVO userAuth(String adminAccount,String adminPassword) {
    	return dao.findByNamePassword(adminAccount,adminPassword);
        
    }


}
