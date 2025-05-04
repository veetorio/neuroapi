package com.ceuma.neuroapi.adapters.outbound.dto.agendar;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import com.ceuma.neuroapi.adapters.outbound.dto.exams.AvaliacaoDtoOut;
import com.ceuma.neuroapi.adapters.outbound.dto.paciente.PacienteDtoOut;
import com.ceuma.neuroapi.adapters.outbound.dto.usuario.UsuarioDtoOut;
import com.ceuma.neuroapi.domain.models.Hospital;
import com.ceuma.neuroapi.domain.relations.Consulta;
import com.ceuma.neuroapi.domain.relations.MedicoResidente;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AgendarDtoOut {
    private String hospital;
    private List<AvaliacaoDtoOut> avaliacao;
    private LocalDate data;
    private UsuarioDtoOut residente;
    private UsuarioDtoOut medico;
    private PacienteDtoOut paciente;
    private List<Consulta> marcadas;

    public AgendarDtoOut(Consulta consulta){
        if (consulta != null && consulta.getFk_Consulta_residente_medico() != null) {
            this.avaliacao = consulta
                .getFk_Consulta_residente_medico()
                .getFk_residente()
                .getResidentes()
                .stream()
                .map(MedicoResidente::getFk_hospital)
                .map(Hospital::getAvaliacoes)
                .flatMap(List::stream)
                .map(AvaliacaoDtoOut::new)
                .toList();
                
            this.residente = new UsuarioDtoOut(consulta
                .getFk_Consulta_residente_medico()
                .getFk_residente());
        } else {
            this.avaliacao = List.of();
            this.residente = null;
        }

        if (consulta != null && consulta.getFk_Consulta_paciente() != null) {
            this.hospital = consulta
                .getFk_Consulta_paciente()
                .getFk_hospital()
                .getNome();
        } else {
            this.hospital = null;
        }

        this.data = consulta != null ? consulta.getDataDaConsulta() : null;
        this.marcadas = consulta != null ? List.of(consulta) : List.of();
    }

}
