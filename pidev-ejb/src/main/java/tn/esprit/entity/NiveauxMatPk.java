package tn.esprit.entity;

import java.io.Serializable;

public class NiveauxMatPk implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idMat;
	private int idComp;
	public int getIdMat() {
		return idMat;
	}
	public void setIdMat(int idMat) {
		this.idMat = idMat;
	}
	public int getIdComp() {
		return idComp;
	}
	public void setIdComp(int idComp) {
		this.idComp = idComp;
	}
	public NiveauxMatPk(int idComp, int idMat) {
		super();
		this.idMat = idMat;
		this.idComp = idComp;
	}
	public NiveauxMatPk() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idComp;
		result = prime * result + idMat;
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
		NiveauxMatPk other = (NiveauxMatPk) obj;
		if (idComp != other.idComp)
			return false;
		if (idMat != other.idMat)
			return false;
		return true;
	}
	

}
