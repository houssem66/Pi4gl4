package tn.esprit.service.interfaces;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entity.*;
@Remote
public interface INiveauxMatServiceRemote {

	public void addNiveauxMat(int idComp, int idFiche,int niveau);
	public NiveauxMat getNiveauxMatById(int id);
	public void removeNiveauxMat(int idcom,int idMat);
	public void updateNiveauxMat(NiveauxMat NiveauxMat);
	public List<NiveauxMat> getAllNiveauxMats();
	
}
