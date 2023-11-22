package com.cha103g5.adoptedapplicationhibernate.dao;

import com.cha103g5.adoptedapplicationhibernate.model.AdoptedApplicationHibernate;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public interface AdoptedApplicationHibernateDao {

    int add(AdoptedApplicationHibernate adoptedApplication);
    int update(AdoptedApplicationHibernate adoptedApplication);
    int delete(Integer applicationNo);
    AdoptedApplicationHibernate getById(Integer applicationNo);
    List<AdoptedApplicationHibernate> getAll();
    List<AdoptedApplicationHibernate> getByPetIdAndLotteryDate(Integer petId, Date lotteryDate);
    List<AdoptedApplicationHibernate> getByDatedAndTime(Date interactionDate, LocalTime startTime, LocalTime endTime);
    List<AdoptedApplicationHibernate> getByMemberNo(Integer memberNo);
    List<AdoptedApplicationHibernate> getByCompositeQuery(Map<String, String> map);
    List<AdoptedApplicationHibernate> getAll(int currentPage);
    long getTotal();

}
