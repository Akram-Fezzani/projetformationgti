package com.example.EcreditFormation.dtos;

import com.example.EcreditFormation.models.Devise;
import com.example.EcreditFormation.models.Nature;
import com.example.EcreditFormation.models.TypeGarantie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GarantieDto {

	private Long natureId;
	private Long typeGarantieId;
	private Long deviseGarantieId;
	private float valeur;
}
