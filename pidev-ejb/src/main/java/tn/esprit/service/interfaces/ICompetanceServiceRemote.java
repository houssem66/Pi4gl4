package tn.esprit.service.interfaces;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import tn.esprit.entity.*;
@Remote
public interface ICompetanceServiceRemote {

	public int addCompetance(Competance competance);
	public Competance getCompetanceById(int id);
	public void removeCompetance(int id);
	public void updateCompetance(Competance competance);
	public List<Competance> getAllCompetances();
	public List<Competance>getAllCompetancesByName(String Name);
	public int addlol(lol Lol);
}
