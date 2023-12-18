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

import com.example.EcreditFormation.models.SituationFamiliale;
import com.example.EcreditFormation.serviceInterface.ISituationFamilialeSerivce;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/situationFamiliale")
public class SituationFamilialeController {

	
	@Autowired
	ISituationFamilialeSerivce situationFamilialeSerivce;
	
	@PostMapping("/postsituationFamiliale")
	@ResponseBody
	public SituationFamiliale addSituationFamiliale(@RequestBody SituationFamiliale situationFamiliale) {
		 return situationFamilialeSerivce.addSituationFamiliale(situationFamiliale);
	}
    
	@PostMapping("updateSituationFamiliale/{situationFamilialeID}")
	@ResponseBody
	SituationFamiliale updateSituationFamiliale(@RequestBody SituationFamiliale situationFamiliale,@PathVariable Long situationFamilialeID){
		return situationFamilialeSerivce.updateSituationFamiliale(situationFamiliale, situationFamilialeID);
	}
    
    @GetMapping("/getSituationFamiliales")
    @ResponseBody
    public List<SituationFamiliale> findAllSituationFamiliales() {
        return situationFamilialeSerivce.findAll();
    }
    
    

    @DeleteMapping("/delete/{situationFamilialeID}")
    public void deleteSituationFamilialeById(@PathVariable Long situationFamilialeID) {
    	situationFamilialeSerivce.deleteSituationFamilialeById(situationFamilialeID);
    
    }
    
    @ApiOperation(value = "retrieveSituationFamiliale")
    @GetMapping("/{id}")
    public ResponseEntity<SituationFamiliale> getSituationFamilialeById(@PathVariable Long id) {
        Optional<SituationFamiliale> compte = situationFamilialeSerivce.getSituationFamilialeById(id);

        return compte.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @ApiOperation(value = "retrieveSituationFamilialeByCin")
    @GetMapping("retrieveSituationFamilialeByCin/{cin}")
    public Optional<SituationFamiliale> getSituationFamilialeByCin(@PathVariable Long cin) {

        return situationFamilialeSerivce.getSituationFamilialeByCin(cin);

    }
}
