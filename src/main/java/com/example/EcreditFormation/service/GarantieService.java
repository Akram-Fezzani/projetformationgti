package com.example.EcreditFormation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcreditFormation.dtos.GetDemandeDto;
import com.example.EcreditFormation.dtos.GetGarantieDto;
import com.example.EcreditFormation.models.Credit;
import com.example.EcreditFormation.models.Devise;
import com.example.EcreditFormation.models.Garantie;
import com.example.EcreditFormation.models.Nature;
import com.example.EcreditFormation.models.TypeGarantie;
import com.example.EcreditFormation.repository.CreditRepository;
import com.example.EcreditFormation.repository.DeviseRepository;
import com.example.EcreditFormation.repository.GarantieRepository;
import com.example.EcreditFormation.repository.NatureRepository;
import com.example.EcreditFormation.repository.TypeGarantieRepository;
import com.example.EcreditFormation.serviceInterface.IGarantieService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
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
	
	
	@Override
	public Garantie addGarantie(Garantie garantie) {
		
	return garantieRepository.save(garantie);
	}
	
	@Override
	public Garantie updateGarantie(Garantie garantie, Long garantieID) {
		
		garantie.setId(garantieID);
			return garantieRepository.save(garantie);
		
	}
	
	@Override
	public void deleteGarantieById(Long garantieID) {
		garantieRepository.deleteById(garantieID);
		
	}
	
	
	
	@Override
	   public Optional<Garantie> getGarantieById(Long creditID) {
	        return garantieRepository.findById(creditID);
	    }
	
	@Override
	   public List<GetGarantieDto> getGarantieDtoById(Long creditID) {
		
			List<GetGarantieDto> garantieDtos = new ArrayList<GetGarantieDto>();
			List<Garantie>garanties=garantieRepository.findByCreditId(creditID);

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
	    }
}
