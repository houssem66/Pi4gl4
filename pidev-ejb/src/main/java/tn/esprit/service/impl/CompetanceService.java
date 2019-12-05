package tn.esprit.service.impl; 
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import tn.esprit.entity.*;
import tn.esprit.service.interfaces.ICompetanceServiceRemote;

@LocalBean

@Stateless
public class CompetanceService implements ICompetanceServiceRemote{

@PersistenceContext(unitName="pidev-ejb")
	
	EntityManager em ;

	@Override
	public int addCompetance(Competance competance) {
		
		em.persist(competance);
		return competance.getId();
		
	}
	@Override
	public int addlol(lol competance) {
		
		em.persist(competance);
		return 0;
		
	}
	@Override
	public Competance getCompetanceById(int id) {
		// TODO Auto-generated method stub
		return em.find(Competance.class, id);
	}

	@Override
	public void removeCompetance(int id) {
		// TODO Auto-generated method stub
		em.remove(em.find(Competance.class, id));
		System.out.println("Deleted!!!");
	}

	@Override
	public void updateCompetance(Competance competance) {
		Competance us= em.find(Competance.class,competance.getId());
		System.out.println("Updated !!"+competance.getId());
		us.setName(competance.getName());
		us.setDescription(competance.getDescription());
		us.setType(competance.getType());
		
		
		
	}
	@Override
	public List<Competance> getAllCompetances() {
		
		return em.createQuery("SELECT c from Competance c", Competance.class).getResultList();
	}

	@Override
	public List<Competance> getAllCompetancesByName(String Name) {
		 TypedQuery<Competance> query = em.createQuery("select m from Competance m where m.Name = :name",Competance.class);
		query.setParameter("name", Name);
		List<Competance> c =  query.getResultList();
		
		return c;
	
	}

}
