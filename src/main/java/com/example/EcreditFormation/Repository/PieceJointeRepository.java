package com.example.EcreditFormation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.EcreditFormation.models.PieceJointe;

public interface PieceJointeRepository extends JpaRepository<PieceJointe, Long> {

	
	// @Query("select * from PieceJointe where CreditId = id")
    List<PieceJointe> findByCreditId(Long creditId);
}
