package com.example.EcreditFormation.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class TypeCredit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String typeCredit;

}
