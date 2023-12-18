package com.example.EcreditFormation.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.example.EcreditFormation.models.Nature;

public interface INatureService {

	Optional<Nature> getNatureById(Long natureID) ;
	
	void deleteNatureById(Long natureID) ;
	
	Nature updateNature(Nature unite, Long natureID);
	
	Nature addNature(Nature unite) ;
	
	List<Nature> findAll();
}
