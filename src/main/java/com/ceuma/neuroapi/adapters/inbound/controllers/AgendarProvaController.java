package com.ceuma.neuroapi.adapters.inbound.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceuma.neuroapi.adapters.outbound.dto.agendar.AgendarDtoIn;
import com.ceuma.neuroapi.adapters.outbound.dto.agendar.AgendarDtoOut;
import com.ceuma.neuroapi.application.services.AgendarService;


@RestController
@RequestMapping("agendar")
public class AgendarProvaController {


    @Autowired
    private AgendarService agendarService;
    @PostMapping
    public void agendarProva(@RequestBody AgendarDtoIn agender){
        agendarService.marcar(agender); 
    }

    @GetMapping
    public List<AgendarDtoOut> chamarTodasAsConsultas(){
        return agendarService.buscarConsultas();
    }
    
}
