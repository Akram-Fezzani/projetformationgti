package com.example.EcreditFormation.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class Credit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private float montant;
	private  int nbrEcheance;
	private Date entreeRelation;
	private String par;
	private String observation;
	private TypeCredit type;
	private Unite unite;
}
