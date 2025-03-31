package com.ceuma.neuroapi.adapters.inbound.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceuma.neuroapi.adapters.outbound.dto.usuario.UsuarioDtoIn;
import com.ceuma.neuroapi.adapters.outbound.dto.usuario.UsuarioDtoOut;
import com.ceuma.neuroapi.application.services.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("neuroapi")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    /**
     *  O entrypoint cadastrar um residente ou medico
     *  @param UsuarioDtoIn 
     *  @return UsuarioDtoOut
     */
    @PostMapping("usuarios")
    public UsuarioDtoOut CriarUsuario(@RequestBody UsuarioDtoIn usuarioIn){
        UsuarioDtoOut usuarioOut = usuarioService.createAnUser(usuarioIn);
        return usuarioOut;
    }
}
