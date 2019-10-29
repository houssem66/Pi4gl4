package tn.esprit.service.interfaces;

import java.util.List;

import javax.ejb.Local;
import tn.esprit.entity.*;
@Local
public interface IUserServiceLocale {
	public User addUser(User u);
	public List<User> GetAllUser();
	public void UpdateUser(User u);
	public void DeleteUser(int id);
	public User getUSerByEmailAndPassword(String Email,String Password);
	public void update2User(User user);
}
