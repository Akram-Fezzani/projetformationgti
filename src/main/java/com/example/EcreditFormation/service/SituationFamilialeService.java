package com.example.EcreditFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcreditFormation.models.Client;
import com.example.EcreditFormation.models.SituationFamiliale;
import com.example.EcreditFormation.repository.ClientRepository;
import com.example.EcreditFormation.repository.SituationFamilialeRepository;
import com.example.EcreditFormation.serviceInterface.ISituationFamilialeSerivce;

@Service
public class SituationFamilialeService implements ISituationFamilialeSerivce{

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	SituationFamilialeRepository situationFamilialeRepository;
	
	//afficher la liste des SituationFamiliale
	@Override
	public List<SituationFamiliale> findAll() {
		return  situationFamilialeRepository.findAll();
	}
	
	
	//ajouter un SituationFamiliale
	@Override
	public SituationFamiliale addSituationFamiliale(SituationFamiliale situationFamiliale) {
		
	return situationFamilialeRepository.save(situationFamiliale);
	}
	
	@Override
	public SituationFamiliale updateSituationFamiliale(SituationFamiliale situationFamiliale, Long situationFamilialeID) {
		
		situationFamiliale.setId(situationFamilialeID);
		return situationFamilialeRepository.save(situationFamiliale);
		
	}
	
	//effacer un SituationFamiliale
	@Override
	public void deleteSituationFamilialeById(Long typeCreditID) {
		situationFamilialeRepository.deleteById(typeCreditID);
		
	}
	
	
	@Override
	   public Optional<SituationFamiliale> getSituationFamilialeById(Long situationFamilialeID) {
	        return situationFamilialeRepository.findById(situationFamilialeID);
	    }
	
	@Override
	public Optional<SituationFamiliale> getSituationFamilialeByCin(Long cin){
         Client client = clientRepository.findByCin(cin).orElse(null);
         return(situationFamilialeRepository.findById(client.getSituationFamiliale()));
         
    }
}
