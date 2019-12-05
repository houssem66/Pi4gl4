package tn.esprit.service.impl;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import tn.esprit.entity.*;
import tn.esprit.service.interfaces.IFicheMetierServiceRemote;

@LocalBean

@Stateless
public class FicheMetierService implements IFicheMetierServiceRemote{

@PersistenceContext(unitName="pidev-ejb")
	
	EntityManager em ;
	@Override
	public int addFicheMetier(FicheMetier ficheMetier) {
		em.persist(ficheMetier);
		return ficheMetier.getId();
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
	/*	FicheMetier us= em.find(FicheMetier.class,ficheMetier.getId());
		System.out.println("Updated !!"+ficheMetier.getId());
		us.setName(ficheMetier.getName());
		us.setDescription(ficheMetier.getDescription());
		*/
			}

	@Override
	public List<FicheMetier> getAllFicheMetiers() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT f from FicheMetier f", FicheMetier.class).getResultList();
		
	}

	

}
