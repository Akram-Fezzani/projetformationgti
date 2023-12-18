package com.example.EcreditFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EcreditFormation.models.TypeCredit;
@Repository
public interface TypeCreditRepository  extends JpaRepository<TypeCredit, Long>{

}
