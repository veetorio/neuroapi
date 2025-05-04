package com.ceuma.neuroapi.adapters.outbound.dto.exams;

import java.util.List;

import com.ceuma.neuroapi.adapters.outbound.dto.exams.opcoes.GrupoDtoIn;
import com.ceuma.neuroapi.adapters.outbound.dto.exams.pergunta.PerguntaDtoIn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class AvaliacaoDtoIn {
    private String nome;
    private boolean status;
    private Long fkHospital;
    private List<PerguntaDtoIn> perguntas;
    private List<GrupoDtoIn> grupos;

    

}
