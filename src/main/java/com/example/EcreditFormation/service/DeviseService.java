package com.example.EcreditFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcreditFormation.models.Devise;
import com.example.EcreditFormation.repository.DeviseRepository;
import com.example.EcreditFormation.serviceInterface.IDeviseService;

@Service
public class DeviseService implements IDeviseService{

	
	
	@Autowired
	DeviseRepository deviseRepository;
	
	@Override
	public List<Devise> findAll() {
		return  deviseRepository.findAll();
	}
	
	
	@Override
	public Devise addDevise(Devise devise) {
		
	return deviseRepository.save(devise);
	}
	
	@Override
	public Devise updateDevise(Devise devise, Long deviseID) {
		
		devise.setId(deviseID);
		return deviseRepository.save(devise);
		
	}
	
	@Override
	public void deleteDeviseById(Long deviseID) {
		deviseRepository.deleteById(deviseID);
		
	}
	
	
	@Override
	   public Optional<Devise> getDeviseById(Long deviseID) {
	        return deviseRepository.findById(deviseID);
	    }
	

	
	
	
	
}
