package com.ceuma.neuroapi.adapters.outbound.dto.usuario;
import com.ceuma.neuroapi.domain.models.Usuario;

import lombok.Getter;


/*
 * HospitalDto uma super classe responsavel por guarda dados de retorno
 */
@Getter
public class UsuarioDtoOut extends UsuarioDto {
    public UsuarioDtoOut(UsuarioDtoIn usuarioDtoIn) {
        super(usuarioDtoIn.getEmail(),usuarioDtoIn.getNome(),usuarioDtoIn.getTipo(),usuarioDtoIn.getId());
    }
    public UsuarioDtoOut(Usuario usuarioDtoIn) {
        super(usuarioDtoIn.getEmail(),usuarioDtoIn.getNome(),usuarioDtoIn.getTipoUsuario(),usuarioDtoIn.getIdUsuario());  
    }
    
}
