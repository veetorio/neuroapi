package com.ceuma.neuroapi.utils.validacoes;

import com.ceuma.neuroapi.adapters.outbound.dto.hospital.HospitalDtoIn;

public class ValidarCrendenciaisHospital implements ValidarCredenciais {
    private HospitalDtoIn hospitalDto;

    
    public ValidarCrendenciaisHospital(HospitalDtoIn hospitalDto) {
        this.hospitalDto = hospitalDto;
    }

    @Override
    public boolean camposNulos(){
        return hospitalDto.getNome() == null | hospitalDto.getPacientesIn() == null;
    }

    @Override
    public boolean camposVazios(){
        return hospitalDto.getNome().isBlank() | hospitalDto.getPacientesIn().isEmpty();
    }

    @Override
    public boolean validarPattern(){
        return hospitalDto.getNome().matches(".*[0-9@!$#&*()_+=].*");
    }
    


}
