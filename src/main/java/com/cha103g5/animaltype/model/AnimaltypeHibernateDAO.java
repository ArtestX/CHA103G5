package com.cha103g5.animaltype.model;

import java.util.List;

public interface AnimaltypeHibernateDAO {

	public Integer addAnimalType(AnimaltypeHibernateVO animalType);  // 增
    public void updateAnimalType(AnimaltypeHibernateVO animalType); // 改
    public void deleteAnimalType(Integer id); // 刪
    public AnimaltypeHibernateVO getAnimalType(Integer id); // 查
    public List<AnimaltypeHibernateVO> getAll();
    
}
