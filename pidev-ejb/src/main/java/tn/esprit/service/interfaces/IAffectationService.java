package tn.esprit.mission.interfaces;

import java.util.ArrayList;

import javax.ejb.Remote;

import tn.esprit.mission.entity.Affectation;

@Remote
public interface IAffectationService {

	int addAffectation(Affectation affectation);

	ArrayList<Affectation> getAllAffectation();

	void deleteAffectationById(int affectationId);

	Affectation getAffectationById(int affectationId);

}
