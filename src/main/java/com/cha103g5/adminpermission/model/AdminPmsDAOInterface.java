package com.cha103g5.adminpermission.model;

import java.util.List;

public interface AdminPmsDAOInterface {
    public void insert(AdminPmsVO adminPmsVO);
    public AdminPmsVO findByPrimaryKey(Integer adminPmsNo);
    public List<AdminPmsVO> getAll();

}
