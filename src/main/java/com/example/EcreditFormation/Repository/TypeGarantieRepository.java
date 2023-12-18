package com.example.EcreditFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EcreditFormation.models.TypeGarantie;
@Repository
public interface TypeGarantieRepository extends JpaRepository<TypeGarantie, Long>{

}
