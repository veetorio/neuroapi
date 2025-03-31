package com.ceuma.neuroapi.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceuma.neuroapi.domain.models.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {
    
}
