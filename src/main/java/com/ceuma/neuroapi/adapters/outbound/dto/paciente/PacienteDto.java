package com.ceuma.neuroapi.adapters.outbound.dto.paciente;

import java.time.LocalDate;

import com.ceuma.neuroapi.domain.models.Paciente;
import com.ceuma.neuroapi.utils.enums.Sexo;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/* PacienteDto uma super classe responsavel por caracterizar DTOS com caracteristica do Pacientes */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PacienteDto {
    protected String nome;

    @Temporal(TemporalType.DATE)
    protected LocalDate nascimento;

    protected Sexo sexo;

    protected String leito;

    public PacienteDto(PacienteDtoIn pacienteDtoIn){

    }
    public PacienteDto(Paciente pacienteDtoIn){
        this.leito = pacienteDtoIn.getLeito();
        this.nascimento = pacienteDtoIn.getDataDeNascimento();
        this.nome = pacienteDtoIn.getNome();
        this.sexo = pacienteDtoIn.getSexo();

    }

}
