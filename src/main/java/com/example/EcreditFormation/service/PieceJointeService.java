package com.example.EcreditFormation.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcreditFormation.exception.ResourceNotFoundException;
import com.example.EcreditFormation.models.PieceJointe;
import com.example.EcreditFormation.repository.PieceJointeRepository;
import com.example.EcreditFormation.serviceInterface.IPieceJointeService;



@Service
public class PieceJointeService implements IPieceJointeService {

	

	
	@Autowired
	PieceJointeRepository pieceJointeRepository;	
	
	
	@Override
	public List<PieceJointe> findAll() {
	      try {
	  		return  pieceJointeRepository.findAll();
			}
		 catch (Exception e) {
			throw new RuntimeException("error getting piece jointes", e);
			}
	}
	
	@Transactional
	@Override
	public PieceJointe addPieceJointe(PieceJointe pieceJointe) {
    try {
		if(pieceJointe.isStatus()) {
			pieceJointe.setDisplay("Oui");
		}
		else 		
			pieceJointe.setDisplay("Non");	 
			return pieceJointeRepository.save(pieceJointe);			
		
    }
	catch (Exception e) {
		throw new ResourceNotFoundException(" couldn't post this piece Jointe " );
			}
	}
	
	@Transactional
	@Override
	public PieceJointe updatePieceJointe(PieceJointe pieceJointe, Long pieceJointeID) {
		    try {
			    	pieceJointe.setId(pieceJointeID);
					return pieceJointeRepository.save(pieceJointe);
				}
			catch (Exception e) {
				throw new ResourceNotFoundException(" piece Jointe not found with id = " + pieceJointeID);
				}
	}
	
	@Transactional
	@Override
	public void deletePieceJointeById(Long pieceJointeID) {
			pieceJointeRepository.deleteById(pieceJointeID);
		
	 
	}
	
	
	
	@Override
	   public Optional<PieceJointe> getPieceJointeById(Long pieceJointeID) {
	        try {
		        return pieceJointeRepository.findById(pieceJointeID);
			}
		    catch (Exception e) {
				throw new ResourceNotFoundException(" piece Jointe not found with id = " + pieceJointeID);
			}
	    }
}
