package com.example.EcreditFormation.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Garantie {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Long nature;
	private Long type;
	private Long devise;
	private float valeur;
	private Long creditId;
}