package com.ceuma.neuroapi.adapters.outbound.dto.hospital;

import java.util.List;

import com.ceuma.neuroapi.adapters.outbound.dto.exams.AvaliacaoDtoOut;
import com.ceuma.neuroapi.domain.models.Avaliacao;
import com.ceuma.neuroapi.domain.models.Hospital;
import com.ceuma.neuroapi.domain.relations.AvaliacaoOpcao;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HospitalExposeProfileDto {
    private String nome;
    private List<AvaliacaoDtoOut> avaliacoes;

    public HospitalExposeProfileDto(Hospital hospital){
        this.nome = hospital.getNome();
        this.avaliacoes = hospital
            .getAvaliacoes()
            .stream()
            .map(AvaliacaoDtoOut::new)
            .toList();
    }
}
