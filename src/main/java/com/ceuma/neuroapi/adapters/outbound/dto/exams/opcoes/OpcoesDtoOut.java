package com.ceuma.neuroapi.adapters.outbound.dto.exams.opcoes;

import com.ceuma.neuroapi.domain.models.Opcao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
public class OpcoesDtoOut {
    private String descricao;
    private Long valor;

    public OpcoesDtoOut(Opcao opcao){
        this.descricao = opcao.getDescricao();
        this.valor = opcao.getValor();
    }


    
}
