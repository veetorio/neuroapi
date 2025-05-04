package com.ceuma.neuroapi.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceuma.neuroapi.domain.relations.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta,Long> {
    
}
