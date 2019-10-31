package entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEmployee ;
	
	private String firstName;
	private String lastName;
	public Employee(int idEmployee, String firstName, String lastName) {
		super();
		this.idEmployee = idEmployee;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Employee(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [idEmployee=" + idEmployee + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	public int getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
