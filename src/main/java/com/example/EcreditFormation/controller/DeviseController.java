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

import com.example.EcreditFormation.models.Devise;
import com.example.EcreditFormation.serviceInterface.IDeviseService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Devise")
public class DeviseController {

	
	

	@Autowired
	IDeviseService deviseService;
	
	@PostMapping("/postDevise")
	@ResponseBody
	public Devise addDevise(@RequestBody Devise devise) {
	        return deviseService.addDevise(devise);
	    }
    
	@PostMapping("updateDevise/{deviseID}")
	@ResponseBody
	Devise updateDevise(@RequestBody Devise devise,@PathVariable Long deviseID){
		return deviseService.updateDevise(devise, deviseID);
	}
    
    @GetMapping("/getDevise")
    @ResponseBody
    public List<Devise> findAllDevises() {
        return deviseService.findAll();
    }
    

    @DeleteMapping("/delete/{deviseID}")
    public void deleteDeviseById(@PathVariable Long deviseID) {
    	deviseService.deleteDeviseById(deviseID);
    
    }
    

    
    @ApiOperation(value = "retrieveDevise")
    @GetMapping("/{id}")
    public ResponseEntity<Devise> getDeviseById(@PathVariable Long id) {
        Optional<Devise> compte = deviseService.getDeviseById(id);

        return compte.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
}
