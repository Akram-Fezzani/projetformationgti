package com.example.EcreditFormation.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcreditFormation.exception.ResourceNotFoundException;
import com.example.EcreditFormation.models.Unite;
import com.example.EcreditFormation.repository.UniteRepository;
import com.example.EcreditFormation.serviceInterface.IUniteService;

@Service
public class UniteService  implements IUniteService{

	
	
	@Autowired
	UniteRepository uniteRepository;
	
	@Override
	public List<Unite> findAll() {
        try {
		return  uniteRepository.findAll();
        }
		 catch (Exception e) {
	         throw new RuntimeException("Error getting Unites", e);
	        }
	    }
	
	@Transactional
	@Override
	public Unite addUnite(Unite unite) {
    try {
    	return uniteRepository.save(unite);
     }
		 catch (Exception e) {
	         throw new RuntimeException("Error Posting Unite", e);
	        }
	 }
	
    @Transactional
    @Override
    public Unite updateUnite(Unite unite, Long uniteID) {
        try {
            unite.setId(uniteID);
            return uniteRepository.save(unite);
        } catch (Exception e) {
	        throw new ResourceNotFoundException("Could not delete unite with id = " + uniteID);
        }
    }
    
	@Transactional
	@Override
	public void deleteUniteById(Long uniteID) {
	    try {
			uniteRepository.deleteById(uniteID);
	    } catch (Exception e) {
            //throw new RuntimeException("no Unite with this id is found", e);
	        throw new ResourceNotFoundException("Could not delete unite with id = " + uniteID);

	    }
	}
	
	
	@Transactional
	public Optional<Unite> getUniteById(Long uniteID) {
	    try {
	        return uniteRepository.findById(uniteID);
	    } catch (Exception e) {
	        throw new RuntimeException("no Unite with this id is found", e);
	    }
	}
}
