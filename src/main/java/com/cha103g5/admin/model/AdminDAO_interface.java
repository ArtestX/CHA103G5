package com.cha103g5.admin.model;

import java.util.*;

public interface AdminDAO_interface {
    public void insert(AdminVO adminVO);
    public void update(AdminVO adminVO);
    public void delete(Integer adminNo);
    public AdminVO findByPrimaryKey(Integer adminNo);
    public List<AdminVO> getAll();

}
