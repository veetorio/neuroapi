package com.ceuma.neuroapi.adapters.inbound.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceuma.neuroapi.adapters.outbound.dto.usuario.UsuarioDtoIn;
import com.ceuma.neuroapi.adapters.outbound.dto.usuario.UsuarioDtoLogin;
import com.ceuma.neuroapi.adapters.outbound.dto.usuario.UsuarioDtoOut;
import com.ceuma.neuroapi.application.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("login")
public class LoginController {
    
    @Autowired
    private UsuarioService service;

    @PostMapping
    public UsuarioDtoOut loginInFunction(@RequestBody UsuarioDtoLogin entity) {
        return service.login(new UsuarioDtoIn(entity));
    }
    
    
}
