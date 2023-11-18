package com.cha103g5.petpic.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "petpic")
public class PetPicVO implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "picid")
	private Integer picId;



	@Column(name = "petpic")
	private byte[] petPic;

	public Integer getPicId() {
		return picId;
	}

	public void setPicId(Integer picId) {
		this.picId = picId;
	}


	public byte[] getPetPic() {
		return petPic;
	}

	public void setPetPic(byte[] petPic) {
		this.petPic = petPic;
	}
}
