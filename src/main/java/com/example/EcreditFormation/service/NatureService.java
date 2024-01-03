package com.example.EcreditFormation.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcreditFormation.exception.ResourceNotFoundException;
import com.example.EcreditFormation.models.Nature;
import com.example.EcreditFormation.repository.NatureRepository;
import com.example.EcreditFormation.serviceInterface.INatureService;

@Service
public class NatureService implements INatureService{

	
	
	@Autowired
	NatureRepository natureRepository;
	
	@Override
	public List<Nature> findAll() {
        try {
    		return  natureRepository.findAll();
		}
		 catch (Exception e) {
			 throw new RuntimeException("error getting natures", e);
		}
	}
	
	@Transactional
	@Override
	public Nature addNature(Nature nature) {
    try {
    	return natureRepository.save(nature);
		}
		 catch (Exception e) {
				throw new ResourceNotFoundException(" couldn't post thtis nature" );
		}
	}
	@Transactional
	@Override
	public Nature updateNature(Nature nature, Long natureID) {	
	    try {
	    	nature.setId(natureID);
			return natureRepository.save(nature);
			}
			 catch (Exception e) {
					throw new ResourceNotFoundException(" unite not found with id = " + natureID);
			}
	}
	@Transactional
	@Override
	public void deleteNatureById(Long natureID) {
	    try {
			natureRepository.deleteById(natureID);
			}
		catch (Exception e) {
			throw new ResourceNotFoundException(" unite not found with id = " + natureID);
			}
	}
	
	
	@Override
	   public Optional<Nature> getNatureById(Long natureID) {
	        try {
		        return natureRepository.findById(natureID);
				}
			catch (Exception e) {
				throw new ResourceNotFoundException(" nature not found with id = " + natureID);
				}
		}
	    
	

}
