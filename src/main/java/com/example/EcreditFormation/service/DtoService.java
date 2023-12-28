package com.example.EcreditFormation.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcreditFormation.dtos.AjoutDemandeDto;
import com.example.EcreditFormation.dtos.ClientDto;
import com.example.EcreditFormation.dtos.CompteDto;
import com.example.EcreditFormation.dtos.CreditDto;
import com.example.EcreditFormation.dtos.GetDemandeDto;
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
import com.example.EcreditFormation.serviceInterface.IDtoService;

@Service
public class DtoService implements IDtoService{


	@Autowired
	CreditRepository creditRepository;	
	
	@Autowired
     ModelMapper modelMapper = new ModelMapper();
    
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	CompteRepository compteRepository;
	
	@Autowired
	GarantieRepository garantieRepository;	
	
	@Autowired
	PieceJointeRepository pieceJointeRepository;
	
	
	@Transactional
	@Override
	public Credit addDemandeCredit(AjoutDemandeDto ajoutDemandeDto) {
		Client client = modelMapper.map(ajoutDemandeDto.getClientDto(), Client.class);
		Credit credit = modelMapper.map(ajoutDemandeDto.getCreditDto(), Credit.class);
		Compte compte = modelMapper.map(ajoutDemandeDto.getCompteDto(), Compte.class);
		compte.setClientId(client.getId());
		credit.setCompteId(compte.getId());
		creditRepository.save(credit);
	return creditRepository.save(credit);
	}
	
	@Override
	public List<GetDemandeDto>  getDemandeCredit() {
		
		List<GetDemandeDto> list = new ArrayList<GetDemandeDto>();
		
		List<Credit> credits= creditRepository.findAll();
		if (credits != null) {
		for(Credit credit : credits) {
			GetDemandeDto demande =new GetDemandeDto();

			CreditDto creditDto = modelMapper.map(credit, CreditDto.class );
			demande.setCreditDto(creditDto);
			if (credit != null) {

			Compte compte = compteRepository.findById(credit.getCompteId()).orElse(null);
			CompteDto compteDto = modelMapper.map(compte, CompteDto.class );
			demande.setCompteDto(compteDto);
			
			if (compte != null) {

			Client client = clientRepository.findById(compte.getClientId()).orElse(null);
			ClientDto clientDto = modelMapper.map(client, ClientDto.class );
			demande.setClientDto(clientDto);
			list.add(demande);
			}
			}
		}
		}
		return list;
	}
	
	
	@Transactional
	@Override
	public Credit updateDemandeCredit(AjoutDemandeDto ajoutDemandeDto,Long creditId) {
		Client client = modelMapper.map(ajoutDemandeDto.getClientDto(), Client.class);
		Credit credit = modelMapper.map(ajoutDemandeDto.getCreditDto(), Credit.class);
		credit.setCompteId(creditId);
		Compte compte = modelMapper.map(ajoutDemandeDto.getCompteDto(), Compte.class);
		compte.setClientId(client.getId());
		
		credit.setCompteId(compte.getId());
		clientRepository.save(client);
		creditRepository.save(credit);
		compteRepository.save(compte);
	return creditRepository.save(credit);
	}
	
	
	
	@Transactional
	@Override
	public GetDemandeDto getDemandeCreditByCreditId(Long creditId) {
		
		GetDemandeDto demande =new GetDemandeDto();
		
			Credit credit= creditRepository.findById(creditId).orElse(null);
			CreditDto creditDto = modelMapper.map(credit, CreditDto.class );
			demande.setCreditDto(creditDto);
			
			Compte compte = compteRepository.findById(credit.getCompteId()).orElse(null);
			CompteDto compteDto = modelMapper.map(compte, CompteDto.class );
			demande.setCompteDto(compteDto);
			
			Client client = clientRepository.findById(compte.getClientId()).orElse(null);
			ClientDto clientDto = modelMapper.map(client, ClientDto.class );
			demande.setClientDto(clientDto);
		
		return demande;
		
	}
	
	
}
