package com.example.EcreditFormation.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Gatantie {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Nature nature;
	private TypeGarantie type;
	private Devise devise;
}
