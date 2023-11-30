package com.example.EcreditFormation.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long numcompte;
	private long id;
	private Date dateOuverture;
}
