package com.ceuma.neuroapi.adapters.outbound.dto.solucao;

import java.util.List;

import com.ceuma.neuroapi.adapters.outbound.dto.exams.pergunta.PerguntaDtoIn;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class SolucaoDtoIn {
    private List<PerguntaDtoIn> solucoes;
}
