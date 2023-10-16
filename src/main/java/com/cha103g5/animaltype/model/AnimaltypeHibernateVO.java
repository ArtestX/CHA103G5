package com.cha103g5.animaltype.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "animaltype")
public class AnimaltypeHibernateVO {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自動遞增
    @Column(name = "pettype")
    private Integer petType;

    @Column(name = "pettypename")
    private String petTypeName;

	public AnimaltypeHibernateVO() {
		super();
	}
	
	public AnimaltypeHibernateVO(Integer petType, String petTypeName) {
		super();
		this.petType = petType;
		this.petTypeName = petTypeName;
	}

	public Integer getPetType() {
		return petType;
	}

	public void setPetType(Integer petType) {
		this.petType = petType;
	}

	public String getPetTypeName() {
		return petTypeName;
	}

	public void setPetTypeName(String petTypeName) {
		this.petTypeName = petTypeName;
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("AnimaltypeHiVO { ");
	    sb.append("寵物分類編號: ").append(petType).append(", ");
	    sb.append("寵物分類名稱: ").append(petTypeName);
	    sb.append(" }");
	    return sb.toString();
	}

}
