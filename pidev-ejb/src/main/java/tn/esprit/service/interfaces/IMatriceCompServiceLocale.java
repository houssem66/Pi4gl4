package tn.esprit.service.interfaces;
import java.util.List;

import tn.esprit.entity.*;

public interface IMatriceCompServiceLocale {

	public void addMatriceComp(MatriceComp matriceComp);
	public MatriceComp getMatriceCompById(int id);
	public void removeMatriceComp(int id);
	public void updateMatriceComp(MatriceComp matriceComp);
	public List<MatriceComp> getAllMatriceComps();
	public void affecterCompetanceAmatrice(int competanceid, int matriceid/*,int niveaux*/);
	public MatriceComp getMatriceCompByCategory(Category category);
	public List<Competance> getAllCompetances(int id ) ;
}
