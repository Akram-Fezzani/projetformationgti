package com.example.EcreditFormation.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcreditFormation.models.TypeGarantie;
import com.example.EcreditFormation.repository.TypeGarantieRepository;
import com.example.EcreditFormation.serviceInterface.ITypeGarantieService;

@Service
public class TypeGarantieService implements ITypeGarantieService {

	
	
	@Autowired
	TypeGarantieRepository typeGarantieRepository;
	
	@Override
	public List<TypeGarantie> findAll() {
		   try {
				return  typeGarantieRepository.findAll();
				}
		    catch (Exception e) {
				throw new RuntimeException("error getting types garanties", e);
				}
	}
	
	
	@Transactional
	@Override
	public TypeGarantie addTypeGarantie(TypeGarantie typeGarantie) {
		   try {
				return typeGarantieRepository.save(typeGarantie);
				}
		    catch (Exception e) {
				throw new RuntimeException("error posting this type garantie", e);
				}
	}

	@Transactional
	@Override
	public TypeGarantie updateTypeGarantie(TypeGarantie typeGarantie, Long typeGarantieID) {
		  try {
			  typeGarantie.setId(typeGarantieID);
				return typeGarantieRepository.save(typeGarantie);				}
		    catch (Exception e) {
				throw new RuntimeException("error updating this type garantie", e);
				}
	}
	
	@Transactional
	@Override
	public void deleteTypeGarantieById(Long typeGarantieID) {
		  try {
				typeGarantieRepository.deleteById(typeGarantieID);
			}
		    catch (Exception e) {
				throw new RuntimeException("error updating this type garantie", e);
				}
	}
	
	
	@Override
	   public Optional<TypeGarantie> getTypeGarantieById(Long typeGarantieID) {
			  try {
			        return typeGarantieRepository.findById(typeGarantieID);
				}
			    catch (Exception e) {
					throw new RuntimeException("error getting type garantie with this id ", e);
					}
	    }
	

}
