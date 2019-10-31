package tn.esprit.service.impl; 

import java.awt.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Reclammation;
import entities.Tache;
import iservices.ITacheServiceLocal;
import iservices.ITacheServiceRemote;

@LocalBean
@Stateful
public class TacheService implements ITacheServiceLocal,ITacheServiceRemote{

	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;

	@Override
	public void add(Tache bp) {
		// TODO Auto-generated method stub
		em.persist(bp);
		
	}

	@Override
	public void update(Tache bp2) {
		Tache t = em.find(Tache.class, bp2.getId());
		t.setDateDeDebut(bp2.getDateDeDebut());
		t.setEtatActuel(bp2.getEtatActuel());
		t.setNom(bp2.getNom());
		t.setNombreDheuresEstimes(bp2.getNombreDheuresEstimes());
		t.setEmploye(bp2.getEmploye());
		t.setPriorite(bp2.getPriorite());
		t.setTimesheet(bp2.getTimesheet());
		
		
	}

	@Override
	public void delete(int id) {
		Tache t=em.find(Tache.class, id);
		em.remove(t);
		
	}

	@Override
	public Tache findById(int id) {
		Tache bp=em.find(Tache.class, id);
		return bp;
		}
	

	@Override
	public java.util.List<Tache> findAll() {
		String querry="select t from Tache t";
		return em.createQuery(querry,Tache.class).getResultList();
		 
		
	}
}
