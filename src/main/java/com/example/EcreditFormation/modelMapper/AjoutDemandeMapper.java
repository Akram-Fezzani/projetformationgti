package com.example.EcreditFormation.modelMapper;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.EcreditFormation.dtos.AjoutDemandeDto;
import com.example.EcreditFormation.dtos.ClientDto;
import com.example.EcreditFormation.dtos.CompteDto;
import com.example.EcreditFormation.dtos.CreditDto;
import com.example.EcreditFormation.dtos.GarantieDto;
import com.example.EcreditFormation.dtos.PieceJointeDto;
import com.example.EcreditFormation.models.Compte;
import com.example.EcreditFormation.models.Credit;
import com.example.EcreditFormation.models.Garantie;
import com.example.EcreditFormation.models.PieceJointe;

import ch.qos.logback.core.net.server.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component
@Data
@AllArgsConstructor
//@NoArgsConstructor
public class AjoutDemandeMapper {
	@Autowired
     ModelMapper modelMapper;

   /* public AjoutDemandeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }*/
//client
    
    public AjoutDemandeMapper() {
    }
    public ClientDto convertClientToDto(Client client) {
        return modelMapper.map(client, ClientDto.class);
    }

    public Client convertClientToEntity(ClientDto clientDto) {
        return modelMapper.map(clientDto, Client.class);
    }
    
//compte
    
    public CompteDto convertCompteToDto(Compte compte) {
        return modelMapper.map(compte, CompteDto.class);
    }

    public Client convertCompteToEntity(CompteDto compteDto) {
        return modelMapper.map(compteDto, Client.class);
    }
//credit
    public CreditDto convertCreditToDto(Credit credit) {
        return modelMapper.map(credit, CreditDto.class);
    }

    public Credit convertCreditToEntity(CreditDto creditDto) {
        return modelMapper.map(creditDto, Credit.class);
    }
    
    
//garantie   
    public GarantieDto convertGarantieToDto(Garantie garantie) {
        return modelMapper.map(garantie, GarantieDto.class);
    }

    public Garantie convertGarantieToEntity(GarantieDto garantieDto) {
        return modelMapper.map(garantieDto, Garantie.class);
    }
//piece jointe
    public PieceJointeDto convertPieceJointeToDto(PieceJointe pieceJointe) {
        return modelMapper.map(pieceJointe, PieceJointeDto.class);
    }

    public PieceJointe convertPieceJointeToEntity(PieceJointeDto pieceJointeDto) {
        return modelMapper.map(pieceJointeDto, PieceJointe.class);
    }
    
    
}