package com.example.EcreditFormation.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetDemandeDto {

	
	private ClientDto ClientDto;
	private CompteDto CompteDto;
	private CreditDto CreditDto;
	//private List<GarantieDto> GarantieDto;
	//private List<PieceJointeDto> PieceJointeDto;
}
