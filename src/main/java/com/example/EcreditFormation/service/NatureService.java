package com.example.EcreditFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EcreditFormation.models.Nature;
import com.example.EcreditFormation.repository.NatureRepository;
import com.example.EcreditFormation.serviceInterface.INatureService;

@Service
public class NatureService implements INatureService{

	
	
	@Autowired
	NatureRepository natureRepository;
	
	@Override
	public List<Nature> findAll() {
		return  natureRepository.findAll();
	}
	
	
	@Override
	public Nature addNature(Nature nature) {
		
	return natureRepository.save(nature);
	}
	
	@Override
	public Nature updateNature(Nature nature, Long natureID) {
		
		nature.setId(natureID);
		return natureRepository.save(nature);
		
	}
	
	@Override
	public void deleteNatureById(Long uniteID) {
		natureRepository.deleteById(uniteID);
		
	}
	
	
	@Override
	   public Optional<Nature> getNatureById(Long natureID) {
	        return natureRepository.findById(natureID);
	    }
	

}
