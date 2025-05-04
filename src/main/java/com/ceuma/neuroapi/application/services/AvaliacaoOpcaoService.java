package com.ceuma.neuroapi.application.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceuma.neuroapi.application.repositories.AvaliacaoOpcaoRepository;
import com.ceuma.neuroapi.domain.relations.AvaliacaoOpcao;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class AvaliacaoOpcaoService {
    @Autowired
    private AvaliacaoOpcaoRepository avRepository;

    public void criarRelação(AvaliacaoOpcao avop){
        if (avop == null) {
            throw new Error();
        }
        avRepository.save(avop);
    }
}
