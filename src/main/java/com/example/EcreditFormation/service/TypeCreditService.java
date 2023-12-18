package com.example.EcreditFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcreditFormation.models.TypeCredit;
import com.example.EcreditFormation.repository.TypeCreditRepository;
import com.example.EcreditFormation.serviceInterface.ITypeCreditService;

@Service

public class TypeCreditService implements ITypeCreditService {

	
	
	@Autowired
	TypeCreditRepository typeCreditRepository;
	
	//afficher la liste des TypeCredits
	@Override
	public List<TypeCredit> findAll() {
		return  typeCreditRepository.findAll();
	}
	
	
	//ajouter un TypeCredit
	@Override
	public TypeCredit addTypeCredit(TypeCredit typeCredit) {
		
	return typeCreditRepository.save(typeCredit);
	}
	
	@Override
	public TypeCredit updateTypeCredit(TypeCredit typeCredit, Long typeCreditID) {
		
		typeCredit.setId(typeCreditID);
		return typeCreditRepository.save(typeCredit);
		
	}
	
	//effacer un TypeCredit
	@Override
	public void deleteTypeCreditById(Long typeCreditID) {
		typeCreditRepository.deleteById(typeCreditID);
		
	}
	
	
	@Override
	   public Optional<TypeCredit> getTypeCreditById(Long typeCreditID) {
	        return typeCreditRepository.findById(typeCreditID);
	    }
	

	
	
	
	
}
