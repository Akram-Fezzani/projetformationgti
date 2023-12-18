package com.example.EcreditFormation.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EcreditFormation.models.Unite;


@Repository
public interface UniteRepository extends JpaRepository<Unite, Long>{

}
