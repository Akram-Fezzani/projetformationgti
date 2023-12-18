package com.example.EcreditFormation.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.example.EcreditFormation.models.Unite;

public interface IUniteService {

	
	Optional<Unite> getUniteById(Long UniteID) ;
	
	void deleteUniteById(Long UniteID) ;
	
	Unite updateUnite(Unite unite, Long UniteID);
	
	Unite addUnite(Unite unite) ;
	
	List<Unite> findAll();
}
