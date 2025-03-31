package com.ceuma.neuroapi.adapters.inbound.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceuma.neuroapi.adapters.outbound.dto.hospital.HospitalDtoIn;
import com.ceuma.neuroapi.adapters.outbound.dto.hospital.HospitalDtoOut;
import com.ceuma.neuroapi.application.services.HospitalService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/neuroapi")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    /**
     * O metodo é invocado quando um este endpoint for chamado por medicos ou admin e irá cadastrar uma Instituicao
     * @param hospitalIn este argumento é o body da requisições
     */
    @Async
    @PostMapping("/instituicoes")
    public void criarNovaInstituto(@RequestBody HospitalDtoIn hospitalIn) {        
        hospitalService.novaInstituicao(hospitalIn);
    }

    /**
     * O metodo é invocado quando um este endpoint for chamado por medicos ou usuarios e irá listar as Instituicao
     * @param void  
     * @return List<HospitalDtoOut> listar , vai retornar uma lista de HospitaLDtoOut.
     */
    @Async
    @GetMapping("/instituicoes")
    public List<HospitalDtoOut> listarInstitutos() {
        return hospitalService.listarTodasInstitutos();
    }
    
    
    
}
