package tn.esprit.Pidev.managedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.entity.*;
@ManagedBean
@SessionScoped
public class DataBean implements Serializable{
	private static final long serialVersionUID = 1L;
	public Role[] getRoles() { return Role.values();}
	public Category[] getCategory() { return Category.values();}
	public Type[] getType() { return Type.values();}

}
