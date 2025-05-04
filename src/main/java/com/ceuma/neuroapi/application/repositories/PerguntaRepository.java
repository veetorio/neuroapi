package com.ceuma.neuroapi.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceuma.neuroapi.domain.models.Pergunta;

public interface PerguntaRepository extends JpaRepository<Pergunta,Long> {
    
}
