package com.example.EcreditFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EcreditFormation.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
