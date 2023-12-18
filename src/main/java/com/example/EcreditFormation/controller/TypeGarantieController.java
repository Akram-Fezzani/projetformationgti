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

import com.example.EcreditFormation.models.TypeGarantie;
import com.example.EcreditFormation.serviceInterface.ITypeGarantieService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/TypeGarantie")
public class TypeGarantieController {

	

	@Autowired
	ITypeGarantieService typeGarantieService;
	
	@PostMapping("/postTypeGarantie")
	@ResponseBody
	public TypeGarantie addTypeGarantie(@RequestBody TypeGarantie typeGarantie) {
		 return typeGarantieService.addTypeGarantie(typeGarantie);
	}
    
	@PostMapping("updateTypeGarantie/{typeGarantieID}")
	@ResponseBody
	TypeGarantie updateTypeCredit(@RequestBody TypeGarantie typeGarantie,@PathVariable Long typeGarantieID){
		return typeGarantieService.updateTypeGarantie(typeGarantie, typeGarantieID);
	}
    
    @GetMapping("/getTypeGarantie")
    @ResponseBody
    public List<TypeGarantie> findAllTypeCredits() {
        return typeGarantieService.findAll();
    }
    

    @DeleteMapping("/delete/{typeGarantieID}")
    public void deleteTypeGarantieById(@PathVariable Long typeGarantieID) {
    	typeGarantieService.deleteTypeGarantieById(typeGarantieID);
    
    }
    

    
    @ApiOperation(value = "retrieveTypeGarantie")
    @GetMapping("/{id}")
    public ResponseEntity<TypeGarantie> getTypeGarantieById(@PathVariable Long id) {
        Optional<TypeGarantie> compte = typeGarantieService.getTypeGarantieById(id);

        return compte.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
