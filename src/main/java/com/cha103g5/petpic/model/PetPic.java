package com.cha103g5.petpic.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "petPic")
public class PetPic implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "picId")
	private Integer picId;

	@ManyToOne // 多對一關聯表格
	@JoinColumn(name = "petId", referencedColumnName = "petId")
	private PetInFo petInFo;


	@Column(name = "petPic")
	private byte[] petPic;

	public Integer getPicId() {
		return picId;
	}

	public void setPicId(Integer picId) {
		this.picId = picId;
	}

	public PetInFo getPetInFo() {
		return petInFo;
	}

	public void setPetInFo(PetInFo petInFo) {
		this.petInFo = petInFo;
	}


	public byte[] getPetPic() {
		return petPic;
	}

	public void setPetPic(byte[] petPic) {
		this.petPic = petPic;
	}
}
