package com.example.EcreditFormation.serviceInterface;

import java.util.List;

import com.example.EcreditFormation.models.Client;

public interface IClientService {

	List<Client> findAll();

	Client addClient(Client client);

	Client updateClient(Client user, Long ClientID);

	void deleteClientById(Long ClientID);

	Client retrieveClient(Long ClientID);
}
