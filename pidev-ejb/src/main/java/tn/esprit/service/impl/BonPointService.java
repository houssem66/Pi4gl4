package tn.esprit.service.impl; 

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.BonPoint;
import iservices.IBonPointServiceLocal;
import iservices.IBonPointServiceRemote;

@LocalBean
@Stateful
public class BonPointService implements IBonPointServiceLocal,IBonPointServiceRemote {

	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;

	@Override
	public void add(BonPoint bp) {
		em.persist(bp);
		
	}

	@Override
	public void update(BonPoint bp) {
		
		
	}

	@Override
	public void delete(BonPoint bp) {
		em.remove(bp);
		
	}

	@Override
	public BonPoint findById(int id) {
		BonPoint bp=em.find(BonPoint.class, id);
		return bp;
	}
}
