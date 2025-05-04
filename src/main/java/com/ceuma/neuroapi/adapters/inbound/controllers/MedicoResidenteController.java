package com.ceuma.neuroapi.adapters.inbound.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceuma.neuroapi.adapters.outbound.dto.medicoresidente.MedicoResidenteDtoOut;
import com.ceuma.neuroapi.adapters.outbound.dto.medicoresidente.MedicoResidenteIn;
import com.ceuma.neuroapi.application.services.MedicoResidenteService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/mr")
public class MedicoResidenteController {

    @Autowired
    private MedicoResidenteService mrService;

    @GetMapping
    public List<MedicoResidenteDtoOut> chamarTodasMR() {
        return mrService.listarMR();
    }
    
    @PostMapping
    public void criarUmMR(@RequestBody MedicoResidenteIn mrIn) {
        System.out.println(mrIn.getHospital() + "" + mrIn.getMedico() + " " + mrIn.getResidente());
         mrService.registrarUsuariosEmSistemas(mrIn);
    }
    
}
