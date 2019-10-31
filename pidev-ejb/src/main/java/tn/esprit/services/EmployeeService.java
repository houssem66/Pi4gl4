package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Assessment;
import entity.Assessment360;
import entity.Criteria;
import entity.Employee;
import servicesInterfaces.AssessmentServiceRemote;
import servicesInterfaces.EmployeeServiceRemote;


@Stateless
@LocalBean
public class EmployeeService implements EmployeeServiceRemote {
	@PersistenceContext(unitName="pidev-ejb")
	private EntityManager em;
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> es = em.createQuery("Select a from Employee a",
				Employee.class).getResultList();
				return es;
	}
	
	@Override
	public Employee findEmployee(int id) {
		Employee e =new Employee();
		e=em.find(Employee.class, id);
		System.out.println("find emmpl in service : "+e);
		return e;
	}

}
