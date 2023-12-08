package com.example.EcreditFormation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.EcreditFormation.models.Garantie;

@Repository
public interface GarantieRepository extends JpaRepository<Garantie, Long>{

	
	// @Query("select * from Garantie where creditId = id")
	    //List<Garantie> findAllGarantieParCreditId(Long id);
    List<Garantie> findByCreditId(Long creditId);

}
