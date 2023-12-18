package com.example.EcreditFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcreditFormation.models.Client;
import com.example.EcreditFormation.models.Compte;
import com.example.EcreditFormation.repository.ClientRepository;
import com.example.EcreditFormation.repository.CompteRepository;
import com.example.EcreditFormation.serviceInterface.IClientService;


@Service
public class ClientService implements IClientService {
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	CompteRepository compteRepository;

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
	   public Optional<Client> getClientById(Long id) {
	        return clientRepository.findById(id);
	    }
	
	
	@Override
	public Optional<Client> getClientByCin(Long cin){
        return clientRepository.findByCin(cin);
    }
	
	@Override
	   public List<Compte> getCompteByClientCin(Long cin) {
		Client client= clientRepository.findByCin(cin).orElse(null);
		List <Compte> c = compteRepository.findByClientId(client.getId());
		return c;
	}


	
}
