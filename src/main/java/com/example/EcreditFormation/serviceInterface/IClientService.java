package com.example.EcreditFormation.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.example.EcreditFormation.models.Client;
import com.example.EcreditFormation.models.Compte;

public interface IClientService {

	List<Client> findAll();

	Client addClient(Client client);

	Client updateClient(Client user, Long ClientID);

	void deleteClientById(Long ClientID);

	//Client retrieveClient(Long ClientID);
	
	Optional<Client> getClientById(Long id);
	
	Optional<Client> getClientByCin(Long cin);
	
	List<Compte> getCompteByClientCin(Long cin) ;
}
