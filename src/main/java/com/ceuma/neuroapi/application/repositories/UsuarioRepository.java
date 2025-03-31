package com.ceuma.neuroapi.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceuma.neuroapi.domain.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    
}
