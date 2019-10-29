package tn.esprit.Pidev.managedBeans;

import java.io.Serializable;


import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.entity.Role;
import tn.esprit.entity.User;
import tn.esprit.service.impl.UserService;
import tn.esprit.service.interfaces.IUserServiceLocale;



@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String login;
	private String password;
	private User user;
	@SuppressWarnings("unused")
	private Boolean loggedIn;
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	

	@EJB
	IUserServiceLocale userservice=new UserService();
        
public String doLogin() {
String navigateTo= "null";
user= userservice.getUSerByEmailAndPassword(login, password);
if(user!= null&& user.getRole() == Role.ADMINISTRATEUR) {
navigateTo= "/pages/admin/welcome?faces-redirect=true"; loggedIn= true; }
else{
FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));}
return navigateTo; }

public String doLogout() {
FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
return"/login?faces-redirect=true"; }}