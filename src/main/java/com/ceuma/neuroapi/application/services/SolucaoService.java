package com.ceuma.neuroapi.application.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceuma.neuroapi.adapters.outbound.dto.solucao.SolucaoDtoIn;
import com.ceuma.neuroapi.application.repositories.SolucaoRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class SolucaoService {
    @Autowired
    private SolucaoRepository solucaoRepository;

    public void criarSoluções(SolucaoDtoIn solucaoDtoIn){

    }
    
}
