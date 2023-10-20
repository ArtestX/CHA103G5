package com.cha103g5.adoptedapplication.model;

import java.sql.Date;
import java.util.List;

public interface HibernateAdoptedApplicationDAO {

	public Integer addApplication(HibernateAdoptedApplicationVO application);  // 新增申請
    public void updateApplication(HibernateAdoptedApplicationVO application);  // 更新申請
//    public void deleteApplication(Integer applicationNo);  // 刪除申請
    public List<HibernateAdoptedApplicationVO> findByPetidAndLotterydate(Integer petid, Date lotterydate);  // 根據寵物的ID和抽獎日期查找申請
    public List<HibernateAdoptedApplicationVO> getAll();  // 獲取所有申請
}
