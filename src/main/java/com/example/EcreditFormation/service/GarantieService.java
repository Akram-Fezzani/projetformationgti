package com.example.EcreditFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcreditFormation.models.Credit;
import com.example.EcreditFormation.models.Garantie;
import com.example.EcreditFormation.repository.CreditRepository;
import com.example.EcreditFormation.repository.GarantieRepository;
import com.example.EcreditFormation.serviceInterface.IGarantieService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GarantieService  implements IGarantieService{

	

	
	@Autowired
	GarantieRepository garantieRepository;	
	
	
	//afficher la liste des Garantie
	@Override
	public List<Garantie> findAll() {
		return  garantieRepository.findAll();
	}
	
	
	//ajouter un Garantie
	@Override
	public Garantie addGarantie(Garantie garantie) {
		
	return garantieRepository.save(garantie);
	}
	
	@Override
	public Garantie updateGarantie(Garantie garantie, Long garantieID) {
		
		garantie.setId(garantieID);
			return garantieRepository.save(garantie);
		
	}
	
	//effacer un Garantie
	@Override
	public void deleteGarantieById(Long garantieID) {
		garantieRepository.deleteById(garantieID);
		
	}
	
	
	
	@Override
	   public Optional<Garantie> getGarantieById(Long creditID) {
	        return garantieRepository.findById(creditID);
	    }
}
