package com.idat.brig.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name= "MallaCurricural")
@Entity
public class MallaCurricural {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMalla;
	private Date  año;
	
	@OneToOne(mappedBy = "MallaCurricular")
	private Universidad universidad;
	
	
	public MallaCurricural() {
		super();
	}
	public Integer getIdMalla() {
		return idMalla;
	}
	public void setIdMalla(Integer idMalla) {
		this.idMalla = idMalla;
	}
	public Date getAño() {
		return año;
	}
	public void setAño(Date año) {
		this.año = año;
	}
	
	
	

}
