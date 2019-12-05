package tn.esprit.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import javax.persistence.JoinColumn;
@Entity
public class MatriceComp implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="Id",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@OneToOne(mappedBy="matriceComp",cascade=CascadeType.ALL)
	private Employe employe;
	private String Description;
	@OneToMany(mappedBy="matriceComp")
	private  List<NiveauxMat> NiveauxMat;

	public MatriceComp() {

	}

	

	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public List<NiveauxMat> getNiveauxMat() {
		return NiveauxMat;
	}


	public void setNiveauxMat(List<NiveauxMat> niveauxMat) {
		NiveauxMat = niveauxMat;
	}



	public MatriceComp(int id, String description) {
		super();
		Id = id;
		Description = description;
	}



	public MatriceComp(String description) {
		super();
		Description = description;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Description == null) ? 0 : Description.hashCode());
		result = prime * result + Id;
		result = prime * result + ((NiveauxMat == null) ? 0 : NiveauxMat.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatriceComp other = (MatriceComp) obj;
		if (Description == null) {
			if (other.Description != null)
				return false;
		} else if (!Description.equals(other.Description))
			return false;
		if (Id != other.Id)
			return false;
		if (NiveauxMat == null) {
			if (other.NiveauxMat != null)
				return false;
		} else if (!NiveauxMat.equals(other.NiveauxMat))
			return false;
		return true;
	}


	


	
}
