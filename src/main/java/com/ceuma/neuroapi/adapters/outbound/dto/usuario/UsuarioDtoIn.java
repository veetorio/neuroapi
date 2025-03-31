package com.ceuma.neuroapi.adapters.outbound.dto.usuario;

import java.util.ArrayList;

import com.ceuma.neuroapi.domain.models.Usuario;
import com.ceuma.neuroapi.domain.relations.MedicoResidente;
import com.ceuma.neuroapi.utils.enums.TipoUsuario;

import lombok.Getter;

/*
 * Herda de HospitalDto uma classe filha com objetivo de receber dados de adaptadores de entrada
 */
public class UsuarioDtoIn extends UsuarioDto{
    
    @Getter
    private String senha;

    public UsuarioDtoIn(String email, String nome, String senha, TipoUsuario tipo) {
        super(email,nome,tipo);
        this.senha = senha;  
    }

    public Usuario gerarUsuario(){
        return new Usuario(null, getEmail(),getSenha(),getNome(),getTipo(),new ArrayList<MedicoResidente>(),new ArrayList<MedicoResidente>());
    }
    

    
}
