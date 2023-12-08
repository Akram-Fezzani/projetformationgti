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

import com.example.EcreditFormation.models.Garantie;
import com.example.EcreditFormation.serviceInterface.ICreditService;
import com.example.EcreditFormation.serviceInterface.IGarantieService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Garantie")
public class GarantieController {

	

	@Autowired
	IGarantieService garantieService;
	
	
    @PostMapping("/postGarantie")
	@ResponseBody
	public Garantie addGarantie(@RequestBody Garantie credit) {
	        return garantieService.addGarantie(credit);
	    }
    
	@PostMapping("updateGarantie/{garantieID}")
	@ResponseBody
	Garantie updateGarantie(@RequestBody Garantie garantie,@PathVariable Long garantieID){
		return garantieService.updateGarantie(garantie, garantieID);
	}
    
    @GetMapping("/getGaranties")
    @ResponseBody
    public List<Garantie> findAllGaranties() {
        return garantieService.findAll();
    }
    

    @DeleteMapping("/delete/{garantieID}")
    public void deleteGarantieById(@PathVariable Long garantieID) {
    	garantieService.deleteGarantieById(garantieID);
    
    }
    

    
    @ApiOperation(value = "retrieveGarantie")
    @GetMapping("/{id}")
    public ResponseEntity<Garantie> getGarantieById(@PathVariable Long id) {
        Optional<Garantie> compte = garantieService.getGarantieById(id);

        return compte.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
