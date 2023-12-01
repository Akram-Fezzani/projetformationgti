package com.example.EcreditFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EcreditFormation.models.Compte;


@Repository
public interface CompteRepository extends JpaRepository<Compte, Long>{

}
