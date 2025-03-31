package com.ceuma.neuroapi.adapters.outbound.dto.paciente;


import com.ceuma.neuroapi.domain.models.Paciente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


/*PacienteDto uma super classe responsavel por guarda dados de retorno*/
@AllArgsConstructor
@Getter
@Setter
public class PacienteDtoOut extends PacienteDto {

    public PacienteDtoOut(PacienteDtoIn pacienteDtoIn){
        this.nome = pacienteDtoIn.getNome();
        this.nascimento = pacienteDtoIn.getNascimento();
        this.sexo = pacienteDtoIn.getSexo();
        this.leito = pacienteDtoIn.getLeito();
            
    }
    public PacienteDtoOut(Paciente pacienteDtoIn){
        this.nome = pacienteDtoIn.getNome();
        this.nascimento = pacienteDtoIn.getDataDeNascimento();
        this.sexo = pacienteDtoIn.getSexo();
        this.leito = pacienteDtoIn.getLeito();
            
    }
}
