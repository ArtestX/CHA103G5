package com.cha103g5.adminpms.model;

import java.util.List;

public interface AdminPmsDAO_interface {
    public void insert(AdminPmsVO adminPmsVO);
    public AdminPmsVO findByPrimaryKey(Integer adminPmsNo);
    public List<AdminPmsVO> getAll();

}
