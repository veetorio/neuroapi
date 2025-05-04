package com.ceuma.neuroapi.adapters.outbound.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UsuarioDtoLogin {
    private String email;
    private String senha;
}
