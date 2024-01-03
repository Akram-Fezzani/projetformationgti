package com.example.EcreditFormation.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcreditFormation.models.TypeCredit;
import com.example.EcreditFormation.repository.TypeCreditRepository;
import com.example.EcreditFormation.serviceInterface.ITypeCreditService;

@Service

public class TypeCreditService implements ITypeCreditService {

	
	
	@Autowired
	TypeCreditRepository typeCreditRepository;
	
	@Override
	public List<TypeCredit> findAll() {
	    try {
			return  typeCreditRepository.findAll();
			}
	    catch (Exception e) {
			throw new RuntimeException("error getting types credits", e);
			}
	}
	
	
	@Transactional
	@Override
	public TypeCredit addTypeCredit(TypeCredit typeCredit) {
	    try {
	    	return typeCreditRepository.save(typeCredit);
			}
	    catch (Exception e) {
			throw new RuntimeException("error getting types credits", e);
			}
	}
	
	@Transactional
	@Override
	public TypeCredit updateTypeCredit(TypeCredit typeCredit, Long typeCreditID) {
	    try {
	    	typeCredit.setId(typeCreditID);
			return typeCreditRepository.save(typeCredit);			}
	    catch (Exception e) {
			throw new RuntimeException("error updating this type credit", e);
			}
	}
	
	@Transactional
	@Override
	public void deleteTypeCreditById(Long typeCreditID) {
	    try {
			typeCreditRepository.deleteById(typeCreditID);
			}
	    catch (Exception e) {
			throw new RuntimeException("error deleting this type credit", e);
			}
	}
	
	
	@Override
	   public Optional<TypeCredit> getTypeCreditById(Long typeCreditID) {
	        try {
		        return typeCreditRepository.findById(typeCreditID);
				}
		    catch (Exception e) {
				throw new RuntimeException("error geting type credit by id ", e);
				}
	    }
	

	
	
	
	
}
