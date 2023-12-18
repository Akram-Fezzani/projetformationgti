package com.example.EcreditFormation.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.example.EcreditFormation.models.TypeGarantie;

public interface ITypeGarantieService {

	Optional<TypeGarantie> getTypeGarantieById(Long typeGarantieID) ;
	
	void deleteTypeGarantieById(Long typeGarantieID) ;
	
	TypeGarantie updateTypeGarantie(TypeGarantie typeGarantie, Long typeGarantieID);
	
	TypeGarantie addTypeGarantie(TypeGarantie typeGarantie) ;
	
	List<TypeGarantie> findAll();
}
