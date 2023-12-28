package com.example.EcreditFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcreditFormation.models.PieceJointe;
import com.example.EcreditFormation.repository.PieceJointeRepository;
import com.example.EcreditFormation.serviceInterface.IPieceJointeService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class PieceJointeService implements IPieceJointeService {

	

	
	@Autowired
	PieceJointeRepository pieceJointeRepository;	
	
	
	@Override
	public List<PieceJointe> findAll() {
		return  pieceJointeRepository.findAll();
	}
	
	
	@Override
	public PieceJointe addPieceJointe(PieceJointe pieceJointe) {
		if(pieceJointe.isStatus()) {
			pieceJointe.setDisplay("Oui");
		}
		else			
			pieceJointe.setDisplay("Non");	 
	return pieceJointeRepository.save(pieceJointe);
	}
	
	@Override
	public PieceJointe updatePieceJointe(PieceJointe pieceJointe, Long pieceJointeID) {
		
		pieceJointe.setId(pieceJointeID);
			return pieceJointeRepository.save(pieceJointe);
		
	}
	
	@Override
	public void deletePieceJointeById(Long pieceJointeID) {
		pieceJointeRepository.deleteById(pieceJointeID);
		
	}
	
	
	
	@Override
	   public Optional<PieceJointe> getPieceJointeById(Long pieceJointeID) {
	        return pieceJointeRepository.findById(pieceJointeID);
	    }
}
