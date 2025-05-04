package com.ceuma.neuroapi.adapters.outbound.dto.exams.pergunta;

import java.util.ArrayList;
import java.util.List;

import com.ceuma.neuroapi.adapters.outbound.dto.exams.opcoes.OpcaoDtoIn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PerguntaDtoIn {
    private String enunciado;
    private List<OpcaoDtoIn> opcoes = new ArrayList<>();
    private Long fkGrupo;
}
