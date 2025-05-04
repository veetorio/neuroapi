package com.ceuma.neuroapi.adapters.outbound.dto.usuario;

import java.util.ArrayList;

import com.ceuma.neuroapi.domain.models.Usuario;
import com.ceuma.neuroapi.domain.relations.MedicoResidente;
import com.ceuma.neuroapi.utils.enums.TipoUsuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/*
 * Herda de HospitalDto uma classe filha com objetivo de receber dados de adaptadores de entrada
 */
@Getter
@ToString
public class UsuarioDtoIn extends UsuarioDto{
    
    private String senha;

    public UsuarioDtoIn(String email, String nome, String senha, TipoUsuario tipo,Long id) {
        super(email,nome,tipo,id);
        this.senha = senha;  
    }

    public UsuarioDtoIn (UsuarioDtoLogin login){
        super(login.getEmail(),login.getSenha(),null,null);
    }
    
}
