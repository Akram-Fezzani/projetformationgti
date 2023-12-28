package com.example.EcreditFormation.dtos;

import java.util.Date;

import javax.persistence.Column;

import com.example.EcreditFormation.models.TypeCredit;
import com.example.EcreditFormation.models.Unite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreditDto {
	private Long id;
	private float montant;
	private  int nbrEcheance;
	private Long type;
	private Long unite;
	private String observation;
	private Date entreeRelation;
	private String par;
	private boolean status;
	private Date dateDemande;
	private Long compteId;
	private String display;
	private float taux;
	private  float sommeEcheance;
}
