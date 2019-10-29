package tn.esprit.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class MatriceComp_Comp {
	
	@EmbeddedId
	private MatriceComp_CompPk Mat_CompPk;
	@ManyToOne
    @JoinColumn(name = "idCompetance", referencedColumnName = "Id", insertable=false, updatable=false)
	private Competance competance;
	
	//idEmploye est a la fois primary key et foreign key
	@ManyToOne
    @JoinColumn(name = "idMatrice", referencedColumnName = "Id", insertable=false, updatable=false)
	private MatriceComp matriceComp;
	private int Niveau;
	public int getNiveau() {
		return Niveau;
	}
	public void setNiveau(int niveaux) {
		Niveau = niveaux;
	}
	
}
