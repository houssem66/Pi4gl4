package tn.esprit.service.interfaces;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entity.*;
@Remote
public interface IMatriceCompServiceRemote {

	public int addMatriceComp(MatriceComp matriceComp);
	public MatriceComp getMatriceCompById(int id);
	public void removeMatriceComp(int id);
	public void updateMatriceComp(MatriceComp matriceComp);
	public List<MatriceComp> getAllMatriceComps();
	
}
