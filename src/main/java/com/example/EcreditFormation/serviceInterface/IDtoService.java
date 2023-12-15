package com.example.EcreditFormation.serviceInterface;

import java.util.List;

import com.example.EcreditFormation.dtos.AjoutDemandeDto;
import com.example.EcreditFormation.dtos.GetDemandeDto;
import com.example.EcreditFormation.models.Credit;

public interface IDtoService {

	List<GetDemandeDto> getDemandeCredit();
	
	Credit updateDemandeCredit(AjoutDemandeDto ajoutDemandeDto,Long creditId);
	
	GetDemandeDto  getDemandeCreditByCreditId(Long creditId);
	
	Credit addDemandeCredit(AjoutDemandeDto ajoutDemandeDto);

}
