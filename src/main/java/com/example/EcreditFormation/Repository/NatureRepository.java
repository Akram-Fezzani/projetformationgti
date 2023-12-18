package com.example.EcreditFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EcreditFormation.models.Nature;

@Repository
public interface NatureRepository extends JpaRepository<Nature, Long>{

}
