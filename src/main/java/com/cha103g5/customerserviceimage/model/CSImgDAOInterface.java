package com.cha103g5.customerserviceimage.model;

import java.util.List;

public interface CSImgDAOInterface {
    public void insert(CSImgVO csImgVO);
    public CSImgVO findByPrimaryKey(Integer recordNo);
    public List<CSImgVO> getAll();

}
