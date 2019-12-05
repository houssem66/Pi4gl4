package tn.esprit.entity;

import java.io.Serializable;

public class NiveauxFichePk implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	private int idFiche;
	private int idComp;
	public int getIdFiche() {
		return idFiche;
	}
	public void setIdFiche(int idFiche) {
		this.idFiche = idFiche;
	}
	public int getIdComp() {
		return idComp;
	}
	public void setIdComp(int idComp) {
		this.idComp = idComp;
	}
	public NiveauxFichePk(int idComp, int idFiche) {
		super();
		this.idFiche = idFiche;
		this.idComp = idComp;
	}
	public NiveauxFichePk() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idComp;
		result = prime * result + idFiche;
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
		NiveauxFichePk other = (NiveauxFichePk) obj;
		if (idComp != other.idComp)
			return false;
		if (idFiche != other.idFiche)
			return false;
		return true;
	}
	

}
