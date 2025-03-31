package com.ceuma.neuroapi.utils.validacoes;

import com.ceuma.neuroapi.adapters.outbound.dto.paciente.PacienteDtoIn;

public class ValidarCrendenciaisPaciente implements ValidarCredenciais {
    PacienteDtoIn pacienteDtoIn;

    
    public ValidarCrendenciaisPaciente(PacienteDtoIn pacienteDtoIn) {
        this.pacienteDtoIn = pacienteDtoIn;
    }

    @Override
    public boolean camposNulos(){
        return pacienteDtoIn.getNome() == null | pacienteDtoIn.getHospital() == null | pacienteDtoIn.getSexo() == null | pacienteDtoIn.getNascimento() == null ;
    }

    @Override
    public boolean camposVazios(){
        return pacienteDtoIn.getNome().isBlank()  | pacienteDtoIn.getLeito().isBlank();
    }

    @Override
    public boolean validarPattern(){
        return pacienteDtoIn.getNome().matches(".*[0-9@!$#&*()_+=].*");
    }
}
