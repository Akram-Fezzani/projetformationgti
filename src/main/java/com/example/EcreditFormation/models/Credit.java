package com.example.EcreditFormation.models;

import java.util.Date;

import javax.persistence.Column;
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
	private Date dateDemande;
	private String display;
	private String par;
	private String observation;
	private Long type;
	private Long unite;
	private Long compteId;
	private boolean status;
	
	@Column(name="taux")
	private float taux;
	
	@Column(name="Echeance")
	private  float Echeance;
	
	@Column(name="montantEcheance")
	private  float montantEcheance;
}
