package com.ceuma.neuroapi.adapters.outbound.dto.exams.opcoes;

import java.util.List;

import com.ceuma.neuroapi.adapters.outbound.dto.exams.pergunta.PerguntaDtoIn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@Setter
@NoArgsConstructor
@ToString
@Getter
public class GrupoDtoIn {
    private String nome;
    private List<PerguntaDtoIn> perguntas;
}
