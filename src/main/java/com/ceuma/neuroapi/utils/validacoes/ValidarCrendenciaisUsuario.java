package com.ceuma.neuroapi.utils.validacoes;

import com.ceuma.neuroapi.adapters.outbound.dto.usuario.UsuarioDtoIn;

public class ValidarCrendenciaisUsuario {
    private UsuarioDtoIn usuario;

    public ValidarCrendenciaisUsuario(UsuarioDtoIn usuario) {
        this.usuario = usuario;
    }

    public boolean camposNulos(){
        return usuario.getEmail() == null | usuario.getSenha() == null | usuario.getNome() == null | usuario.getTipo() == null;
    }
    public boolean camposVazios(){
        return usuario.getEmail().isBlank()  | usuario.getSenha().isBlank()  | usuario.getNome().isBlank();
    }

    public boolean validarEmail(){
        return usuario.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,}$");
    }
    
    public boolean validarPatternUsuario(){
        return usuario.getNome().matches(".*[0-9@!$#&*()_+=].*");
    }
}
