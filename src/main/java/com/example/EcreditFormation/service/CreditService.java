package com.example.EcreditFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcreditFormation.models.Credit;
import com.example.EcreditFormation.repository.CreditRepository;
import com.example.EcreditFormation.serviceInterface.ICreditService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class CreditService implements ICreditService {

	
	
	
	@Autowired
	CreditRepository creditRepository;	
	
	
	//afficher la liste des Credits
	@Override
	public List<Credit> findAll() {
		return  creditRepository.findAll();
	}
	
	
	//ajouter un Credit
	@Override
	public Credit addCredit(Credit credit) {
		
	return creditRepository.save(credit);
	}
	
	@Override
	public Credit updateCredit(Credit credit, Long creditID) {
		
		credit.setId(creditID);
			return creditRepository.save(credit);
		
	}
	
	//effacer un Credit
	@Override
	public void deleteCreditById(Long creditID) {
		creditRepository.deleteById(creditID);
		
	}
	
	
	@Override
	   public Optional<Credit> getCreditById(Long creditID) {
	        return creditRepository.findById(creditID);
	    }
}
