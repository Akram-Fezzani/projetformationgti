package com.example.EcreditFormation.dtos;

import java.util.Date;

import com.example.EcreditFormation.models.SituationFamiliale;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
	private long id;
	private long cin;
	private String nom;
	private String prenom;
	private Date dateNs;
	private Long situationFamilialeId;
}
