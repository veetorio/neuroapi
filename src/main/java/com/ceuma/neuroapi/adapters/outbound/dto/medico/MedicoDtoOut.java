package com.ceuma.neuroapi.adapters.outbound.dto.medico;

import java.util.List;
import java.util.Objects;

import com.ceuma.neuroapi.adapters.outbound.dto.hospital.HospitalExposeProfileDto;
import com.ceuma.neuroapi.adapters.outbound.dto.paciente.PacienteDtoOut;
import com.ceuma.neuroapi.adapters.outbound.dto.usuario.UsuarioDtoOut;
import com.ceuma.neuroapi.domain.models.Usuario;
import com.ceuma.neuroapi.domain.relations.MedicoResidente;

import lombok.Getter;

@Getter
public class MedicoDtoOut extends UsuarioDtoOut {
    private String nome;
    private List<UsuarioDtoOut> residentes;
    private List<HospitalExposeProfileDto> hospitais;
    private List<PacienteDtoOut> pacientes;

    public MedicoDtoOut(Usuario usuario){
        super(usuario);
        this.nome = usuario.getNome();
        this.residentes = usuario
            .getResidentes()
            .stream()
            .map(e -> e.getFk_residente())
            .map(UsuarioDtoOut::new)
            .filter(Objects::nonNull)
            .toList();
        this.hospitais = usuario
            .getMedicos()
            .stream()
            .map(MedicoResidente::getFk_hospital)
            .filter(Objects::nonNull)
            .map(HospitalExposeProfileDto::new)
            .distinct()
            .toList();
        this.pacientes = usuario
            .getMedicos()
            .stream()
            .map(MedicoResidente::getFk_hospital)
            .flatMap(e -> e.getPacientes().stream())
            .map(PacienteDtoOut::new)
            .toList();
    }    
}
