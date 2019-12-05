package tn.esprit.service.interfaces;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entity.*;
@Remote
public interface INiveauxFicheServiceRemote {

	public void addNiveauxFiche(int idComp,int idFiche,int niveau);
	public NiveauxFiche getNiveauxFicheByIdFiche(int id);
	public void removeNiveauxFiche(int idcom,int idFiche);
	public void updateNiveauxFiche(NiveauxFiche niveauxFiche);
	public List<Competance> getAllCompetancesByFicheId(int id);
	
}
