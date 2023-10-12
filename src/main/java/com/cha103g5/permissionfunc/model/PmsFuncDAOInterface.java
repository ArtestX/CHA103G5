package com.cha103g5.permissionfunc.model;



import java.util.List;

public interface PmsFuncDAOInterface {
    public void insert(PmsFuncVO pmsFuncVO);
    public void update(PmsFuncVO pmsFuncVO);
    public void delete(Integer pmsNo);
    public PmsFuncVO findByPrimaryKey(Integer pmsNo);
    public List<PmsFuncVO> getAll();

}
