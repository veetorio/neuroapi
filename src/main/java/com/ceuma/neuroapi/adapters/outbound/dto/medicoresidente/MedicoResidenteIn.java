package com.ceuma.neuroapi.adapters.outbound.dto.medicoresidente;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicoResidenteIn {

    // recebe a fk medico
    private Long medico;
    // recebe a fk residente
    private Long residente;
    // recebe a fk hospital
    private Long hospital;
    //recebe o status atual do residente
    private Boolean status;


    

    
    
}