package tn.esprit.service.interfaces;
import java.util.List;

import tn.esprit.entity.*;

public interface ICompetanceServiceLocale {

	public void addCompetance(Competance competance);
	public Competance getCompetanceById(int id);
	public void removeCompetance(int id);
	public void updateCompetance(Competance competance);
	public List<Competance> getAllCompetances();
}
