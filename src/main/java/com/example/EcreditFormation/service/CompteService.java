package com.example.EcreditFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcreditFormation.models.Compte;
import com.example.EcreditFormation.repository.CompteRepository;
import com.example.EcreditFormation.serviceInterface.ICompteService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CompteService implements ICompteService {

	
	@Autowired
	CompteRepository compteRepository;
	
	
	
	//afficher la liste des Comptes
	@Override
	public List<Compte> findAll() {
		return  compteRepository.findAll();
	}
	
	
	//ajouter un Compte
	@Override
	public Compte addCompte(Compte compte) {
		
	return compteRepository.save(compte);
	}
	
	@Override
	public Compte updateCompte(Compte compte, Long compteID) {
		
		compte.setId(compteID);
			return compteRepository.save(compte);
		
	}
	
	//effacer un Compte
	@Override
	public void deleteCompteById(Long compteID) {
		compteRepository.deleteById(compteID);
		
	}
	
	
	@Override
	   public Optional<Compte> getCompteById(Long compteID) {
	        return compteRepository.findById(compteID);
	    }
	

}
