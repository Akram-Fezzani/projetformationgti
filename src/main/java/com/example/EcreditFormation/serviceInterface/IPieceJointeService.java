package com.example.EcreditFormation.serviceInterface;

import java.util.List;
import java.util.Optional;
import com.example.EcreditFormation.models.PieceJointe;

public interface IPieceJointeService {

	
	List<PieceJointe> findAll();

	PieceJointe addPieceJointe(PieceJointe pieceJointe);
	
	PieceJointe updatePieceJointe(PieceJointe pieceJointe, Long PieceJointeID);

	void deletePieceJointeById(Long PieceJointeID);

	Optional<PieceJointe> getPieceJointeById(Long PieceJointeID);
}
