package com.cha103g5.customerservicerecord.model.old;

import java.util.List;

public interface CSRecDAOInterface {
    public void insert(CSRecVO csRecVO);
    public CSRecVO findByPrimaryKey(Integer recordNo);
    public List<CSRecVO> getAll();

}
