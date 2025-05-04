package com.ceuma.neuroapi.adapters.outbound.dto.usuario;

import com.ceuma.neuroapi.utils.enums.TipoUsuario;

import lombok.Getter;
import lombok.ToString;


/*
 * UsuarioDto uma super classe responsavel por caracterizar DTOS com caracteristica do Usuario
 */
@Getter
@ToString
public class UsuarioDto {
    private Long id;
    private String email;
    private String nome; 
    private TipoUsuario tipo;

    public UsuarioDto(String email, String nome, TipoUsuario tipo,Long id) {
        this.email = email;
        this.nome = nome;
        this.tipo = tipo;
        this.id = id;
    }

}
