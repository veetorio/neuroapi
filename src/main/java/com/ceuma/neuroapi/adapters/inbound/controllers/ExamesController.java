package com.ceuma.neuroapi.adapters.inbound.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceuma.neuroapi.adapters.outbound.dto.agendar.AgendarDtoOut;
import com.ceuma.neuroapi.adapters.outbound.dto.exams.AvaliacaoDtoIn;
import com.ceuma.neuroapi.adapters.outbound.dto.exams.AvaliacaoDtoOut;
import com.ceuma.neuroapi.adapters.outbound.dto.exams.opcoes.GrupoDtoOut;
import com.ceuma.neuroapi.adapters.outbound.dto.solucao.SolucaoDtoIn;
import com.ceuma.neuroapi.application.services.AvaliacaoService;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("exam")
public class ExamesController {

    // Logger logger = LoggerFactory.getLogger(ExameController.class);
    private static final Logger logger = LoggerFactory.getLogger(ExamesController.class);
    
    @Autowired
    private AvaliacaoService avService;
    
    @PostMapping
    public AvaliacaoDtoIn criarPergunta(@RequestBody AvaliacaoDtoIn entity) {
        logger.info("CLIENTE ACESSOU A ROTA EXAM:POST COM O CORPO -> gerou a avaliacao " + entity.getNome());
        avService.salvarAvaliacao(entity);
        return entity;
    }
    
    @GetMapping
    public List<AvaliacaoDtoOut> getMethodName() {
        return avService.findAllAvaliacao();
    }

    @GetMapping("search-exams-per-user")
    public List<AgendarDtoOut> searchPerUser(@RequestParam Long searchExamsByUserId) {
        return avService
            .findAllAvaliacaoPerIdUser(searchExamsByUserId);
    }
    
    
    
    
}
