package com.example.EcreditFormation.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.example.EcreditFormation.models.SituationFamiliale;

public interface ISituationFamilialeSerivce {

	List<SituationFamiliale> findAll();

	SituationFamiliale addSituationFamiliale(SituationFamiliale situationFamiliale);
	
	SituationFamiliale updateSituationFamiliale(SituationFamiliale situationFamiliale, Long situationFamilialeID);

	void deleteSituationFamilialeById(Long situationFamilialeID);

	Optional<SituationFamiliale> getSituationFamilialeById(Long situationFamilialeID);
	
	Optional<SituationFamiliale> getSituationFamilialeByCin(Long cin);
}
