package com.cha103g5.informationannouncement.model;

import java.util.List;

public interface informationannouncementDAOinterface {
    public void insert(informationannouncementVO InfoAnnVO);
    public void update(informationannouncementVO InfoAnnVO);
    public void delete(Integer infono);
    public informationannouncementVO findByPrimaryKey(Integer infono);
    public List<informationannouncementVO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 
}