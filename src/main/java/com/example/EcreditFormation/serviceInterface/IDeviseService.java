package com.example.EcreditFormation.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.example.EcreditFormation.models.Devise;

public interface IDeviseService {

	
	Optional<Devise> getDeviseById(Long deviseID) ;
	
	void deleteDeviseById(Long deviseID) ;
	
	Devise updateDevise(Devise devise, Long deviseID);
	
	Devise addDevise(Devise devise) ;
	
	List<Devise> findAll();
}
