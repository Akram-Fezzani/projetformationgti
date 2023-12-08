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
    private final ModelMapper modelMapper = new ModelMapper();
    
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	CompteRepository compteRepository;
	
	@Autowired
	GarantieRepository garantieRepository;	
	
	@Autowired
	PieceJointeRepository pieceJointeRepository;
	
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
	
	@Transactional
	@Override
	public Credit addDemandeCredit(AjoutDemandeDto ajoutDemandeDto) {
		Client client = modelMapper.map(ajoutDemandeDto.getClientDto(), Client.class);
		Credit credit = modelMapper.map(ajoutDemandeDto.getCreditDto(), Credit.class);
		Compte compte = modelMapper.map(ajoutDemandeDto.getCompteDto(), Compte.class);
		Garantie garantie = modelMapper.map(ajoutDemandeDto.getGarantieDto(), Garantie.class);
		PieceJointe pieceJointe = modelMapper.map(ajoutDemandeDto.getPieceJointeDto(),PieceJointe.class);
		
		//setting the client id in the compte
		compte.setClientId(client.getId());
		
		//setting the compte id to the credit
		credit.setCompteId(compte.getId());
		
		//setting the credit to the piece jointe 
		pieceJointe.setCreditId(credit.getId());
		
		//setting the credit to the garantie
		garantie.setCreditId(credit.getId());
		
		clientRepository.save(client);
		creditRepository.save(credit);
		compteRepository.save(compte);
		garantieRepository.save(garantie);
		pieceJointeRepository.save(pieceJointe);
	return creditRepository.save(credit);
	}
	
	@Transactional
	@Override
	public List<Client>  getDemandeCredit() {
		
		//AjoutDemandeDto demande =new AjoutDemandeDto();
	//	AjoutDemandeMapper mapper = new AjoutDemandeMapper();
		//List<AjoutDemandeDto> list = new ArrayList<AjoutDemandeDto>();
		List<Credit> credits= creditRepository.findByStatus(true);
		List<Client> comptes =new ArrayList<Client>();

		for(Credit credit : credits) {
		Compte compte = compteRepository.findById(credit.getCompteId()).orElse(null);
		Client client = clientRepository.findById(compteRepository.findById(credit.getCompteId()).orElse(null).getClientId()).orElse(null);
		//List<Garantie> garantie = garantieRepository.findByCreditId(credit.getId());
	//	List<PieceJointe> pieceJointe =pieceJointeRepository.findByCreditId(credit.getId());

		// modelMapper.map(credit, CreditDto.class);
		// modelMapper.map(compte, CompteDto.class);
		// modelMapper.map(client, ClientDto.class);
		// modelMapper.map(garantie, GarantieDto.class);
		// modelMapper.map(pieceJointe, PieceJointeDto.class);
		// CreditDto creditDto = mapper.convertCreditToDto(credit);
		// CompteDto compteDto = mapper.convertCompteToDto(compte);
		 
		 //demande.setCreditDto(creditDto);
		// demande.setCompteDto(compteDto);
		// ClientDto clientDto = mapper.convertClientToDto(client);
		 //GarantieDto garantieDto = mapper.convertGarantieToDto(garantie);
		 //PieceJointeDto pieceJointe = mapper.convertPieceJointeToDto(pieceJointe);

		/*modelMapper.map(demande.setClientDto(client));
		Credit credit = modelMapper.map(ajoutDemandeDto.getCreditDto(), Credit.class);
		Compte compte = modelMapper.map(ajoutDemandeDto.getCompteDto(), Compte.class);
		Garantie garantie = modelMapper.map(ajoutDemandeDto.getGarantieDto(), Garantie.class);
		PieceJointe pieceJointe = modelMapper.map(ajoutDemandeDto.getPieceJointeDto(),PieceJointe.class);*/
		if (compte !=null) {
		comptes.add(client);
			}
		}
		
		return comptes;
	}
	
}
