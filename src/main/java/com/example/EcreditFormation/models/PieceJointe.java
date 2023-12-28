package com.example.EcreditFormation.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PieceJointe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String document;
	private String fileName;
	private boolean obligatoire;
	private boolean status;
	private float fileSize;
	private String filePath;
	private Long creditId;
	private String display;

}
