package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Criteria;
import servicesInterfaces.CriteriaServiceRemote;



@Stateless
@LocalBean
public class CriteriaService implements CriteriaServiceRemote {
	
	@PersistenceContext(unitName="pidev-ejb")
	private EntityManager em;

	@Override
	public void ajouterCriteria(Criteria c) {
		em.persist(c);
	}
	@Override
	public List<Criteria> getAllCriterias() {
		List<Criteria> cs = em.createQuery("Select c from Criteria c",
				Criteria.class).getResultList();
				return cs;
	}
	@Override
	public void deleteCriteriaById(int criteriaId) {
		em.remove(em.find(Criteria.class, criteriaId));
	}
	@Override
	public void updateCriteria(Criteria criteria) {
		Criteria crtr = em.find(Criteria.class, criteria.getIdCriteria());
		crtr.setName(criteria.getName());
		crtr.setDescription(criteria.getDescription());
		em.persist(crtr);
	}
	
}
