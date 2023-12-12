package com.example.EcreditFormation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EcreditFormation.models.Compte;


@Repository
public interface CompteRepository extends JpaRepository<Compte, Long>{
    List<Compte> findByClientId(Long clientId);

}
