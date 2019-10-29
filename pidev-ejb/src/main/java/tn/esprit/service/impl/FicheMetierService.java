package tn.esprit.service.impl;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import tn.esprit.entity.*;
import tn.esprit.service.interfaces.IFicheMetierServiceLocale;

@LocalBean

@Stateless
public class FicheMetierService implements IFicheMetierServiceLocale{

@PersistenceContext(unitName="pidev-ejb")
	
	EntityManager em ;
	@Override
	public void addFicheMetier(FicheMetier ficheMetier) {
		em.persist(ficheMetier);
		
	}

	@Override
	public FicheMetier getFicheMetierById(int id) {
		// TODO Auto-generated method stub
		return em.find(FicheMetier.class, id);
	}

	@Override
	public void removeFicheMetier(int id) {
		// TODO Auto-generated method stub
		em.remove(em.find(FicheMetier.class, id));
	}

	@Override
	public void updateFicheMetier(FicheMetier ficheMetier) {
		FicheMetier us= em.find(FicheMetier.class,ficheMetier.getId());
		System.out.println("Updated !!"+ficheMetier.getId());
		us.setName(ficheMetier.getName());
		us.setDescription(ficheMetier.getDescription());
		
			}

	@Override
	public List<FicheMetier> getAllFicheMetiers() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT f from FicheMetier f", FicheMetier.class).getResultList();
		
	}

	@Override
	public void affecterMat(MatriceComp matrice,FicheMetier ficheMetier) {
		FicheMetier us= em.find(FicheMetier.class,ficheMetier.getId());
		us.setMatricecomp(matrice);
		
	}

	@Override
	public void affecterAemploye(FicheMetier ficheMetier,Employe employe) {
		
		FicheMetier us= em.find(FicheMetier.class,ficheMetier.getId());
		us.setEmploye(employe);
		
	}

}
