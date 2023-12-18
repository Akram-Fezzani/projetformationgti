package com.example.EcreditFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcreditFormation.models.Unite;
import com.example.EcreditFormation.repository.UniteRepository;
import com.example.EcreditFormation.serviceInterface.IUniteService;

@Service
public class UniteService  implements IUniteService{

	
	
	@Autowired
	UniteRepository uniteRepository;
	
	//afficher la liste des TypeCredits
	@Override
	public List<Unite> findAll() {
		return  uniteRepository.findAll();
	}
	
	
	//ajouter un TypeCredit
	@Override
	public Unite addUnite(Unite unite) {
		
	return uniteRepository.save(unite);
	}
	
	@Override
	public Unite updateUnite(Unite unite, Long uniteID) {
		
		unite.setId(uniteID);
		return uniteRepository.save(unite);
		
	}
	
	//effacer un TypeCredit
	@Override
	public void deleteUniteById(Long uniteID) {
		uniteRepository.deleteById(uniteID);
		
	}
	
	
	@Override
	   public Optional<Unite> getUniteById(Long uniteID) {
	        return uniteRepository.findById(uniteID);
	    }
	

}
