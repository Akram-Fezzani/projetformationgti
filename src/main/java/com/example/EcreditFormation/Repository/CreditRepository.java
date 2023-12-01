package com.example.EcreditFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EcreditFormation.models.Credit;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {

}
