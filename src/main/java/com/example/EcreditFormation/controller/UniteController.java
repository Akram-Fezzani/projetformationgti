package com.example.EcreditFormation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcreditFormation.models.Unite;
import com.example.EcreditFormation.serviceInterface.IUniteService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Unite")
public class UniteController {

	

	@Autowired
	IUniteService uniteService;
	
	@PostMapping("/postUnite")
	@ResponseBody
	public Unite addUnite(@RequestBody Unite Unite) {
		 return uniteService.addUnite(Unite);
		 
	}
    
	@PostMapping("updateUnite/{typeCreditID}")
	@ResponseBody
	Unite updateUnite(@RequestBody Unite unite,@PathVariable Long uniteID){
		return uniteService.updateUnite(unite, uniteID);
	}
    
    @GetMapping("/getUnite")
    @ResponseBody
    public List<Unite> findAllUnites() {
        return uniteService.findAll();
    }
    

    @DeleteMapping("/delete/{uniteID}")
    public ResponseEntity<HttpStatus> deleteUniteById(@PathVariable Long uniteID) {
    	uniteService.deleteUniteById(uniteID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    

    
    @ApiOperation(value = "retrieveUnite")
    @GetMapping("/{id}")
    public ResponseEntity<Unite> getUniteById(@PathVariable Long id) {
        Optional<Unite> compte = uniteService.getUniteById(id);

        return compte.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
