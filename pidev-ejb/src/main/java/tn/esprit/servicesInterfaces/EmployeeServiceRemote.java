package servicesInterfaces;

import java.util.List;

import javax.ejb.Remote;

import entity.Employee;

@Remote
public interface EmployeeServiceRemote {

	public List<Employee> getAllEmployees();

	public Employee findEmployee(int id);

}
