package com.cha103g5.petinfo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "petpic")
public class PetPicVO implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "picid")
	private Integer picId;

	@ManyToOne // 多對一關聯表格
	@JoinColumn(name = "petid", referencedColumnName = "petid")
	private PetInfoVO petInfo;


	@Column(name = "petpic")
	private byte[] petPic;

	public Integer getPicId() {
		return picId;
	}

	public void setPicId(Integer picId) {
		this.picId = picId;
	}

	public PetInfoVO getPetInfo() {
		return petInfo;
	}

	public void setPetInfo(PetInfoVO petInfo) {
		this.petInfo = petInfo;
	}

	public byte[] getPetPic() {
		return petPic;
	}

	public void setPetPic(byte[] petPic) {
		this.petPic = petPic;
	}
}
