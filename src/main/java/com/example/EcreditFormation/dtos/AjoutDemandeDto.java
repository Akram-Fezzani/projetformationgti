package com.example.EcreditFormation.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AjoutDemandeDto {
	
	private ClientDto ClientDto;
	private CompteDto CompteDto;
	private CreditDto CreditDto;
	private GarantieDto GarantieDto;
	private PieceJointeDto PieceJointeDto;
	}
