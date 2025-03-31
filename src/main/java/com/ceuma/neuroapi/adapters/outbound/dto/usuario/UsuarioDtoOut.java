package com.ceuma.neuroapi.adapters.outbound.dto.usuario;
import lombok.Getter;


/*
 * HospitalDto uma super classe responsavel por guarda dados de retorno
 */
@Getter
public class UsuarioDtoOut extends UsuarioDto {
    public UsuarioDtoOut(UsuarioDtoIn usuarioDtoIn) {
        super(usuarioDtoIn.getEmail(),usuarioDtoIn.getNome(),usuarioDtoIn.getTipo());  
    }
    
}
