package tn.esprit.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 6191889143079517027L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	private String Name;

	private String LastName;

	private String motdepasse;
	@Enumerated(EnumType.STRING)
	// @NotNull
	private Role role;
	boolean isActiv;

	public boolean isActiv() {
		return isActiv;
	}

	public void setActiv(boolean isActiv) {
		this.isActiv = isActiv;
	}

	public boolean getActiv() {
		return isActiv;
	}

	private String Email;

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User() {
		super();
	}

	public User(String firstname, String lastname, String email, String password, boolean isActiv, Role role) {
		super();
		Name = firstname;
		LastName = lastname;
		this.Email = email;
		this.motdepasse = password;
		this.isActiv = isActiv;
		this.role = role;
	}
	public User(int id,String firstname, String lastname, String email, String password, boolean isActiv, Role role) {
		super();
		this.Id=id;
		Name = firstname;
		LastName = lastname;
		this.Email = email;
		this.motdepasse = password;
		this.isActiv = isActiv;
		this.role = role;
	}
}
