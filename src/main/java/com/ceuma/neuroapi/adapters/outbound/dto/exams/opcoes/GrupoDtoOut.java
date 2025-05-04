package com.ceuma.neuroapi.adapters.outbound.dto.exams.opcoes;

import java.util.List;

import com.ceuma.neuroapi.adapters.outbound.dto.exams.pergunta.PerguntaDtoOut;
import com.ceuma.neuroapi.domain.models.Grupo;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class GrupoDtoOut {
    private String name;
    private List<PerguntaDtoOut> perguntas;

    public GrupoDtoOut(Grupo gpr){
        this.name = gpr.getNameGrupo();
        this.perguntas = gpr.getPerguntas().stream().map(PerguntaDtoOut::new).toList();
    }
}
