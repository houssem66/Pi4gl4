package tn.esprit.service.interfaces;
import java.util.List;

import tn.esprit.entity.*;

public interface IFicheMetierServiceLocale {

	public void addFicheMetier(FicheMetier ficheMetier);
	public FicheMetier getFicheMetierById(int id);
	public void removeFicheMetier(int id);
	public void updateFicheMetier(FicheMetier ficheMetier);
	public List<FicheMetier> getAllFicheMetiers();
	public void affecterMat (MatriceComp matrice,FicheMetier ficheMetier);
    public void affecterAemploye(FicheMetier ficheMetier ,Employe employe);}
