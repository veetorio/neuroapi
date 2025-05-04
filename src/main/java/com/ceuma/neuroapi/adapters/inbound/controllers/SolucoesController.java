package com.ceuma.neuroapi.adapters.inbound.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceuma.neuroapi.adapters.outbound.dto.solucao.SolucaoDtoIn;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("solucoes")
public class SolucoesController {
    @PostMapping
    public SolucaoDtoIn postMethodName(@RequestBody SolucaoDtoIn entity) {
        return entity;
    }
    
}
