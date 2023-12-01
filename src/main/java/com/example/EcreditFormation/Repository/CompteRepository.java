package com.example.EcreditFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EcreditFormation.models.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long>{

}
