package com.example.EcreditFormation.dtos;

import java.util.Date;

import com.example.EcreditFormation.models.Devise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompteDto {

	private long numcompte;
	private Date dateOuverture;
	private Long deviseId;
	
	
	
}
