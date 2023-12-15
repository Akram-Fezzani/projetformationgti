package com.example.EcreditFormation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcreditFormation.dtos.AjoutDemandeDto;
import com.example.EcreditFormation.dtos.ClientDto;
import com.example.EcreditFormation.dtos.CompteDto;
import com.example.EcreditFormation.dtos.CreditDto;
import com.example.EcreditFormation.dtos.GarantieDto;
import com.example.EcreditFormation.dtos.GetDemandeDto;
import com.example.EcreditFormation.dtos.PieceJointeDto;
import com.example.EcreditFormation.modelMapper.AjoutDemandeMapper;
import com.example.EcreditFormation.models.Client;
import com.example.EcreditFormation.models.Compte;
import com.example.EcreditFormation.models.Credit;
import com.example.EcreditFormation.models.Garantie;
import com.example.EcreditFormation.models.PieceJointe;
import com.example.EcreditFormation.repository.ClientRepository;
import com.example.EcreditFormation.repository.CompteRepository;
import com.example.EcreditFormation.repository.CreditRepository;
import com.example.EcreditFormation.repository.GarantieRepository;
import com.example.EcreditFormation.repository.PieceJointeRepository;
import com.example.EcreditFormation.serviceInterface.ICreditService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class CreditService implements ICreditService {

	
	@Autowired
	CreditRepository creditRepository;
	
	//afficher la liste des Credits
	@Override
	public List<Credit> findAll() {
		return  creditRepository.findAll();
	}
	
	
	//ajouter un Credit
	@Override
	public Credit addCredit(Credit credit) {
		
	return creditRepository.save(credit);
	}
	
	@Override
	public Credit updateCredit(Credit credit, Long creditID) {
		
		credit.setId(creditID);
		return creditRepository.save(credit);
		
	}
	
	//effacer un Credit
	@Override
	public void deleteCreditById(Long creditID) {
		creditRepository.deleteById(creditID);
		
	}
	
	
	@Override
	   public Optional<Credit> getCreditById(Long creditID) {
	        return creditRepository.findById(creditID);
	    }
	

	
	
	
	
	
}
	

