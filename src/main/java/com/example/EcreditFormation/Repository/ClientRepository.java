package com.example.EcreditFormation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EcreditFormation.models.Client;
import com.example.EcreditFormation.models.Compte;

@Repository

public interface ClientRepository extends JpaRepository<Client, Long>{
	Optional<Client> findByCin(long cin);

}
