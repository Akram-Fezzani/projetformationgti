package com.example.EcreditFormation.models;

import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
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
	private Long type;
	private Long unite;
	private Long compteId;
	private boolean status;
	//@ElementCollection
	//private List<Long>pieceJointeIds;
	//@ElementCollection
	//private List<Long>garantieIds;
}
