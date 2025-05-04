package com.ceuma.neuroapi.adapters.outbound.dto.exams.pergunta;

import java.util.List;

import com.ceuma.neuroapi.adapters.outbound.dto.exams.opcoes.OpcoesDtoOut;
import com.ceuma.neuroapi.domain.models.Pergunta;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PerguntaDtoOut {

    private String enunciado;

    private List<OpcoesDtoOut> opcoes;

    public PerguntaDtoOut(Pergunta pergunta){
        this.enunciado = pergunta.getDescricao();
        this.opcoes = pergunta.getOpcoes().stream().map(OpcoesDtoOut::new).toList();

    }
}
