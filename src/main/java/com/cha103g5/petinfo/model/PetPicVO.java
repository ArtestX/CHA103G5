package com.cha103g5.petinfo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "petpic")
public class PetPicVO implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "picid")
	private Integer picId;

	@Column(name = "petid")
	private Integer petId;

	@Column(name = "petpic")
	private byte[] petPic;

	@ManyToOne // 多對一關聯表格
	@JoinColumn(name = "petid", insertable = false, updatable = false, referencedColumnName = "petid")
	private PetVO petVo;

}
