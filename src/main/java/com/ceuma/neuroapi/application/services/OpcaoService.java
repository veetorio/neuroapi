package com.ceuma.neuroapi.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceuma.neuroapi.application.repositories.AvaliacaoRepository;
import com.ceuma.neuroapi.application.repositories.OpcaoRepository;
import com.ceuma.neuroapi.domain.models.Avaliacao;
import com.ceuma.neuroapi.domain.models.Opcao;
import com.ceuma.neuroapi.domain.relations.AvaliacaoOpcao;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class OpcaoService {

    @Autowired
    private OpcaoRepository opcaoRepository;


    @Autowired
    private AvaliacaoOpcaoService avaliacaoOpcaoService;

    @Autowired
    private AvaliacaoRepository avaliacaoService;

    public void criarOpcao(List<Opcao> opcoes,Long id){
        Avaliacao avaliacao = avaliacaoService.findById(id).orElse(null);
        List<AvaliacaoOpcao> avopList = new ArrayList<>();
        for (var opcao : opcoes){
            AvaliacaoOpcao avop = new AvaliacaoOpcao();

            avop.setFk_avaliacao(avaliacao);
            avop.setFk_opcao(opcao);
            avopList.add(avop);
            opcao.setAvaliacoes(avopList);

            opcaoRepository.save(opcao);
            
            
            avaliacaoOpcaoService.criarRelação(avop);
        }
        
    }
    
}
