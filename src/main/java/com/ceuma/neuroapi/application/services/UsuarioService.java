package com.ceuma.neuroapi.application.services;

import com.ceuma.neuroapi.adapters.outbound.dto.usuario.UsuarioDtoIn;
import com.ceuma.neuroapi.adapters.outbound.dto.usuario.UsuarioDtoOut;
import com.ceuma.neuroapi.application.repositories.UsuarioRepository;
import com.ceuma.neuroapi.domain.models.Usuario;
import com.ceuma.neuroapi.utils.validacoes.ValidarCrendenciaisUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The UsuarioService class in Java provides methods to create, update, and
 * remove user entities while
 * performing validation checks on user input.
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    
    // This `createAnUser` method in the `UsuarioService` class is responsible for
    // creating a new user
    // entity based on the input provided in the `UsuarioDtoIn` object. Here's a
    // breakdown of what the
    // method does:
    public UsuarioDtoOut createAnUser(UsuarioDtoIn tuple) {
        ValidarCrendenciaisUsuario validacoes = new ValidarCrendenciaisUsuario(tuple);

        if (validacoes.camposNulos())
            throw new Error("campos nulos");
        if (validacoes.camposVazios())
            throw new Error("campos vazios");
        if (validacoes.validarEmail())
            throw new Error("formato de email esta errado");
        if (validacoes.validarPatternUsuario())
            throw new Error("formato de nome");

        Usuario user = new Usuario(tuple);
        repository.save(user);
        return new UsuarioDtoOut(tuple);
    };

    public void updateAnUser(UsuarioDtoIn newTuple) {
        return;
    };

    public void removeAnUser(Long index) {

    };
}