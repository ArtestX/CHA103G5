package com.cha103g5.infoann.model;

import java.util.List;

public interface InfoAnnDAO_interface {
    public void insert(InfoAnnVO InfoAnnVO);
    public void update(InfoAnnVO InfoAnnVO);
    public void delete(Integer infoNo);
    public InfoAnnVO findByPrimaryKey(Integer infoNo);
    public List<InfoAnnVO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 
}