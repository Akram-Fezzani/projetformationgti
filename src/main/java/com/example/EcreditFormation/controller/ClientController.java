package com.example.EcreditFormation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcreditFormation.models.Client;
import com.example.EcreditFormation.serviceInterface.IClientService;

import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/client")

public class ClientController {

	
	@Autowired
	IClientService clientService;
	
	
    @PostMapping("/postClient")
	@ResponseBody
	public Client addClient(@RequestBody Client client) {
	        return clientService.addClient(client);
	    }
    
   
    
   
    
	@PostMapping("updateClient/{clientID}")
	@ResponseBody
	Client updateClient(@RequestBody Client client,@PathVariable Long clientID){
		return clientService.updateClient(client, clientID) ;
	}
    
    @GetMapping("/getClient")
    @ResponseBody
    public List<Client> findAllClients() {
        return clientService.findAll();
    }
    

    @DeleteMapping("/delete/{clientID}")
    public void deleteClientById(@PathVariable Long clientID) {
    	clientService.deleteClientById(clientID);
    
    }
    

    
    @ApiOperation(value = "retrieveClient")
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Optional<Client> client = clientService.getClientById(id);

        return client.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    
    @ApiOperation(value = "retrieveClientByCin")
    @GetMapping("retrieveClientByCin/{cin}")
    public ResponseEntity<Client> getClientByCin(@PathVariable Long cin) {
        Optional<Client> client = clientService.getClientByCin(cin);

        return client.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
