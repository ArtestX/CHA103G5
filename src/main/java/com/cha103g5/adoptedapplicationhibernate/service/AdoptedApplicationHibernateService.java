package com.cha103g5.adoptedapplicationhibernate.service;

import com.cha103g5.adoptedapplicationhibernate.model.AdoptedApplicationHibernate;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public interface AdoptedApplicationHibernateService {
    int addApplication(AdoptedApplicationHibernate application);
    int updateApplication(AdoptedApplicationHibernate application);
    int deleteApplication(Integer applicationNo);
    AdoptedApplicationHibernate getApplicationById(Integer applicationNo);
    List<AdoptedApplicationHibernate> getAllApplications();
    List<AdoptedApplicationHibernate> getApplicationsByPetIdAndLotteryDate(Integer petId, Date lotteryDate);
    List<AdoptedApplicationHibernate> getApplicationsByDatedAndTime(Date interactionDate, LocalTime startTime, LocalTime endTime);
    List<AdoptedApplicationHibernate> getApplicationsByMemberNo(Integer memberNo);
    List<AdoptedApplicationHibernate> getApplicationsByCompositeQuery(Map<String, String[]> map);
    List<AdoptedApplicationHibernate> getAllApplications(int currentPage);
    int getPageTotal();
    int getDataTotal();
}
