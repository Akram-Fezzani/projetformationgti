package com.example.EcreditFormation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcreditFormation.models.Client;
import com.example.EcreditFormation.models.Compte;
import com.example.EcreditFormation.serviceInterface.IClientService;
import com.example.EcreditFormation.serviceInterface.ICompteService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/Compte")
public class CompteController {


	@Autowired
	ICompteService compteService;
	
	@Autowired
	IClientService clientService;
	
    @PostMapping("/postCompte")
	@ResponseBody
	public Compte addCompte(@RequestBody Compte compte) {
	        return compteService.addCompte(compte);
	    }
    
	@PostMapping("updateCompte/{compteID}")
	@ResponseBody
	Compte updateCompte(@RequestBody Compte compte,@PathVariable Long compteID){
		return compteService.updateCompte(compte, compteID);
	}
    
    @GetMapping("/getCompte")
    @ResponseBody
    public List<Compte> findAllComptes() {
        return compteService.findAll();
    }
    

    @DeleteMapping("/delete/{compteID}")
    public void deleteClientById(@PathVariable Long compteID) {
    	compteService.deleteCompteById(compteID);
    
    }
    

    
    @ApiOperation(value = "retrieveCompte")
    @GetMapping("/{id}")
    public ResponseEntity<Compte> getClientById(@PathVariable Long id) {
        Optional<Compte> compte = compteService.getCompteById(id);

        return compte.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
	
    
    @ApiOperation(value = "CompteByUserCin")
    @GetMapping("CompteByUserCin/{cin}")
    public List<Compte> getCompteByUserCin(@PathVariable Long cin) {
        List<Compte> compte = clientService.getCompteByClientCin(cin);
return compte;
       /* return compte.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());*/
    }
}
