package com.example.EcreditFormation.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.example.EcreditFormation.models.Compte;

public interface ICompteService {

	
	List<Compte> findAll();

	Compte addCompte(Compte compte);
	
	Compte updateCompte(Compte Compte, Long CompteID);

	void deleteCompteById(Long CompteID);

	
	Optional<Compte> getCompteById(Long CompteID);
}
