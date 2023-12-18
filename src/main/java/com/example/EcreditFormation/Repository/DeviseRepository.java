package com.example.EcreditFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EcreditFormation.models.Devise;
@Repository
public interface DeviseRepository extends JpaRepository<Devise, Long> {

}
