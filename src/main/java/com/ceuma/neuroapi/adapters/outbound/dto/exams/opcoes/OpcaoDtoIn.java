package com.ceuma.neuroapi.adapters.outbound.dto.exams.opcoes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class OpcaoDtoIn {
    private String descricao;
    private Long valor;
    private Long fkPegunta;
    
}
