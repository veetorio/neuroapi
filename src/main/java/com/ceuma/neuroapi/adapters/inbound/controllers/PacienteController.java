package com.ceuma.neuroapi.adapters.inbound.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceuma.neuroapi.adapters.outbound.dto.paciente.PacienteDtoIn;
import com.ceuma.neuroapi.adapters.outbound.dto.paciente.PacienteDtoOut;
import com.ceuma.neuroapi.application.services.PacienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("neuroapi")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    /**
    *  Essa função vai ser executada quando um residente ou medico, iniciar uma nova conta.
    *  @param PacienteDtoIn. 
    *  @return UsuarioDtoOut retorna uma instancia de Usuario com poucos atributos só matendo uum
    */
    @PostMapping("pacientes")
    public PacienteDtoOut criarPaciente(@RequestBody PacienteDtoIn entity) {
        return pacienteService.criarPaciente(entity);
    }
    
}