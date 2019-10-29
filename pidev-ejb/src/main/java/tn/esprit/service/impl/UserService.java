package tn.esprit.service.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import tn.esprit.entity.*;
import tn.esprit.service.interfaces.IUserServiceLocale;

@Stateless
@LocalBean
public class UserService implements IUserServiceLocale {
	
	@PersistenceContext(unitName="pidev-ejb")
	EntityManager em;
	User us = new User();
	@Override
	public User addUser(User u) {
		 em.persist(u);
		 return u;
	}

	@Override
	public List<User> GetAllUser() {
		return em.createQuery("SELECT u from User u ", User.class).getResultList();
	}

	@Override
	public void UpdateUser(User u) {
		User up = new User(null, null, null, null, false, null);
		if(up.getId()==u.getId()) {
			up.setLastName(u.getLastName());
			up.setLastName(u.getLastName());
			up.setEmail(u.getEmail());
			up.setRole(u.getRole());
			
			System.out.println("Updated !!"+up);
		}
		System.out.println("No");
	}

	@Override
	public void DeleteUser(int id) {
		
		em.remove(em.find(User.class, id));
		System.out.println("Deleted!!!");

	}

	@Override
	public User getUSerByEmailAndPassword(String email, String password) {
		
		TypedQuery<User> query =
				em.createQuery("SELECT u FROM User u where u.Email=:email AND u.motdepasse=:password",User.class);
				query.setParameter("email", email);
				query.setParameter("password", password);
				User us = null;
				try { us = query.getSingleResult(); }
				catch (Exception e) { System.out.println("Erreur : " + e); }
				return us;
	}
	public void displayUseroye(User User)
	{ User e = new User();
	e.setLastName(User.getLastName());
	e.setName(User.getName());
	e.setActiv(User.getActiv());
	e.setEmail(User.getEmail());
	e.setRole(User.getRole());
	
	e.setMotdepasse(User.getMotdepasse());
	e.setId(User.getId());
	}
/*public int updateusr(User e,int i) {
		
		return em.createQuery("update user u set u.Id='"+e.getId()+"' , "
				+ "u.Name ='"+e.getName()+"', u.LastName='"+e.getLastName()+"' , u.motdepasse='"+e.getMotdepasse()+"' where u.Id="+ i).executeUpdate();

*/


@Override
public void update2User(User user) {
User us= em.find(User.class,user.getId());
System.out.println("Updated !!"+user.getId());
us.setLastName(user.getLastName());
us.setName(user.getName());
us.setEmail(user.getEmail()); 
us.setMotdepasse(user.getMotdepasse());
us.setActiv(user.getActiv()); 
us.setRole(user.getRole());
}
}