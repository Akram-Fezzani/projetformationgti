package com.example.EcreditFormation.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.example.EcreditFormation.models.Credit;


public interface ICreditService {

	
	List<Credit> findAll();

	Credit addCredit(Credit credit);
	
	Credit updateCredit(Credit credit, Long CreditID);

	void deleteCreditById(Long CreditID);

	
	Optional<Credit> getCreditById(Long CreditID);
}
