package com.ceuma.neuroapi.adapters.outbound.dto.exams;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceuma.neuroapi.adapters.outbound.dto.exams.opcoes.GrupoDtoOut;
import com.ceuma.neuroapi.adapters.outbound.dto.exams.pergunta.PerguntaDtoOut;
import com.ceuma.neuroapi.domain.models.Avaliacao;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AvaliacaoDtoOut {
        
    private String nome;
    private boolean status;
    private List<PerguntaDtoOut> perguntas;
    private List<GrupoDtoOut> grupos;


    public AvaliacaoDtoOut(Avaliacao av) {
        this.nome = av.getNome();

        this.perguntas = av
            .getAvaliacoesOpcoes()
            .stream()
            .map(opcao -> opcao.getFk_opcao())
            .map(pergunta -> pergunta.getFk_pergunta())
            .filter(Objects::nonNull)
            .distinct()
            .map(PerguntaDtoOut::new)
            .toList();

        this.grupos = av.getAvaliacoesOpcoes()
            .stream()
            .map(opcao -> opcao.getFk_opcao())
            .map(pergunta -> pergunta.getFk_pergunta())
            .map(grupo -> grupo.getFk_grupo())
            .filter(Objects::nonNull)
            .distinct()
            .map(GrupoDtoOut::new)
            .toList();
    }
}
