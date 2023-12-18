package com.example.EcreditFormation.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.example.EcreditFormation.models.TypeCredit;

public interface ITypeCreditService {

	Optional<TypeCredit> getTypeCreditById(Long typeCreditID) ;
	
	void deleteTypeCreditById(Long typeCreditID) ;
	
	TypeCredit updateTypeCredit(TypeCredit typeCredit, Long typeCreditID);
	
	TypeCredit addTypeCredit(TypeCredit typeCredit) ;
	
	List<TypeCredit> findAll();
}
