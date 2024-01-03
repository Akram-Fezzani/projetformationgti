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
import com.example.EcreditFormation.models.Nature;
import com.example.EcreditFormation.serviceInterface.INatureService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Nature")
public class NatureController {

	

	@Autowired
	INatureService natureService;
	
	
    @PostMapping("/postNature")
	@ResponseBody
	public Nature addNature(@RequestBody Nature nature) {
	        return natureService.addNature(nature);
	    }
    
	@PostMapping("updateNature/{natureID}")
	@ResponseBody
	Nature updateGarantie(@RequestBody Nature nature,@PathVariable Long natureID){
		return natureService.updateNature(nature, natureID);
	}
    
    @GetMapping("/getNatures")
    @ResponseBody
    public List<Nature> findAllNatures() {
        return natureService.findAll();
    }
    

    @DeleteMapping("/delete/{natureID}")
    public void deleteNatureById(@PathVariable Long natureID) {
    	natureService.deleteNatureById(natureID);
    
    }
    

    
    @ApiOperation(value = "retrieveNature")
    @GetMapping("/{id}")
    public ResponseEntity<Nature> getNatureById(@PathVariable Long id) {
        Optional<Nature> compte = natureService.getNatureById(id);

        return compte.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
