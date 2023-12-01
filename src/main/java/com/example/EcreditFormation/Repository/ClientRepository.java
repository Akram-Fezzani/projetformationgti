package com.example.EcreditFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EcreditFormation.models.Client;

@Repository

public interface ClientRepository extends JpaRepository<Client, Long>{

}
