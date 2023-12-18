package com.example.EcreditFormation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcreditFormation.dtos.AjoutDemandeDto;
import com.example.EcreditFormation.dtos.GetDemandeDto;
import com.example.EcreditFormation.models.Credit;
import com.example.EcreditFormation.service.DtoService;

import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/dto")
public class DtoController {

	@Autowired
	DtoService dtoService;
	
    @PostMapping("/ajouter")
   	@ResponseBody
   	public Credit ajouterDemandeParDto(@RequestBody AjoutDemandeDto credit) {
   	        return dtoService.addDemandeCredit(credit);
   	    }
    
    @GetMapping("/getCredits")
    @ResponseBody
    public List<GetDemandeDto> findAllCreditsByDto() {
        return dtoService.getDemandeCredit();
    }
    
	@PostMapping("updatedto/{creditID}")
	@ResponseBody
	Credit updateCreditDto(@RequestBody AjoutDemandeDto dto,@PathVariable Long creditID){
		return dtoService.updateDemandeCredit(dto, creditID);
	}
	

    @ApiOperation(value = "getDemandeCreditByCreditId")
    @GetMapping("getDemandeCreditByCreditId/{id}")
    public GetDemandeDto getDemandeCreditByCreditId(@PathVariable Long id) {
    	return dtoService.getDemandeCreditByCreditId(id);
         
    }
}
