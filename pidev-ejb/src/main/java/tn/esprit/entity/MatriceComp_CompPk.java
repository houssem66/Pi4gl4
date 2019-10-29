package tn.esprit.entity;

import javax.persistence.Embeddable;

@Embeddable
public class MatriceComp_CompPk {

	private int idMatrice;
	
	private int idCompetance;

	public MatriceComp_CompPk(int idMatrice, int idCompetance) {
		
		this.idMatrice = idMatrice;
		this.idCompetance = idCompetance;
	}

	public int getIdMatrice() {
		return idMatrice;
	}

	public void setIdMatrice(int idMatrice) {
		this.idMatrice = idMatrice;
	}

	public int getIdCompetance() {
		return idCompetance;
	}

	public void setIdCompetance(int idCompetance) {
		this.idCompetance = idCompetance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCompetance;
		result = prime * result + idMatrice;
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
		MatriceComp_CompPk other = (MatriceComp_CompPk) obj;
		if (idCompetance != other.idCompetance)
			return false;
		if (idMatrice != other.idMatrice)
			return false;
		return true;
	}

}
