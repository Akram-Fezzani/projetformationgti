package com.example.EcreditFormation.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcreditFormation.exception.ResourceNotFoundException;
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
	
	@Override
	public List<SituationFamiliale> findAll() {
	    try {
			return  situationFamilialeRepository.findAll();
			}
	    catch (Exception e) {
			throw new ResourceNotFoundException(" piece Jointe not found with id = " );
			}
	}
	
	
	@Transactional
	@Override
	public SituationFamiliale addSituationFamiliale(SituationFamiliale situationFamiliale) {
    try {
    	return situationFamilialeRepository.save(situationFamiliale);
		}
    catch (Exception e) {
		throw new RuntimeException("error posting this Situation Familiale", e);
		}
	}
	
	@Transactional
	@Override
	public SituationFamiliale updateSituationFamiliale(SituationFamiliale situationFamiliale, Long situationFamilialeID) {
        try {
        	situationFamiliale.setId(situationFamilialeID);
    		return situationFamilialeRepository.save(situationFamiliale);
    		}
	    catch (Exception e) {
			throw new RuntimeException("error updating Situation Familiale", e);
			}
	}
	
	@Transactional
	@Override
	public void deleteSituationFamilialeById(Long typeCreditID) {
        try {
    		situationFamilialeRepository.deleteById(typeCreditID);
            }
	    catch (Exception e) {
			throw new RuntimeException("error deleting Situation Familiale with this id", e);
			}
	}
	
	
	@Override
	   public Optional<SituationFamiliale> getSituationFamilialeById(Long situationFamilialeID) {
	        try {
		        return situationFamilialeRepository.findById(situationFamilialeID);
	            }
		    catch (Exception e) {
				throw new RuntimeException("error getting Situation Familiale with this id", e);
				}
	    }
	
	@Override
	public Optional<SituationFamiliale> getSituationFamilialeByCin(Long cin){
        try {
            Client client = clientRepository.findByCin(cin).orElse(null);
            return(situationFamilialeRepository.findById(client.getSituationFamiliale()));
            		}
	    catch (Exception e) {
			throw new RuntimeException("error getting Situation Familiale with this cin", e);
		}
   
    }
}
