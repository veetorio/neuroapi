package com.ceuma.neuroapi.adapters.outbound.dto.medicoresidente;

import com.ceuma.neuroapi.adapters.outbound.dto.hospital.HospitalDtoOut;
import com.ceuma.neuroapi.adapters.outbound.dto.usuario.UsuarioDtoOut;
import com.ceuma.neuroapi.domain.relations.MedicoResidente;

import lombok.Getter;

@Getter
public class MedicoResidenteDtoOut {
    HospitalDtoOut hospital;

    UsuarioDtoOut medico;

    UsuarioDtoOut residente;

    boolean status;

    public MedicoResidenteDtoOut(MedicoResidente mr){
        this.medico = new UsuarioDtoOut(mr.getFk_medico());
        this.residente = new UsuarioDtoOut(mr.getFk_residente());
        this.hospital = new HospitalDtoOut(mr.getFk_hospital());
        this.status = mr.getStatusResidente();
    }
}
