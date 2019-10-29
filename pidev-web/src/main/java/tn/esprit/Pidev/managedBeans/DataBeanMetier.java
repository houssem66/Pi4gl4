package tn.esprit.Pidev.managedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.entity.*;
@ManagedBean
@SessionScoped
public class DataBeanMetier implements Serializable{
	private static final long serialVersionUID = 1L;
	public Metier[] getMetiers() { return Metier.values();}}