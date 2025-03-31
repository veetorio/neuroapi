package com.ceuma.neuroapi.adapters.outbound.dto.hospital;

import java.util.List;

import com.ceuma.neuroapi.adapters.outbound.dto.paciente.PacienteDtoIn;

import lombok.Getter;


/**
 *  Herda de HospitalDto uma classe filha com objetivo de receber dados de adaptadores de entrada
 */
@Getter
public class HospitalDtoIn extends HospitalDto {
    List<PacienteDtoIn> pacientesIn;
    public HospitalDtoIn(String nome,List<PacienteDtoIn> list){
        super(nome);
        this.pacientesIn = list;

    }
    
}
