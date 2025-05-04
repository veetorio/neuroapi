package com.ceuma.neuroapi.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceuma.neuroapi.domain.relations.Solucoes;

public interface SolucaoRepository extends JpaRepository<Solucoes,Long> {
    
}
