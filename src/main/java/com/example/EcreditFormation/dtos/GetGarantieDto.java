package com.example.EcreditFormation.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetGarantieDto {
	private Long idGarantie;
	private String nature;
	private String typeGarantie;
	private String deviseGarantie;
	private float valeur;
}
