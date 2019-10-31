package servicesInterfaces;

import java.util.List;

import javax.ejb.Remote;

import entity.Criteria;

@Remote
public interface CriteriaServiceRemote {

	public void ajouterCriteria(Criteria c);

	public void deleteCriteriaById(int criteriaId);

	public void updateCriteria(Criteria criteria);

	public List<Criteria> getAllCriterias();

}
