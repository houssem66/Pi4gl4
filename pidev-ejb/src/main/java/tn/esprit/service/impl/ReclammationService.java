package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.BonPoint;
import entities.Reclammation;
import iservices.IReclammationServiceLocal;
import iservices.IReclammationServiceRemote;

@LocalBean
@Stateful
public class ReclammationService implements IReclammationServiceLocal,IReclammationServiceRemote {

	@PersistenceContext(unitName = "advyteam")
	EntityManager em;

	@Override
	public void add(Reclammation bp) {
		// TODO Auto-generated method stub
		em.persist(bp);
		
	}

	@Override
	public void update(Reclammation bp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Reclammation bp) {
		em.remove(bp);
		
	}

	@Override
	public Reclammation findById(int id) {
		Reclammation bp=em.find(Reclammation.class, id);
		return bp;
	}
}
