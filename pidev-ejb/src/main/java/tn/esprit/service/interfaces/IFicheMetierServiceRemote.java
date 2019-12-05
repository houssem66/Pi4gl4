package tn.esprit.service.interfaces;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entity.*;
@Remote
public interface IFicheMetierServiceRemote {

	public int addFicheMetier(FicheMetier ficheMetier);
	public FicheMetier getFicheMetierById(int id);
	public void removeFicheMetier(int id);
	public void updateFicheMetier(FicheMetier ficheMetier);
	public List<FicheMetier> getAllFicheMetiers();
	
   
    }
