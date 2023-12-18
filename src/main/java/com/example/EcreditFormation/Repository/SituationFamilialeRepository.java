package com.example.EcreditFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EcreditFormation.models.SituationFamiliale;
@Repository
public interface SituationFamilialeRepository extends JpaRepository<SituationFamiliale, Long>{

}
