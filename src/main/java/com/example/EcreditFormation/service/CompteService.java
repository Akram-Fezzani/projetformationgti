package com.example.EcreditFormation.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcreditFormation.exception.ResourceNotFoundException;
import com.example.EcreditFormation.models.Compte;
import com.example.EcreditFormation.repository.CompteRepository;
import com.example.EcreditFormation.serviceInterface.ICompteService;

@Service
public class CompteService implements ICompteService {

	
	@Autowired
	CompteRepository compteRepository;
	
	
	
	@Override
	public List<Compte> findAll() {
		 try {
			return compteRepository.findAll();
			}
		 catch (Exception e) {
			 throw new ResourceNotFoundException(" Compte not found " );
			} 
	}
	
	@Transactional
	@Override
	public Compte addCompte(Compte compte) {	
	 try {
			return compteRepository.save(compte);
		}
	 catch (Exception e) {
		 throw new ResourceNotFoundException(" error posting this compte" );

		} 
	}
	
	@Transactional
	@Override
	public Compte updateCompte(Compte compte, Long compteID) {
			 try {
				compte.setId(compteID);
				return compteRepository.save(compte);				
				}
			 catch (Exception e) {
				 throw new ResourceNotFoundException(" Compte not found with id = " + compteID);
				} 
		
	}
	
	@Transactional
	@Override
	public void deleteCompteById(Long compteID) {
		
		 try {
				compteRepository.deleteById(compteID);
			}
		 catch (Exception e) {
			 throw new ResourceNotFoundException(" Compte not found with id = " + compteID);
			} 
		
	}
	
	
	@Override
	   public Optional<Compte> getCompteById(Long compteID) {
	        
	   	 try {
		     return compteRepository.findById(compteID);
			}
		 catch (Exception e) {
			 throw new ResourceNotFoundException(" Compte not found with id = " + compteID);

			} 
	    }
	

}
