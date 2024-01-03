package com.example.EcreditFormation.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcreditFormation.exception.ResourceNotFoundException;
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

	@Override
	public List<Client> findAll() {
		   try {
				return  clientRepository.findAll();
		       }
		   catch (Exception e) {
				 throw new ResourceNotFoundException(" client not found");
			   }
			    
	}
	
	
	@Transactional	@Override
	public Client addClient(Client user) {
	   try {
			return clientRepository.save(user);
		   }
	   catch (Exception e) {
			 throw new ResourceNotFoundException(" this client couldn't be posted " );
		   }   
	}	
	@Transactional
	@Override
	public Client updateClient(Client client, Long clientID) {
			 try {
				 client.setId(clientID);
				return clientRepository.save(client);
				}
			 catch (Exception e) {
				 throw new ResourceNotFoundException(" client not found with id = " + clientID);
				}  
	}
	
	@Transactional
	@Override
	public void deleteClientById(Long clientID) {
		 try {
			 clientRepository.deleteById(clientID);
			}
		 catch (Exception e) {
			 throw new ResourceNotFoundException(" client not found with id = " + clientID);
			}  
	}
	

	@Override
	   public Optional<Client> getClientById(Long id) {
	   	 try {
		     return clientRepository.findById(id);
			}
		 catch (Exception e) {
			 throw new ResourceNotFoundException(" client not found with id = " + id);
			}  
	    }
	
	
	@Override
	public Optional<Client> getClientByCin(Long cin){
     	 try {
             return clientRepository.findByCin(cin);
			}
		 catch (Exception e) {
			 throw new ResourceNotFoundException(" client not found with cin = " + cin);
			} 
    }
	
	@Override
	   public List<Compte> getCompteByClientCin(Long cin) {
		 try {
				Client client= clientRepository.findByCin(cin).orElse(null);
				List <Compte> c = compteRepository.findByClientId(client.getId());
				return c;			
			}
		 catch (Exception e) {
				 throw new ResourceNotFoundException(" no compte is found with an owner cin = " + cin);
			} 
	}


	
}
