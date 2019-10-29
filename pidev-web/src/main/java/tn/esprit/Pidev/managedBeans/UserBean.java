package tn.esprit.Pidev.managedBeans;

import java.io.Serializable;


import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.entity.*;
import tn.esprit.entity.Role;
import tn.esprit.entity.User;
import tn.esprit.service.impl.UserService;
import tn.esprit.service.interfaces.IUserServiceLocale;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@ManagedBean
@SessionScoped

public class UserBean implements Serializable {

	private static final long serialVersionUID = -5027299396318962247L;
	
	private String firstname;
	private String lastname;
	private String password;
	private String email;
	private Boolean isActif;
	private Role role;
	private List<User> users;
	private User us;
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getIsActif() {
		return isActif;
	}
	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public User getUs() {
		return us;
	}
	public void setUs(User us) {
		this.us = us;
	}
	public IUserServiceLocale getIus() {
		return ius;
	}
	public void setIus(IUserServiceLocale ius) {
		this.ius = ius;
	}
	
	public UserService getUservice() {
		return uservice;
	}
	public void setUservice(UserService uservice) {
		this.uservice = uservice;
	}
	@EJB
	IUserServiceLocale ius = new UserService();
	@EJB
	UserService uservice ;

	
	

	public void addUser() {
		ius.addUser(new User(firstname, lastname, email, password,isActif,role));
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<User> getUsers() {
		users = ius.GetAllUser();
		return users;
		}
	public void deleteUser(int iduser) {
		uservice.DeleteUser(iduser);
	}
	
	private Integer useroyeIdToBeUpdated;
	public Integer getUseroyeIdToBeUpdated() {
		return useroyeIdToBeUpdated;
	}
	public void setUseroyeIdToBeUpdated(Integer useroyeIdToBeUpdated) {
		this.useroyeIdToBeUpdated = useroyeIdToBeUpdated;}
	
	
	public void displayuseroye(User user)
	{
	this.setLastname(user.getLastName());
	this.setFirstname(user.getName());
	this.setIsActif(user.getActiv());
	this.setEmail(user.getEmail());
	this.setRole(user.getRole());
	this.setEmail(user.getEmail());
	this.setPassword(user.getMotdepasse());
	this.setUseroyeIdToBeUpdated(user.getId());
	}
	
	public void updateUser()
	{ uservice.update2User(new User(useroyeIdToBeUpdated, firstname, lastname, email, password, isActif, role)); }


}
/*	public void updateUser()
	{ uservice.u(new User( firstname, lastname, email, password, isActif, role)); }
}*/