package com.ceuma.neuroapi.adapters.outbound.dto.hospital;

import java.util.List;


import com.ceuma.neuroapi.adapters.outbound.dto.paciente.PacienteDtoOut;
import com.ceuma.neuroapi.domain.models.Hospital;

import lombok.Getter;

/*
 * HospitalDto uma super classe responsavel por guarda dados de retorno
 */
@Getter
public class HospitalDtoOut extends HospitalDto {
    List<PacienteDtoOut> pacientes;
    public HospitalDtoOut(Hospital hospital){
        super(hospital.getNome());
        this.pacientes = hospital
            .getPacientes()
            .stream()
            .map(PacienteDtoOut::new)
            .toList();
    }


}
