package com.ceuma.neuroapi.adapters.inbound.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceuma.neuroapi.adapters.outbound.dto.medico.MedicoDtoOut;
import com.ceuma.neuroapi.adapters.outbound.dto.usuario.UsuarioDto;
import com.ceuma.neuroapi.adapters.outbound.dto.usuario.UsuarioDtoIn;
import com.ceuma.neuroapi.adapters.outbound.dto.usuario.UsuarioDtoOut;
import com.ceuma.neuroapi.application.services.UsuarioService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    /**
     *  O entrypoint cadastrar um residente ou medico
     *  @param UsuarioDtoIn 
     *  @return UsuarioDtoOut
     */
    @PostMapping
    public UsuarioDtoOut CriarUsuario(@RequestBody UsuarioDtoIn usuarioIn){
        UsuarioDto usuarioDto = (UsuarioDto) usuarioIn;
        System.out.println(usuarioDto.toString());
        UsuarioDtoOut usuarioOut = usuarioService.createAnUser(usuarioIn);
        return usuarioOut;
    }


    @GetMapping
    public UsuarioDtoOut puxarMedico(@RequestParam(name = "id",defaultValue = "1") Long id){
        return usuarioService.findByUsuarioId(id);
    }
}
