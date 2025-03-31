package com.ceuma.neuroapi.adapters.outbound.dto.usuario;

import com.ceuma.neuroapi.utils.enums.TipoUsuario;

import lombok.Getter;


/*
 * UsuarioDto uma super classe responsavel por caracterizar DTOS com caracteristica do Usuario
 */
@Getter
public class UsuarioDto {
    private String email;
    private String nome; 
    private TipoUsuario tipo;

    public UsuarioDto(String email, String nome, TipoUsuario tipo) {
        this.email = email;
        this.nome = nome;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "UsuarioDto [email=" + getEmail() + ", nome=" + getNome() + ", tipo=" + getTipo() + "]";
    }

}
