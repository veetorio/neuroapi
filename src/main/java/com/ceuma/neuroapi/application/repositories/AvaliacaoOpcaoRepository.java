package com.ceuma.neuroapi.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceuma.neuroapi.domain.relations.AvaliacaoOpcao;

public interface AvaliacaoOpcaoRepository extends JpaRepository<AvaliacaoOpcao,Long> {
    
}
