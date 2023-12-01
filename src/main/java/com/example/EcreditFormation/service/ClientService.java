package com.example.EcreditFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcreditFormation.Repository.ClientRepository;
import com.example.EcreditFormation.models.Client;
import com.example.EcreditFormation.serviceInterface.IClientService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClientService implements IClientService {

	
	
	@Autowired
	ClientRepository userRepository;
	
	
	
	//afficher la liste des users
	@Override
	public List<Client> findAll() {
		return  userRepository.findAll();
	}
	
	
	//ajouter un user
	@Override
	public Client addClient(Client user) {
		
	return userRepository.save(user);
	}
	
	@Override
	public Client updateClient(Client user, Long userID) {
		
			user.setId(userID);
			return userRepository.save(user);
		
	}
	
	//effacer un user
	@Override
	public void deleteClientById(Long clientID) {
		userRepository.deleteById(clientID);
		
	}
	
	@Override
	public Client retrieveClient(Long clientID){
		return userRepository.findById(clientID).get();
	}

}
