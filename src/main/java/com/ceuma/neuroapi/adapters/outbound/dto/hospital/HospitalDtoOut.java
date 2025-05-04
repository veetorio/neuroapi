package com.ceuma.neuroapi.adapters.outbound.dto.hospital;

import java.util.List;

import com.ceuma.neuroapi.adapters.outbound.dto.exams.AvaliacaoDtoOut;
import com.ceuma.neuroapi.adapters.outbound.dto.paciente.PacienteDtoOut;
import com.ceuma.neuroapi.domain.models.Avaliacao;
import com.ceuma.neuroapi.domain.models.Hospital;
import com.ceuma.neuroapi.domain.models.Paciente;

import lombok.Getter;

/*
 * HospitalDto uma super classe responsavel por guarda dados de retorno
 */
@Getter
public class HospitalDtoOut extends HospitalDto {
    private Long id;
    List<PacienteDtoOut> pacientes;
    List<AvaliacaoDtoOut> avaliacoes;
    public HospitalDtoOut(Hospital hospital){
        super(hospital.getNome());
        this.id = hospital.getIdHospital();
        this.pacientes = hospital
            .getPacientes()
            .stream()
            .map(PacienteDtoOut::new)
            .toList();
        this.avaliacoes = hospital.getAvaliacoes().stream().map(AvaliacaoDtoOut::new).toList();
    }


}
