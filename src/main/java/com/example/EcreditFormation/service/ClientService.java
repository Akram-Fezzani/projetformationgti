package com.example.EcreditFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcreditFormation.models.Client;
import com.example.EcreditFormation.repository.ClientRepository;
import com.example.EcreditFormation.serviceInterface.IClientService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClientService implements IClientService {

	
	
	@Autowired
	ClientRepository clientRepository;
	
	
	
	//afficher la liste des users
	@Override
	public List<Client> findAll() {
		return  clientRepository.findAll();
	}
	
	
	//ajouter un client
	@Override
	public Client addClient(Client user) {
		
	return clientRepository.save(user);
	}
	
	@Override
	public Client updateClient(Client user, Long userID) {
		
			user.setId(userID);
			return clientRepository.save(user);
		
	}
	
	//effacer un client
	@Override
	public void deleteClientById(Long clientID) {
		clientRepository.deleteById(clientID);
		
	}
	
	@Override
	public Client retrieveClient(Long clientID){
		return clientRepository.findById(clientID).get();
	}
	@Override
	   public Optional<Client> getClientById(Long id) {
	        return clientRepository.findById(id);
	    }
}
