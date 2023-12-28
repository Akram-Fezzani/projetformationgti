package com.example.EcreditFormation.dtos;

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
