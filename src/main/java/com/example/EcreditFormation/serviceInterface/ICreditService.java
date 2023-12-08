package com.example.EcreditFormation.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.example.EcreditFormation.dtos.AjoutDemandeDto;
import com.example.EcreditFormation.models.Client;
import com.example.EcreditFormation.models.Credit;


public interface ICreditService {

	
	List<Credit> findAll();

	Credit addCredit(Credit credit);
	
	Credit updateCredit(Credit credit, Long CreditID);

	void deleteCreditById(Long CreditID);
	
	Credit addDemandeCredit(AjoutDemandeDto ajoutDemandeDto);
	
	Optional<Credit> getCreditById(Long CreditID);
	
	List<Client>  getDemandeCredit();
}
