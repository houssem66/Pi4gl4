package tn.esprit.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class NiveauxMat implements Serializable {
	private static final long serialVersionUID = 2L;
	@EmbeddedId
	private  NiveauxMatPk niveauxMatPk;
	private int Niveaux;
	private int ide;
	@ManyToOne
    @JoinColumn(name = "idMat", referencedColumnName = "Id", insertable=false, updatable=false)
	private MatriceComp matriceComp;
	@ManyToOne
    @JoinColumn(name = "idComp", referencedColumnName = "Id", insertable=false, updatable=false)
	private Competance competance;
	
	
	public NiveauxMatPk getNiveauxMatPk() {
		return niveauxMatPk;
	}
	public void setNiveauxMatPk(NiveauxMatPk niveauxMatPk) {
		this.niveauxMatPk = niveauxMatPk;
	}
	public int getNiveaux() {
		return Niveaux;
	}
	public void setNiveaux(int niveaux) {
		Niveaux = niveaux;
	}
	public MatriceComp getMatriceComp() {
		return matriceComp;
	}
	public void setMatriceComp(MatriceComp matriceComp) {
		this.matriceComp = matriceComp;
	}
	public Competance getCompetance() {
		return competance;
	}
	public void setCompetance(Competance competance) {
		this.competance = competance;
	}

}
