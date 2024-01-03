package com.example.EcreditFormation.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcreditFormation.exception.ResourceNotFoundException;
import com.example.EcreditFormation.models.Devise;
import com.example.EcreditFormation.repository.DeviseRepository;
import com.example.EcreditFormation.serviceInterface.IDeviseService;

@Service
public class DeviseService implements IDeviseService{

	
	
	@Autowired
	DeviseRepository deviseRepository;
	
	@Override
	public List<Devise> findAll() {
		 try {
			return  deviseRepository.findAll();
			}
		 catch (Exception e) {
			 throw new ResourceNotFoundException(" devises not found " );

			} 
	}
	
	@Transactional
	@Override
	public Devise addDevise(Devise devise) {
	 try {
			return deviseRepository.save(devise);
			}
		 catch (Exception e) {
			 throw new ResourceNotFoundException(" could not post this devise " );
			} 
	}
	@Transactional
	@Override
	public Devise updateDevise(Devise devise, Long deviseID) {
		 try {
				devise.setId(deviseID);
				return deviseRepository.save(devise);
			 }
		 catch (Exception e) {
			 throw new ResourceNotFoundException(" devise not found with id = " + deviseID);
			 } 
	}
	@Transactional
	@Override
	public void deleteDeviseById(Long deviseID) {
		 try {
				deviseRepository.deleteById(deviseID);
			 }
		 catch (Exception e) {
			 throw new ResourceNotFoundException(" devise not found with id = " + deviseID);
			 } 
	}
	
	
	@Override
	   public Optional<Devise> getDeviseById(Long deviseID) {
	   	 try {
		        return deviseRepository.findById(deviseID);
			 }
		 catch (Exception e) {
			 throw new ResourceNotFoundException(" devise not found with id = " + deviseID);
			 } 
	    }
	

	
	
	
	
}
