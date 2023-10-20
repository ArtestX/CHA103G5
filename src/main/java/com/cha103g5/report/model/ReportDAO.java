package com.cha103g5.report.model;

import java.util.List;
import java.util.Map;

public interface ReportDAO {
    int insert(Report entity);

    int update(Report entity);
    
    int delete(Integer id);
     
    Report getById(Integer id);
    
    List<Report> getAll();
    
    List<Report> getByCompositeQuery(Map<String, String> map);
    
    List<Report> getAll(int currentPage);
    
    long getTotal();
}
