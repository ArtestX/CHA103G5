package com.cha103g5.csrec.model;

import java.util.List;

public interface CSRecDAO_interface {
    public void insert(CSRecVO csRecVO);
    public CSRecVO findByPrimaryKey(Integer recordNo);
    public List<CSRecVO> getAll();

}
