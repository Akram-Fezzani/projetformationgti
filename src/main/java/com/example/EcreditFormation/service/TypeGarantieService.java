package com.example.EcreditFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcreditFormation.models.TypeGarantie;
import com.example.EcreditFormation.repository.TypeGarantieRepository;
import com.example.EcreditFormation.serviceInterface.ITypeGarantieService;

@Service
public class TypeGarantieService implements ITypeGarantieService {

	
	
	@Autowired
	TypeGarantieRepository typeGarantieRepository;
	
	@Override
	public List<TypeGarantie> findAll() {
		return  typeGarantieRepository.findAll();
	}
	
	
	@Override
	public TypeGarantie addTypeGarantie(TypeGarantie typeGarantie) {
		
	return typeGarantieRepository.save(typeGarantie);
	}
	
	@Override
	public TypeGarantie updateTypeGarantie(TypeGarantie typeGarantie, Long typeGarantieID) {
		
		typeGarantie.setId(typeGarantieID);
		return typeGarantieRepository.save(typeGarantie);
		
	}
	
	@Override
	public void deleteTypeGarantieById(Long typeGarantieID) {
		typeGarantieRepository.deleteById(typeGarantieID);
		
	}
	
	
	@Override
	   public Optional<TypeGarantie> getTypeGarantieById(Long typeGarantieID) {
	        return typeGarantieRepository.findById(typeGarantieID);
	    }
	

}
