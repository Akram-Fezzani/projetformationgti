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

import com.example.EcreditFormation.models.TypeCredit;
import com.example.EcreditFormation.serviceInterface.ITypeCreditService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/TypeCredit")
public class TypeCreditController {

	

	@Autowired
	ITypeCreditService typeCreditService;
	
	@PostMapping("/postTypeCredit")
	@ResponseBody
	public TypeCredit addCompte(@RequestBody TypeCredit typeCredit) {
		 return typeCreditService.addTypeCredit(typeCredit);
	}
    
	@PostMapping("updateTypeCredit/{typeCreditID}")
	@ResponseBody
	TypeCredit updateTypeCredit(@RequestBody TypeCredit typeCredit,@PathVariable Long typeCreditID){
		return typeCreditService.updateTypeCredit(typeCredit, typeCreditID);
	}
    
    @GetMapping("/getTypeCredit")
    @ResponseBody
    public List<TypeCredit> findAllTypeCredits() {
        return typeCreditService.findAll();
    }
    

    @DeleteMapping("/delete/{typeCreditID}")
    public void deleteTypeCreditById(@PathVariable Long typeCreditID) {
    	typeCreditService.deleteTypeCreditById(typeCreditID);
    
    }
    

    
    @ApiOperation(value = "retrieveCredit")
    @GetMapping("/{id}")
    public ResponseEntity<TypeCredit> getClientById(@PathVariable Long id) {
        Optional<TypeCredit> compte = typeCreditService.getTypeCreditById(id);

        return compte.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    
}
