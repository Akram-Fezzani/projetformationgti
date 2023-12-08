package com.example.EcreditFormation.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.example.EcreditFormation.models.Garantie;

public interface IGarantieService {

	
	List<Garantie> findAll();

	Garantie addGarantie(Garantie garantie);
	
	Garantie updateGarantie(Garantie garantie, Long GarantieID);

	void deleteGarantieById(Long GarantieID);

	Optional<Garantie> getGarantieById(Long GarantieID);
}
