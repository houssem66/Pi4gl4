package tn.esprit.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity(name="NiveauxFiche")
public class NiveauxFiche implements Serializable {
	private static final long serialVersionUID = 2L;
	@EmbeddedId
	private  NiveauxFichePk niveauxFichePk;
	private int Niveaux;
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name = "idFiche", referencedColumnName = "Id", insertable=false, updatable=false)
	private FicheMetier fiche;
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name = "idComp", referencedColumnName = "Id", insertable=false, updatable=false)
	private Competance competance;
	public NiveauxFichePk getNiveauxFichePk() {
		return niveauxFichePk;
	}
	public void setNiveauxFichePk(NiveauxFichePk niveauxFichePk) {
		this.niveauxFichePk = niveauxFichePk;
	}
	public int getNiveaux() {
		return Niveaux;
	}
	public void setNiveaux(int niveaux) {
		Niveaux = niveaux;
	}
	public FicheMetier getFiche() {
		return fiche;
	}
	public void setFiche(FicheMetier fiche) {
		this.fiche = fiche;
	}
	public Competance getCompetance() {
		return competance;
	}
	public void setCompetance(Competance competance) {
		this.competance = competance;
	}
	
	
	
}
