package com.cha103g5.csimg.model;

import java.util.List;

public interface CSImgDAO_interface {
    public void insert(CSImgVO csImgVO);
    public CSImgVO findByPrimaryKey(Integer recordNo);
    public List<CSImgVO> getAll();

}
