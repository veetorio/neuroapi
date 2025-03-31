package com.ceuma.neuroapi.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ceuma.neuroapi.adapters.outbound.dto.paciente.PacienteDtoIn;
import com.ceuma.neuroapi.adapters.outbound.dto.paciente.PacienteDtoOut;
import com.ceuma.neuroapi.application.repositories.HospitalRepository;
import com.ceuma.neuroapi.application.repositories.PacienteRepository;
import com.ceuma.neuroapi.domain.models.Hospital;
import com.ceuma.neuroapi.domain.models.Paciente;
import com.ceuma.neuroapi.utils.validacoes.ValidarCrendenciaisPaciente;

/**
 * The `PacienteService` class in Java is responsible for creating and
 * retrieving patient records, with
 * dependencies on `PacienteRepository` and `HospitalRepository`.
 */

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    public PacienteDtoOut criarPaciente(PacienteDtoIn pacienteDtoIn) {

        // cria um Paciente para persistir no banco de dados
        Paciente paciente = new Paciente(pacienteDtoIn);

        // valida campos
        ValidarCrendenciaisPaciente validar = new ValidarCrendenciaisPaciente(pacienteDtoIn);

        if (validar.camposNulos())
            throw new Error("campos nulos");
        if (validar.camposVazios())
            throw new Error("campos vazios");
        if (validar.validarPattern())
            throw new Error("digitou caracteres errados");
        if (pacienteRepository.exists(Example.of(paciente)))
            throw new Error("este paciente já existe");

        // tras o registro correpondente e a chave estrangeira do pacienteDtoIn
        Hospital hospital = hospitalRepository.findById(pacienteDtoIn.getHospital()).orElseThrow();

        // pega a instancia de Paciente e guarda no seu atributo Hospital fk_hospital o
        // registro de hospital que buscamos algumas linhas atrás
        paciente.setFk_hospital(hospital);

        // salva a instancia de paciente no banco de dados
        pacienteRepository.save(paciente);

        return new PacienteDtoOut(pacienteDtoIn);
    }

    /*
     * param Long id , Identificador
     */
    public Paciente buscarPacientePorId(Long id) {
        return pacienteRepository.findById(id).orElseThrow();
    }

}
