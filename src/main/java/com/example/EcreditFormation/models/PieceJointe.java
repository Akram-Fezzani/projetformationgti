package com.example.EcreditFormation.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class PieceJointe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String document;
	private String fileName;
	private boolean obligatoire;
	private boolean status;
	private String fileSize;
	private String filePath;


}
