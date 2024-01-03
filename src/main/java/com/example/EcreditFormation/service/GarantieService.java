package com.example.EcreditFormation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcreditFormation.dtos.GetGarantieDto;
import com.example.EcreditFormation.exception.ResourceNotFoundException;
import com.example.EcreditFormation.models.Devise;
import com.example.EcreditFormation.models.Garantie;
import com.example.EcreditFormation.models.Nature;
import com.example.EcreditFormation.models.TypeGarantie;
import com.example.EcreditFormation.repository.DeviseRepository;
import com.example.EcreditFormation.repository.GarantieRepository;
import com.example.EcreditFormation.repository.NatureRepository;
import com.example.EcreditFormation.repository.TypeGarantieRepository;
import com.example.EcreditFormation.serviceInterface.IGarantieService;


@Service
public class GarantieService  implements IGarantieService{

	

	
	@Autowired
	GarantieRepository garantieRepository;	
	
	@Autowired
	DeviseRepository deviseRepository;
	@Autowired
	TypeGarantieRepository typeGarantieRepository;
	
	@Autowired
	NatureRepository natureRepository;
	
	
	@Override
	public List<Garantie> findAll() {
		return  garantieRepository.findAll();
	}
	
	@Transactional
	@Override
	public Garantie addGarantie(Garantie garantie) {
		 try {
			 return garantieRepository.save(garantie);
			 }
		 catch (Exception e) {
			 throw new ResourceNotFoundException(" could not post this garantie " );
			 } 
	}
	@Transactional
	@Override
	public Garantie updateGarantie(Garantie garantie, Long garantieID) {
			 try {
				 garantie.setId(garantieID);
				return garantieRepository.save(garantie);				
				 }
			 catch (Exception e) {
				 throw new ResourceNotFoundException(" garantie not found with id = " + garantieID);
				 } 
	}
	@Transactional
	@Override
	public void deleteGarantieById(Long garantieID) {
		 try {
			garantieRepository.deleteById(garantieID);
			 }
		 catch (Exception e) {
			 throw new ResourceNotFoundException(" garantie not found with id = " + garantieID);
			 }
	}
	
	
	
	@Override
	   public Optional<Garantie> getGarantieById(Long garantieID) {
	        try {
		        return garantieRepository.findById(garantieID);
			}
			 catch (Exception e) {
					throw new ResourceNotFoundException(" garantie not found with id = " + garantieID);
			}
	    }
	
	@Override
	   public List<GetGarantieDto> getGarantieDtoById(Long garantieID) {
		
			List<GetGarantieDto> garantieDtos = new ArrayList<GetGarantieDto>();
			try {
					List<Garantie>garanties=garantieRepository.findByCreditId(garantieID);
		
					for(Garantie garantie : garanties) {
						GetGarantieDto garantieDto =new GetGarantieDto();
						
						garantieDto.setIdGarantie(garantie.getId());
						
				        Devise devise=deviseRepository.findById(garantie.getDevise()).orElse(null);
				        garantieDto.setDeviseGarantie(devise.getDevise());
				        
				        TypeGarantie type=typeGarantieRepository.findById(garantie.getType()).orElse(null);
				        garantieDto.setTypeGarantie(type.getTypeGarantie());
				        
				        Nature nature=natureRepository.findById(garantie.getNature()).orElse(null);
				        garantieDto.setNature(nature.getNature());
				        
				        garantieDto.setValeur(garantie.getValeur());
				        
				        garantieDtos.add(garantieDto);
					}
			        return garantieDtos;
			} catch (Exception e) {
						throw new ResourceNotFoundException(" garantie not found with id = " + garantieID);
				 
			}
	    }
}
