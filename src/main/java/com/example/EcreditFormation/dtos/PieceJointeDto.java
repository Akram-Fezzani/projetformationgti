package com.example.EcreditFormation.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PieceJointeDto {

	private String document;
	private String fileName;
	private boolean obligatoire;
	private boolean status;
	private float fileSize;
	private String filePath;
}