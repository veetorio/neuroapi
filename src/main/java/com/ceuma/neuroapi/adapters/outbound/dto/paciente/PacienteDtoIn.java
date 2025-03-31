package com.ceuma.neuroapi.adapters.outbound.dto.paciente;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


/*Herda de PacienteDtoIn uma classe filha com objetivo de receber dados de adaptadores de entrada*/
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class PacienteDtoIn extends PacienteDto {
    private Long hospital;
    


}
